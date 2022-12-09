package use_case.check_profile_validation;

import entity.*;
import entity.project.CommonProject;
import entity.project.LeaveRequestProject;
import entity.project.Project;
import entity.role.*;
import entity.task.CommonTask;
import entity.task.LeaveRequestTask;
import entity.task.StarEvaluationTask;
import entity.task.Task;
import entity.user.User;
import presenter.CheckProfilePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CheckProfileInteractor implements CheckProfileInputBoundary {

    private final CheckProfileIGateway gateway;
    private final CheckProfileOutputBoundary outputBoundary;

    public CheckProfileInteractor(CheckProfileIGateway gateway, CheckProfileOutputBoundary outputBoundary) {
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    public CheckProfileInteractor(CheckProfileIGateway gateway) {
        this.gateway = gateway;
        this.outputBoundary = new CheckProfilePresenter();
    }

    @Override
    public CheckProfileResponseModel checkUserProfile(CheckUserFileRequestModel requestModel) {
        User requester = gateway.getUserByUid(requestModel.getRequester());
        User target = gateway.getUserByUid(requestModel.getUid());

        CheckProfileResponseModel responseModel = new CheckProfileResponseModel(gateway);

        responseModel.setFileType(FileType.USER_FILE);
        responseModel.setTargetUid(target.getId());
        responseModel.setDpt(requester.getDpt().getOid());
        responseModel.setName(target.getName());
        responseModel.setRelation(RoleAllowed.getRelation(requester, target));
        responseModel.setBio(target.getBio() +"\nPosition:" + target.getPosition() + "\nOnboarding at" + target.getOnboardDate() + "\nStatus: " + target.getStatus());

        VisualLevel visualLevel = getVisibility(requester, target);
        responseModel.setVisualLevel(visualLevel);

        if (visualLevel == VisualLevel.ONLY_FACE){
            responseModel.setTargetUid(target.getId());
        }else if (visualLevel != VisualLevel.INVISIBLE) {
            List<Organization> orgs1 = new ArrayList<>(target.getTasks());
            List<Object> results1= getVisibleOrganizations(requester, (orgs1));
            responseModel.setList1(results1);
            responseModel.setList1Name("Tasks");
            responseModel.setReference1(getOReference(target.getTasks().toArray(new Organization[0])));
            List<Organization> orgs2 = new ArrayList<>(target.getProjects());
            List<Object> results2= getVisibleOrganizations(requester, (orgs2));
            responseModel.setList2(results2);
            responseModel.setList2Name("Projects");
            responseModel.setReference2(getOReference(target.getProjects().toArray(new Organization[0])));

        }


        outputBoundary.prepareUserFrame(responseModel);
        return responseModel;
    }

    private Object[] getOReference(Organization[] orgs) {
        Object[] results = new Object[orgs.length];
        for (int i = 0; i < orgs.length; i ++) {
            results[i] = orgs[i].getOid();
        }
        return results;
    }


    @Override
    public CheckProfileResponseModel checkOrgProfile(CheckOrgFileRequestModel requestModel) {
        User requester = gateway.getUserByUid(requestModel.getRequester());
        Organization target = gateway.getOrgByOid(requestModel.getOid());

        VisualLevel visualLevel = getVisibility(requester, target);

        CheckProfileResponseModel responseModel = new CheckProfileResponseModel(gateway);

        responseModel.setDpt(requester.getDpt().getOid());
        responseModel.setFileType(getFileType(target));
        responseModel.setVisualLevel(visualLevel);
        responseModel.setRelation(RoleAllowed.getRelation(requester, target));
        responseModel.setTargetOid(target.getOid());
        setRelativeRelation(requester, responseModel, target.getOid(), target);

        responseModel.setBio(target.getDescription());

        responseModel.setName(target.getName());
        if (visualLevel == VisualLevel.ONLY_FACE){
            responseModel.setTargetOid(target.getOid());
        } else if (visualLevel != VisualLevel.INVISIBLE) {
            setTables(requester, target, responseModel);
            responseModel.setList1Name(getList1Name(getFileType(target)));
            responseModel.setList2Name(getList2Name(getFileType(target)));
        }
        outputBoundary.prepareOrgFrame(responseModel);
        return responseModel;
    }
    FileType getFileType(Object target) {
        if (target instanceof Department){
            return FileType.DEPARTMENT_FILE;
        }else if (target instanceof CommonProject) {
            return FileType.PROJECT_FILE;
        } else if (target instanceof LeaveRequestProject) {
            return FileType.LEAVE_REQUEST_PROJECT_FILE;
        }else if (target instanceof LeaveRequestTask) {
            return FileType.LEAVE_REQUEST_TASK_FILE;
        }else if (target instanceof StarEvaluationTask) {
            return FileType.EVALUATION_TASK_FILE;
        }else if (target instanceof CommonTask) {
                return FileType.TASK_FILE;
            }else if (target instanceof User) {
                return FileType.USER_FILE;
            }
        return null;
    }
    void setTables(User requester, Organization target, CheckProfileResponseModel responseModel){
        if (target instanceof Department){
            responseModel.setList1(getOrgVisibleMembers(requester, target));
            responseModel.setReference1(target.getMembers().toArray(new Object[0]));
            responseModel.setList2(getDptVisibleProject(requester, (Department) target));
            responseModel.setReference2(((Department) target).getProjects().toArray(new Object[0]));
        }else if (target instanceof Project) {
            responseModel.setList1(getOrgVisibleMembers(requester, target));
            responseModel.setReference1(target.getMembers().toArray(new Integer[0]));
            responseModel.setList2(getDptVisibleTasks(requester, (Project) target));
            responseModel.setReference2(getOReference(((Project) target).getTasks().toArray(new Task[0])));
        }else if (target instanceof Task) {
            responseModel.setList1(getOrgVisibleMembers(requester, target));
            responseModel.setReference1(target.getMembers().toArray(new Integer[0]));
        }
    }
    String getList1Name(FileType fileType) {
        switch (fileType) {
            case TASK_FILE:
            case EVALUATION_TASK_FILE:
            case LEAVE_REQUEST_TASK_FILE:
            case DEPARTMENT_FILE:
            case PROJECT_FILE:
                return "Members";
            case USER_FILE:return "Tasks";
        }
        return null;
    }
    String getList2Name(FileType fileType) {
        switch (fileType) {
            case EVALUATION_TASK_FILE:
            case LEAVE_REQUEST_TASK_FILE:
            case TASK_FILE:return null;
            case USER_FILE:return "Projects";
            case PROJECT_FILE:return "Tasks";
            case DEPARTMENT_FILE:return "Projects";
        }
        return null;
    }

    /**
     *
     */
    @Override
    public void update() {

    }

    @Override
    public CheckProfileOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }


    // Helper methods.

    private void setRelativeRelation(User requester, CheckProfileResponseModel responseModel, UUID oid, Organization target) {
        List<CommonRole> roles = RoleAllowed.roleOfOrg(requester.getRoles(), oid);
        for (CommonRole role : roles) {
            if (role.getPosition() == Position.HEAD) {
                if(roles.size() != 2) {
                    throw new RuntimeException("Role Loading Mistake");
                }
            }
        }
        if(roles.size() == 2) responseModel.setRelation(RelativeRelation.IS_HEAD_OF);
        else if (roles.size() == 1) responseModel.setRelation(RelativeRelation.IS_MEMBER_OF);
        else if(roles.size() != 0) throw new RuntimeException("Role Loading Mistake");
    }

    private List<Object> getDptVisibleTasks(User requester, Project target) {
        List<Organization> orgs2 = new ArrayList<>(target.getTasks());
        return getVisibleOrganizations(requester, orgs2);
    }
    private List<Object> getDptVisibleProject(User requester, Department target) {
        List<Organization> orgs = new ArrayList<>();
        for (UUID oid : target.getProjects()) {
            orgs.add(gateway.getOrgByOid(oid));
        }
        List<Organization> orgs2 = new ArrayList<>(orgs);
        return getVisibleOrganizations(requester, orgs2);
    }
    private List<Object> getOrgVisibleMembers(User requester, Organization target) {
        List<User> users = new ArrayList<>();
        for (int uid : target.getMembers()) {
            users.add(gateway.getUserByUid(uid));
        }
        return getVisibleUsers(requester, (users));
    }


    // Helper methods for helper methods.
    private List<Object> getVisibleOrganizations(User requester, List<Organization> organizations) {
        List<Object> results = new ArrayList<>();
        for (Organization org : organizations) {
            if (getVisibility(requester, org) != VisualLevel.INVISIBLE) {
                results.add(org);
            }
        }
        return results;
    }
    private List<Object> getVisibleUsers(User requester, List<User> users) {
        List<Object> results = new ArrayList<>();
        for (User user : users) {
            if (getVisibility(requester, user) != VisualLevel.INVISIBLE) {
                results.add(user);
            }
        }
        return results;
    }


    private VisualLevel getVisibility(User requester, Organization org) {
        if (Objects.equals(org.getState(), Constants.CLOSED)){
            return VisualLevel.INVISIBLE;
        }
        if (org instanceof Department) {
            return getVisibility(requester, ((Department) org));
        } else if (org instanceof Project) {
            return getVisibility(requester, ((Project) org));
        } else if (org instanceof Task) {
            return getVisibility(requester, ((Task) org));
        }
        return VisualLevel.INVISIBLE;
    }
    private VisualLevel getVisibility(User user, Task task) {
        if (!user.getProjects().contains(task.getProject())) {
            return VisualLevel.INVISIBLE;
        }else if (user.getTasks().contains(task)){
            return VisualLevel.EDITABLE;
        }
        return VisualLevel.ONLY_FACE;
    }
    private VisualLevel getVisibility(User user, Project project) {
        if (user.getProjects().contains(project)){
            return VisualLevel.EDITABLE;
        }else if (project instanceof CommonProject){
            if (user.getDpt().equals(project.getDpt())){
                return VisualLevel.PROFILE;
            }
        }
        return VisualLevel.ONLY_FACE;
    }
    private VisualLevel getVisibility(User user, Department dpt) {
        if (user.getDpt().equals(dpt)){
            return VisualLevel.EDITABLE;
        }
        return VisualLevel.PROFILE;
    }
    private VisualLevel getVisibility(User user1, User user2) {
        List<Role> r1 = user1.getRoles();
        List<Role> r2 = user2.getRoles();
        if (user1.equals(user2)) {
            return VisualLevel.EDITABLE;
        }
        if (RoleAllowed.isHeadOf(r1, r2) && !RoleAllowed.isHeadOf(r2, r1)) {
            return VisualLevel.EDITABLE;
        } else if (RoleAllowed.isHeadOf(r2, r1)) {
            return VisualLevel.ONLY_FACE;
        } else if (user1.getDpt().getOid().equals(user2.getDpt().getOid())) {
            return VisualLevel.PROFILE;
        }
        return VisualLevel.INVISIBLE;
    }

    List<Organization> getOrgnizations(List<Organization> organizations) {
        List<Organization> results = new ArrayList<>();
        for (Organization org : organizations) {
            if (isCommon(org)) results.add(org);
        }
        return results;
    }

    List<Organization> getUncommonOrgnizations (List<Organization> organizations) {
        List<Organization> results = new ArrayList<>();
        for (Organization org : organizations) {
            if (!isCommon(org)) results.add(org);
        }
        return results;
    }
    private boolean isCommon(Organization org) {
        return org instanceof CommonProject || org instanceof CommonTask || org instanceof Department;
    }


}
