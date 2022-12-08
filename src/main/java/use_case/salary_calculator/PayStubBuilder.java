package use_case.salary_calculator;

import entity.User;

import java.time.LocalDate;

public interface PayStubBuilder {
    PayStub buildPayStubByUser(User user, LocalDate startDate);
}
