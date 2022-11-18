package salary_calculator;

import entity.Curr;

import java.time.LocalDate;

public class SalaryRequestModel {
    private final Curr curr;
    private final Integer targetID;
    private LocalDate startDate;
    private LocalDate endDate;

    public SalaryRequestModel(Curr curr, Integer targetID, LocalDate startDate, LocalDate endDate) {
        this.curr = curr;
        this.targetID = targetID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SalaryRequestModel(Curr curr, Integer targetID) {
        this.curr = curr;
        this.targetID = targetID;
    }

    public Curr getCurr() {
        return curr;
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
