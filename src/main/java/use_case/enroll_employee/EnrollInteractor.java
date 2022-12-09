package use_case.enroll_employee;

import entity.*;
import entity.project.Project;
import entity.role.Position;
import entity.role.Role;
import entity.task.Task;
import entity.user.User;
import entity.user.UserFactory;

import java.time.LocalDate;
import java.util.*;

public class EnrollInteractor implements EnrollInputBoundary{


    final EnrollDsGateway enrolldsGateway;
    final EnrollOutputBoundary enrollOutputBoundary;
    final UserFactory userFactory;

    /**
     * Get information and save in the database, get and show the information in user interface.
     * @param enrolldsGateway is the interface that connect the data access with the use case
     * @param enrollOutputBoundary is the interface that connect the framework with the use case.
     * @param userFactory is the interface that connect the entity with use case.
     */

    public EnrollInteractor(EnrollDsGateway enrolldsGateway, EnrollOutputBoundary enrollOutputBoundary, UserFactory userFactory) {
        this.enrolldsGateway = enrolldsGateway;

        //this.enrolldsGateway = new IMEnrollEmployee();
        this.enrollOutputBoundary = enrollOutputBoundary;
        this.userFactory = userFactory;
    }

    /**
     * Based on the user input information to create a new user.
     * @param requestModel contains all the user input information
     * @return a reponse model that contains the generated user id, username and user password.
     */
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
        List<Role> roles = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        Position position = Position.valueOf(requestModel.getPosition());

        LocalDate onboardDate = LocalDate.now();

        User user = userFactory.create(id,dpt,"",username,password,roles,projects,tasks, position,onboardDate);
        user.setName(requestModel.getName());

        if (position.equals(Position.MEMBER)){
            dpt.addMember(user.getId());
        }
        if (position.equals(Position.HEAD)){
            dpt.setHead(user.getId());
        }
        EnrollDsRequestModel dsRequestModel = new EnrollDsRequestModel(user);
        enrolldsGateway.save(dsRequestModel);
        enrolldsGateway.updateDepartment(dpt);

        EnrollResponseModel responseModel = new EnrollResponseModel(user.getName(),user.getId(), user.getUsername(), user.getPassword(), user.getOnboardDate());
        return enrollOutputBoundary.prepareSuccessView(responseModel);

    }


    /**
     * Get all the department names in our database
     * @return a list string that contains the name of all the departments in our database.
     */
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
