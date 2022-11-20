package salary_calculator;

import entity.User;

public class SalaryCalculateRules implements SalaryCalculator{
    public Integer salaryPerTask = 10;
    public Integer salaryPerHour = 20;
    public Integer salaryPerStar = 1;
    public Integer resetDate = 5;

    public SalaryCalculateRules() {
    }

    public SalaryCalculateRules(Integer salaryPerTask, Integer salaryPerHour, Integer salaryPerStar, Integer resetDate) {
        this.salaryPerTask = salaryPerTask;
        this.salaryPerHour = salaryPerHour;
        this.salaryPerStar = salaryPerStar;
        this.resetDate = resetDate;
    }

    @Override
    public Integer getBonusSalary(User user) {

        return null;
    }

    @Override
    public Integer getHourSalary(User user) {
        return null;
    }

    @Override
    public Integer getTotalSalary(User user) {
        return null;
    }

    @Override
    public Integer getBalance(User user) {
        return null;
    }

    @Override
    public Integer getResetDate() {
        return this.resetDate;
    }
}
