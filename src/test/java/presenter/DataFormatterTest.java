package presenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.salary_calculator.PayStub;
import use_case.salary_calculator.SalaryResponseModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class DataFormatterTest {

    SalaryResponseModel responseModel;
    @Test
    void tableFormatter() {
        Object[][] result = DataFormatter.tableFormatter(responseModel);

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