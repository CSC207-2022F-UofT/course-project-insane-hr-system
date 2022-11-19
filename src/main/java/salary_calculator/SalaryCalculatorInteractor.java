package salary_calculator;

import entity.CommonUser;
import entity.Curr;
import entity.User;
import jdk.jshell.spi.ExecutionControl;
import org.w3c.dom.ls.LSInput;

import javax.sound.sampled.FloatControl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
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
            summaUser = gateway.getUserInPeriod(input.getTargetID(), startDate, endDate);
        }catch (Exception IllegalArgumentException) {
            throw new IllegalArgumentException();
        }


        List<User> userFlow = separateSummaUser(summaUser);
        List<LocalDate> dateFlow = separateSummaDate(startDate, endDate);

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


    private List<LocalDate> separateSummaDate(LocalDate startDate, LocalDate endDate) {
        // TODO
        List<LocalDate> result = new ArrayList<>();
        result.add(LocalDate.now());
        return result;
    }

    private List<User> separateSummaUser(User summaUser) {
        // TODO
        List<User> results = new ArrayList<>();
        results.add(new CommonUser(1));
        return results;
    }

    private LocalDate getFormedEndDate(LocalDate givenEndDate) {
        LocalDate endDate;
        if (givenEndDate.getDayOfMonth() < rules.resetDate) {
            LocalDate tempDate = givenEndDate.plusMonths(-1);
            endDate = tempDate.plusDays(rules.resetDate - tempDate.getDayOfMonth());
        } else {
            endDate = givenEndDate.plusDays(rules.resetDate - givenEndDate.getDayOfMonth());
        }
        return endDate;
    }

    private LocalDate getFormedStartDate(LocalDate givenStartDate) {
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
