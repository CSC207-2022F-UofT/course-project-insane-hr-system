package presenter;

import salary_calculator.SalaryResponseModel;

public interface SalaryIView {
    void prepareSucceedPage(SalaryResponseModel salaryResponseModel);
    void prepareFailedPage();
}
