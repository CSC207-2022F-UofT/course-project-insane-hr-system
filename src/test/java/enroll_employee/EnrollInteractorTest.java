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

        EnrollDsGateway enrollDsGateway = new IMEnrollEmployee();

        EnrollOutputBoundary enrollOutputBoundary = new EnrollPresenter(){
            @Override
            public EnrollResponseModel prepareSuccessView(EnrollResponseModel responseModel) {
                //assertEquals("Kelly Zhang", responseModel.getName());
                assertEquals(100007, responseModel.getId());
                assertEquals("Zhan0002", responseModel.getUsername());
                assertEquals("Zhan0002", responseModel.getPassword());
                //assertEquals("Zhan0002", responseModel.getUsername());
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
        //assertEquals(dpt2.getHead(), 100007);

    }

    @Test
    void getAllDpts() {
    }
}