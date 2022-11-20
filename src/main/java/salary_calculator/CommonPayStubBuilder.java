package salary_calculator;

import entity.User;

import java.time.LocalDate;

public class CommonPayStubBuilder implements PayStubBuilder{
    private final SalaryCalculator calculator;
    public CommonPayStubBuilder(SalaryCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public PayStub buildPayStubByUser(User user, LocalDate startDate) {
        PayStub payStub = new PayStub();
        payStub.setUid(user.getId());
        payStub.setName(user.getName());
        payStub.setUsername(user.getUsername());
        payStub.setBonusSalary(calculator.getBonusSalary(user));
        payStub.setHourSalary(calculator.getHourSalary(user));

        // TODO
        return payStub;
    }
}
