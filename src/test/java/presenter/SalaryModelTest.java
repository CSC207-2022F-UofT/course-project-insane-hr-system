package presenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salary_calculator.PayStub;
import salary_calculator.SalaryResponseModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryModelTest {

    SalaryResponseModel responseModel;
    @Test
    void tableFormatter() {
        Object[][] result = SalaryModel.tableFormatter(responseModel);

    }

    @BeforeEach
    void setUp() {

        responseModel = new SalaryResponseModel();
        PayStub payStub = new PayStub(LocalDate.now(), 1, "username", "name", 100,100,0);
        List<PayStub> payStubList = new ArrayList<>();
        payStubList.add(payStub);
        responseModel.setPayStubs(payStubList);
    }
}