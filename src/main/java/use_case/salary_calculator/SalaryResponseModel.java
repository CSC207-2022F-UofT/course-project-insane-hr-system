package use_case.salary_calculator;

import java.util.ArrayList;
import java.util.List;

public class SalaryResponseModel {
    private List<PayStub> payStubs;

    public SalaryResponseModel() {
        this.payStubs = new ArrayList<>();
    }


    void addPayStub(PayStub payStub) {
        this.payStubs.add(payStub);
    }

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }
}
