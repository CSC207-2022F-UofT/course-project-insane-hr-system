package salary_calculator;

import entity.User;

public interface PayStubBuilder {
    PayStub buildPayStubByUser(User user);
}
