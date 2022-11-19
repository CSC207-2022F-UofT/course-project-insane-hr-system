package salary_calculator;

import entity.User;

public class CommonPayStubBuilder implements PayStubBuilder{
    @Override
    public PayStub buildPayStubByUser(User user) {
        PayStub payStub = new PayStub();
        payStub.setUid(user.getId());

        // TODO
        return payStub;
    }
}
