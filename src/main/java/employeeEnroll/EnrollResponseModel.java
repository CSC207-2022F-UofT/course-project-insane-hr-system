package employeeEnroll;

import entity.Department;

import java.time.LocalDate;

public class EnrollResponseModel {
    private String name;
    private int id;
    private String username;
    private String password;

    private LocalDate creationTime;



    public EnrollResponseModel(String name, int id, String username, String password, LocalDate creationTime) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;

        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public LocalDate getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDate date) {
        this.creationTime = date;
    }
}
