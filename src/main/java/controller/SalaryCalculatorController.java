package controller;

import salary_calculator.SalaryCalculatorInputBoundary;
import salary_calculator.SalaryRequestModel;
import salary_calculator.SalaryResponseModel;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class SalaryCalculatorController {
    private SalaryCalculatorInputBoundary userInput;

    public SalaryCalculatorController(SalaryCalculatorInputBoundary userInput) {
        this.userInput = userInput;
    }

    public SalaryResponseModel querySalary(Integer uid, String start, String end) throws InputMismatchException {
        LocalDate startDate;
        LocalDate endDate;

        try {
            startDate = LocalDate.of(
                    Integer.parseInt(start.substring(0, 4)),
                    Integer.parseInt(start.substring(4, 6)),
                    Integer.parseInt(start.substring(7, 9)));

            endDate = LocalDate.of(
                    Integer.parseInt(end.substring(0, 4)),
                    Integer.parseInt(end.substring(4, 6)),
                    Integer.parseInt(end.substring(7, 9)));
        } catch (Exception NumberFormatException) {
            throw new InputMismatchException("The input should be form of YYYY-MM-DD");
        }

        return userInput.requestSalary(new SalaryRequestModel(uid, startDate, endDate));
    }
}
