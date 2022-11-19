package salary_calculator;

import entity.Curr;
import entity.User;

import java.time.LocalDate;

public class SalaryCalculatorInteractor implements SalaryCalculatorInputBoundary{
    private SalaryCalculatorGateway gateway;
    private SalaryCalculateRules rules;
    private SalaryCalculatorOutputBoundary outputBoundary;

    @Override
    public SalaryResponseModel requestSalary(SalaryRequestModel input) throws IllegalArgumentException {

        User requester = Curr.getUser();
        Integer targetID = input.getTargetID();
        LocalDate givenStartDate = input.getStartDate();
        LocalDate givenEndDate = input.getEndDate();

        LocalDate startDate = getFormedStartDate(givenStartDate);
        LocalDate endDate = getFormedEndDate(givenEndDate);
        User target;

        if (startDate.compareTo(endDate) < 0) {
            target = gateway.getUserInPeriod(targetID, startDate, endDate);
        } else {
            target = gateway.getUserInPeriod(targetID, startDate, startDate);
        }

        // TODO
        return null;
    }



    private LocalDate getFormedEndDate(LocalDate givenEndDate) {
        LocalDate endDate;
        if (givenEndDate.getDayOfMonth() < rules.restDate) {
            LocalDate tempDate = givenEndDate.plusMonths(-1);
            endDate = tempDate.plusDays(rules.restDate - tempDate.getDayOfMonth());
        } else {
            endDate = givenEndDate.plusDays(rules.restDate - givenEndDate.getDayOfMonth());
        }
        return endDate;
    }

    private LocalDate getFormedStartDate(LocalDate givenStartDate) {
        LocalDate startDate;
        if (givenStartDate.getDayOfMonth() > rules.restDate) {
            startDate = givenStartDate.plusMonths(1)
                    .plusDays(rules.restDate - givenStartDate.plusMonths(1).getDayOfMonth());
        } else {
            startDate = givenStartDate.plusDays(rules.restDate - givenStartDate.getDayOfMonth());
        }
        return startDate;
    }
}
