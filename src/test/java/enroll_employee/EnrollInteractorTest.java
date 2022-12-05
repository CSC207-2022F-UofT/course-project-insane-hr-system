package enroll_employee;

import data_access.IMEnrollEmployee;
import entity.*;
import org.junit.jupiter.api.Test;
import presenter.EnrollPresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EnrollInteractorTest {

    @Test
    void create() {
        Set<Integer> s = new HashSet<>();
        Department dpt1 = new Department(UUID.randomUUID(),"Department1",null,s,"NOTHING", LocalDateTime.now());
        Department dpt2 = new Department(UUID.randomUUID(),"Department2",null,s,"NOTHING", LocalDateTime.now());
        Department dpt3 = new Department(UUID.randomUUID(),"Department3",null,s,"NOTHING", LocalDateTime.now());
        CommonUser u1 = new CommonUser(100001,dpt1,"n/a","Amy Wang");
        u1.setUsername("Wang0001");
        CommonUser u2 = new CommonUser(100002,dpt1,"n/a","Hanna Zhang");
        u2.setUsername("Zhan0001");
        CommonUser u3 = new CommonUser(100003,dpt1,"n/a","Jack Qwe");
        u3.setUsername("Qwee0001");
        CommonUser u4 = new CommonUser(100004,dpt2,"n/a","Petter Ma");
        u3.setUsername("Maaa0001");
        CommonUser u5 = new CommonUser(100005,dpt2,"n/a","Jennifer Green");
        u4.setUsername("Gree0001");
        CommonUser u6 = new CommonUser(100006,dpt3,"n/a","Ben Zhang");
        u6.setUsername("Zhan0002");
        List<Department> departments = Arrays.asList(dpt1,dpt2,dpt3);
        List<CommonUser> users = Arrays.asList(u1,u2,u3,u4,u5,u6);
        EnrollDsGateway enrollDsGateway = new IMEnrollEmployee(users, departments);

        EnrollOutputBoundary enrollOutputBoundary = new EnrollPresenter(){
            @Override
            public EnrollResponseModel prepareSuccessView(EnrollResponseModel responseModel) {
                assertEquals("Kelly Zhang", responseModel.getName());
                assertEquals("100007", responseModel.getId());
                assertEquals("Zhan0003", responseModel.getUsername());
                assertEquals("Zhan0003", responseModel.getPassword());
                assertEquals("Zhan0003", responseModel.getUsername());
                assertEquals(LocalDate.now().toString(), responseModel.getCreationTime().toString());
                return null;
            }

            @Override
            public EnrollResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        UserFactory userFactory = new CommonUserFactory();
        EnrollInputBoundary interactor = new EnrollInteractor(enrollDsGateway, enrollOutputBoundary,userFactory);

        EnrollRequestModel enrollRequestModel = new EnrollRequestModel("Kelly Zhang", "Department2", "HEAD");
        interactor.create(enrollRequestModel);
        assertEquals(dpt2.getHead(), 100007);


    }

    @Test
    void getAllDpts() {
    }
}