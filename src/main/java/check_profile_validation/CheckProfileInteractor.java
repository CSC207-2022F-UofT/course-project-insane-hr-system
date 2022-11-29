package check_profile_validation;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckProfileInteractor implements CheckProfileInputBoundary {

    private final CheckProfileGateway gateway;
    private final CheckProfileOutputBoundary outputBoundary;

    public CheckProfileInteractor(CheckProfileGateway gateway, CheckProfileOutputBoundary outputBoundary) {
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public CheckProfileResponseModel checkUserProfile(CheckUserFileRequestModel requestModel) {
        User requester = gateway.getUserByUid(requestModel.getRequester());
        User target = gateway.getUserByUid(requestModel.getUid());
        int visualLevel = getVisibility(requester, target);

        CheckProfileResponseModel responseModel = new CheckProfileResponseModel(gateway);

        responseModel.setFileType(FileType.USER_FILE);

        responseModel.setVisualLevel(visualLevel);
        responseModel.setName(target.getName() + " File");
        responseModel.setRelation(RoleAllowed.getRelation(requester, target));

        if (visualLevel == VisualLevel.INVISIBLE) {
            return responseModel;
        }
        responseModel.setUid(target.getId());

        if (visualLevel == VisualLevel.ONLY_FACE){
            return responseModel;
        }

        List<Organization> orgs1 = new ArrayList<>(target.getTasks());
        List<Object> results1= getVisibleOrganizations(requester, getCommonOrgnizations(orgs1));
        responseModel.setList1(results1);
        responseModel.setList1Name("Tasks");
        List<Organization> orgs2 = new ArrayList<>(target.getProjects());
        List<Object> results2= getVisibleOrganizations(requester, getCommonOrgnizations(orgs2));
        responseModel.setList2(results2);
        responseModel.setList2Name("Projects");

        if (requester.equals(target)) {
            responseModel.setName(target.getName());
            List<Organization> orgs3 = new ArrayList<>(target.getTasks());

            List<Object> results3= getVisibleOrganizations(requester, getUncommonOrgnizations(orgs3));
            responseModel.getList1().addAll(results3);
            responseModel.setReference1(getOReference(target.getTasks().toArray(new Organization[0])));
            List<Organization> orgs4 = new ArrayList<>(target.getProjects());
            List<Object> results4= getVisibleOrganizations(requester, getUncommonOrgnizations(orgs4));
            responseModel.getList1().addAll(results4);
            responseModel.setReference1(getOReference(target.getProjects().toArray(new Organization[0])));
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
        Organization target = gateway.getOrgByOid(requestModel.getOid());


        if(target instanceof Department) {
            return checkDepartmentProfile(requestModel, (Department) target);
        } else if (target instanceof Project) {
            return checkProjectProfile(requestModel, (Project) target);
        } else if (target instanceof Task) {
            return checkTaskProfile(requestModel, (Task) target);
        }
        throw new RuntimeException("Invalid Profile request");
    }

    /**
     *
     */
    @Override
    public void update() {

    }


    // Helper methods.
    private CheckProfileResponseModel checkDepartmentProfile(CheckOrgFileRequestModel requestModel, Department target) {
        User requester = gateway.getUserByUid(requestModel.getRequester());
        int visualLevel = getVisibility(requester, target);

        CheckProfileResponseModel responseModel = new CheckProfileResponseModel(gateway);
        responseModel.setFileType(FileType.DEPARTMENT_FILE);
        responseModel.setVisualLevel(visualLevel);
        responseModel.setRelation(RelativeRelation.NO_RELATION);
        setRelativeRelation(requester, responseModel, target.getOid(), target);


        responseModel.setName(target.getName() + " Department File");
        if (visualLevel == VisualLevel.INVISIBLE) {
            return responseModel;
        }
        responseModel.setOid(target.getOid());

        if (visualLevel == VisualLevel.ONLY_FACE){
            return responseModel;
        }

        responseModel.setList1(getOrgVisibleMembers(requester, target));
        responseModel.setList1Name("Members");
        responseModel.setReference1(target.getMembers().toArray(new Integer[0]));
        responseModel.setList2(getDptVisibleProject(requester, target));
        responseModel.setList2Name("Projects");

        outputBoundary.prepareOrgFrame(responseModel);
        return responseModel;
    }
    private CheckProfileResponseModel checkProjectProfile(CheckOrgFileRequestModel requestModel, Project target) {
        User requester = gateway.getUserByUid(requestModel.getRequester());
        int visualLevel = getVisibility(requester, target);

        CheckProfileResponseModel responseModel = new CheckProfileResponseModel(gateway);
        responseModel.setFileType(FileType.PROJECT_FILE);
        responseModel.setVisualLevel(visualLevel);
        responseModel.setRelation(RelativeRelation.NO_RELATION);
        setRelativeRelation(requester, responseModel, target.getOid(), target);


        responseModel.setName(responseModel.getName() + " Project File");
        if (visualLevel == VisualLevel.INVISIBLE) {
            return responseModel;
        }
        responseModel.setOid(target.getOid());

        if (visualLevel == VisualLevel.ONLY_FACE){
            return responseModel;
        }

        responseModel.setList1(getOrgVisibleMembers(requester, target));
        responseModel.setList1Name("Members");
        responseModel.setList2(getDptVisibleTasks(requester, target));
        responseModel.setList2Name("Tasks");
        outputBoundary.prepareOrgFrame(responseModel);
        return responseModel;
    }
    private CheckProfileResponseModel checkTaskProfile(CheckOrgFileRequestModel requestModel, Task target) {
        User requester = gateway.getUserByUid(requestModel.getRequester());
        int visualLevel = getVisibility(requester, target);

        CheckProfileResponseModel responseModel = new CheckProfileResponseModel(gateway);
        responseModel.setFileType(FileType.TASK_FILE);
        responseModel.setVisualLevel(visualLevel);
        setRelativeRelation(requester, responseModel, target.getOid(), target);


        responseModel.setName(responseModel.getName() + " Task File");
        if (visualLevel == VisualLevel.INVISIBLE) {
            return responseModel;
        }
        responseModel.setOid(target.getOid());

        if (visualLevel == VisualLevel.ONLY_FACE){
            return responseModel;
        }

        responseModel.setList1(getOrgVisibleMembers(requester, target));
        responseModel.setList1Name("Members");
        outputBoundary.prepareOrgFrame(responseModel);
        return responseModel;
    }

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


    private int getVisibility(User requester, Organization org) {
        if (!isCommon(org)) {
            return VisualLevel.INVISIBLE;
        } else if (org instanceof Department) {
            return getVisibility(requester, ((Department) org));
        } else if (org instanceof Project) {
            return getVisibility(requester, ((Project) org));
        } else if (org instanceof Task) {
            return getVisibility(requester, ((Task) org));
        }
        return VisualLevel.INVISIBLE;
    }
    private int getVisibility(User user, Task task) {
        if (!user.getProjects().contains(task.getProject())) {
            return VisualLevel.INVISIBLE;
        }else if (user.getTasks().contains(task)){
            return VisualLevel.EDITABLE;
        }
        return VisualLevel.ONLY_FACE;
    }
    private int getVisibility(User user, Project project) {

        if (user.getProjects().contains(project)){
            return VisualLevel.EDITABLE;
        }else if (project instanceof CommonProject){
            if (user.getDpt().equals(((CommonProject) project).getDpt())){
                return VisualLevel.PROFILE;
            }
        }
        return VisualLevel.ONLY_FACE;
    }
    private int getVisibility(User user, Department dpt) {
        if (user.getDpt().equals(dpt)){
            return VisualLevel.EDITABLE;
        }
        return VisualLevel.PROFILE;
    }
    private int getVisibility(User user1, User user2) {
        List<Role> r1 = user1.getRoles();
        List<Role> r2 = user2.getRoles();
        if (RoleAllowed.isHeadOf(r1, r2) && !RoleAllowed.isHeadOf(r2, r1)) {
            return VisualLevel.EDITABLE;
        } else if (RoleAllowed.isHeadOf(r2, r1)) {
            return VisualLevel.ONLY_FACE;
        } else if (user1.getDpt().equals(user2.getDpt())) {
            return VisualLevel.PROFILE;
        }
        return VisualLevel.INVISIBLE;
    }

    List<Organization> getCommonOrgnizations (List<Organization> organizations) {
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
