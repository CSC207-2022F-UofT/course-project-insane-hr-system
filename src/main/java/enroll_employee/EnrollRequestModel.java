package enroll_employee;

import entity.Department;
import entity.Position;


public class EnrollRequestModel {
    private String name;
    private Department dpt;
    private String position;

    public EnrollRequestModel(String name, Department dpt, String position) {
        this.name = name;
        this.dpt = dpt;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDpt() {
        return dpt;
    }

    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
