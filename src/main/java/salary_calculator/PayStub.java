package salary_calculator;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class PayStub {
    private LocalDate startDate;
    private Integer uid;
    private String username;
    private String name;
    private Integer bonusSalary;
    private Integer hourSalary;
    private Integer totalSalary;
    private Integer balance;

    public PayStub(LocalDate paymentDate, Integer uid, String username, String name, Integer bonusSalary, Integer hourSalary, Integer balance) {
        this.startDate = paymentDate;
        this.uid = uid;
        this.username = username;
        this.name = name;
        this.bonusSalary = bonusSalary;
        this.hourSalary = hourSalary;
        this.balance = balance;
        this.totalSalary = this.bonusSalary + this.hourSalary;
    }

    public PayStub() {
    }

    @Override
    public String toString() {
        return String.format("Date: %s  uID: %s  username: %s  name: %s  " +
                        "BonusSalary: %d HourSalary: %d  TotalSalary: %d",
                this.startDate, this.uid, this.username, this.name,
                this.bonusSalary, this.hourSalary, this.totalSalary);
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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
