package use_case.salary_calculator;

import entity.user.User;

public interface SalaryCalculator {
    Integer getBonusSalary(User user);
    Integer getHourSalary(User user);
    Integer getTotalSalary(User user);
    Integer getBalance(User user);

    Integer getResetDate();
}
