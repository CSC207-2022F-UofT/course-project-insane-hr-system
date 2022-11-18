package salary_calculator;

import java.time.LocalDate;

public class PayStub {
    private LocalDate paymentDate;
    private Integer uid;
    private String username;
    private String name;
    private Integer bonusSalary;
    private Integer hourSalary;
    private Integer totalSalary;

    public PayStub(LocalDate paymentDate, Integer uid, String username, String name, Integer bonusSalary, Integer hourSalary) {
        this.paymentDate = paymentDate;
        this.uid = uid;
        this.username = username;
        this.name = name;
        this.bonusSalary = bonusSalary;
        this.hourSalary = hourSalary;
        this.totalSalary = this.bonusSalary + this.hourSalary;
    }

    public PayStub() {
    }

    @Override
    public String toString() {
        return String.format("Date: %s  uID: %s  username: %s  name: %s  " +
                        "BonusSalary: %d HourSalary: %d  TotalSalary: %d",
                this.paymentDate, this.uid, this.username, this.name,
                this.bonusSalary, this.hourSalary, this.totalSalary);
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(Integer bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public Integer getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(Integer hourSalary) {
        this.hourSalary = hourSalary;
    }

    public Integer getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Integer totalSalary) {
        this.totalSalary = totalSalary;
    }
}
