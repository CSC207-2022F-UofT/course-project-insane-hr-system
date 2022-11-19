package salary_calculator;

import entity.User;

import java.time.LocalDate;

public interface SalaryCalculatorGateway {
    /**This gateway will return all history task and history project of the user in a period of time.
     *
     * @param targetID target user id
     * @param startDate start date of task and project
     * @param endDate end date of task and project
     * @return null iff startDate is later or equal to the endDate.
     * Throw IllegalArgumentException iff targetID is not in the domain.
     */
    User getUserInPeriod(Integer targetID, LocalDate startDate, LocalDate endDate) throws IllegalArgumentException;
}
