package salary_calculator;

public class SalaryCalculateRules {
    public Integer salaryPerTask = 10;
    public Integer salaryPerHour = 20;
    public Integer salaryPerStar = 1;
    public Integer restDate = 5;

    public SalaryCalculateRules() {
    }

    public SalaryCalculateRules(Integer salaryPerTask, Integer salaryPerHour, Integer salaryPerStar, Integer restDate) {
        this.salaryPerTask = salaryPerTask;
        this.salaryPerHour = salaryPerHour;
        this.salaryPerStar = salaryPerStar;
        this.restDate = restDate;
    }
}
