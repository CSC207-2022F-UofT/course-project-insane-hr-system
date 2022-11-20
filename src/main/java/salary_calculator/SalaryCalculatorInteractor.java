package salary_calculator;

import entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class SalaryCalculatorInteractor implements SalaryCalculatorInputBoundary{
    private SalaryCalculatorGateway gateway;
    private SalaryCalculateRules rules;
    private SalaryCalculatorOutputBoundary outputBoundary;

    @Override
    public SalaryResponseModel requestSalary(SalaryRequestModel input) throws IllegalArgumentException {

        SalaryResponseModel results = new SalaryResponseModel();
        User requester = Curr.getUser();
        Integer targetID = input.getTargetID();
        LocalDate givenStartDate = input.getStartDate();
        LocalDate givenEndDate = input.getEndDate();

        LocalDate startDate = getFormedStartDate(givenStartDate);
        LocalDate endDate = getFormedEndDate(givenEndDate);

        if (startDate.compareTo(endDate) > 0) {
            endDate =startDate;
        }

        User summaUser;
        try {
            summaUser = gateway.getUserInPeriod(targetID, startDate, endDate);
        }catch (Exception IllegalArgumentException) {
            throw new IllegalArgumentException();
        }

        List<LocalDate> dateFlow = separateSummaDate(startDate, endDate);
        List<User> userFlow = separateSummaUser(summaUser, dateFlow);

        SalaryCalculator calculator = new SalaryCalculateRules();

        PayStubBuilder payStubBuilder = new CommonPayStubBuilder(calculator);

            for (int i=0; i < userFlow.size(); i++) {
                results.addPayStub(payStubBuilder.buildPayStubByUser(userFlow.get(i), dateFlow.get(i)));
            }
        return results;
    }

    @Override
    public SalaryResponseModel paySalary(PaySalaryRequestModel paySalaryRequestModel) {
        return null;
    }


    public List<LocalDate> separateSummaDate(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> result = new ArrayList<>();
        LocalDate date = startDate;
        while (date.compareTo(endDate) < 0) {
            result.add(date);
            date = date.plusMonths(1);
        }
        return result;
    }

    public List<User> separateSummaUser(User summaUser, List<LocalDate> dateFlow) {
        List<User> results = new ArrayList<>();
        UserFactory factory = new CommonUserFactory();

        for (LocalDate date : dateFlow) {
            results.add(factory.createUserInPeriod(summaUser, date, date.plusMonths(1)));
        }
        return results;
    }


    public LocalDate getFormedEndDate(LocalDate givenEndDate) {
        LocalDate endDate;
        if (givenEndDate.getDayOfMonth() < rules.resetDate) {
            LocalDate tempDate = givenEndDate.plusMonths(-1);
            endDate = tempDate.plusDays(rules.resetDate - tempDate.getDayOfMonth());
        } else {
            endDate = givenEndDate.plusDays(rules.resetDate - givenEndDate.getDayOfMonth());
        }
        return endDate;
    }

    public LocalDate getFormedStartDate(LocalDate givenStartDate) {
        LocalDate startDate;
        if (givenStartDate.getDayOfMonth() > rules.resetDate) {
            startDate = givenStartDate.plusMonths(1)
                    .plusDays(rules.resetDate - givenStartDate.plusMonths(1).getDayOfMonth());
        } else {
            startDate = givenStartDate.plusDays(rules.resetDate - givenStartDate.getDayOfMonth());
        }
        return startDate;
    }
}
