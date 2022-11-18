package salary_calculator;

import entity.User;

import java.time.LocalDate;

public interface SalaryCalculatorGateway {
    User getUserInPeriod(Integer targetID, LocalDate startDate, LocalDate endDate);
}
