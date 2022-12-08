package use_case.salary_calculator;

import java.time.LocalDate;

public class SalaryRequestModel {
    private final Integer targetID;
    private LocalDate startDate;
    private LocalDate endDate;

    public SalaryRequestModel(Integer targetID, LocalDate startDate, LocalDate endDate) {
        this.targetID = targetID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // construct without the endDate, this will construct a RequestModel with one month period.
    public SalaryRequestModel(Integer targetID, LocalDate startDate) {
        this.targetID = targetID;
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(1);
    }

    public SalaryRequestModel(Integer targetID) {
        this.targetID = targetID;
    }

    public Integer getTargetID() {
        return targetID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
