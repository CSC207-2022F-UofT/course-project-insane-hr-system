package enroll_employee;

import data_access.IMEnrollEmployee;
import entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class EnrollInteractor implements EnrollInputBoundary{
    final EnrollDsGateway enrolldsGateway;
    final EnrollOutputBoundary enrollOutputBoundary;
    final UserFactory userFactory;


    public EnrollInteractor(EnrollDsGateway enrolldsGateway, EnrollOutputBoundary enrollOutputBoundary, UserFactory userFactory) {
        //this.enrolldsGateway = enrolldsGateway;

        this.enrolldsGateway = new IMEnrollEmployee();
        this.enrollOutputBoundary = enrollOutputBoundary;
        this.userFactory = userFactory;
    }

    public EnrollResponseModel create(EnrollRequestModel requestModel){
        int id = enrolldsGateway.generateId();
        String name = requestModel.getName();
        if (Objects.equals(name, "")){
            return enrollOutputBoundary.prepareFailView("You have to input the name of the new employee!");
        }
        Department dpt = enrolldsGateway.findDptByName(requestModel.getDpt());
        String username = enrolldsGateway.generateUsername(name);
        String password; //By default, the password is the same as username
        password = username;
        List<Role> roles = new ArrayList<Role>();
        List<Project> projects = new ArrayList<Project>();
        List<Task> tasks = new ArrayList<Task>();
        Position position = Position.valueOf(requestModel.getPosition());

        LocalDate onboardDate = LocalDate.now();

        User user = userFactory.create(id,dpt,"",username,password,roles,projects,tasks, position,onboardDate);

        if (position.equals(Position.MEMBER)){
            dpt.addMember(user.getId());
        }
        if (position.equals(Position.HEAD)){
            dpt.setHead(user.getId());
        }
        EnrollDsRequestModel dsRequestModel = new EnrollDsRequestModel(user);
        enrolldsGateway.save(dsRequestModel);
        enrolldsGateway.updateDepartment(dpt);

        EnrollResponseModel responseModel = new EnrollResponseModel(user.getId(), user.getUsername(), user.getPassword(), user.getOnboardDate());
        return enrollOutputBoundary.prepareSuccessView(responseModel);

    }

    @Override
    public List<String> getAllDpts() {
        List<String> dptNames = new ArrayList<>();
        List<Department> dptEntity = enrolldsGateway.getAllDepartments();
        for (Department dpt: dptEntity){
            dptNames.add(dpt.getName());
        }
        return dptNames;
    }

}
