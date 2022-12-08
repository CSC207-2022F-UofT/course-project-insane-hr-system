package use_case.salary_calculator;

public interface SalaryCalculatorOutputBoundary {
    // This interface will be implemented by the presenter.
    // TODO: OutputBoundary will passing Output data into presenters.

    SalaryResponseModel prepareSucceedPage(SalaryResponseModel salaryResponseModel);
    SalaryResponseModel prepareFailedPage(String error);
}
