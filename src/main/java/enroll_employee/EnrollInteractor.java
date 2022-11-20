package enroll_employee;

import entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollInteractor implements EnrollInputBoundary{
    final EnrollDsGateway enrolldsGateway;
    final EnrollPresenter enrollPresenter;
    final UserFactory userFactory;


    public EnrollInteractor(EnrollDsGateway enrolldsGateway, EnrollPresenter enrollPresenter, UserFactory userFactory) {
        this.enrolldsGateway = enrolldsGateway;
        this.enrollPresenter = enrollPresenter;
        this.userFactory = userFactory;
    }

    public EnrollResponseModel create(EnrollRequestModel requestModel){
        int id = enrolldsGateway.generateId();
        String name = requestModel.getName();
        Department dpt = requestModel.getDpt();
        String username = enrolldsGateway.generateUsername(name);
        String password = "="+"user"+ LocalDate.now().getYear(); //default password: "=user2022"
        List<String> roles = new ArrayList<String>();
        List<Project> projects = new ArrayList<Project>();
        List<Task> tasks = new ArrayList<Task>();
        String position = requestModel.getPosition();
        LocalDate onboardDate = LocalDate.now();

        User user = userFactory.create(id,dpt,"",username,password,roles,projects,tasks, position,onboardDate);
        EnrollDsRequestModel dsRequestModel = new EnrollDsRequestModel(user);
        enrolldsGateway.save(dsRequestModel);

        EnrollResponseModel responseModel = new EnrollResponseModel(user.getName(), user.getId(), user.getUsername(), user.getPassword(), user.getOnboardDate());
        return enrollPresenter.prepareSuccessView(responseModel);

    }


}
