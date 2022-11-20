package employeeEnroll;

import entity.Department;

import javax.swing.text.Position;

public class EnrollRequestModel {
    private String name;
    private Department dpt;
    private Position position;

    public EnrollRequestModel(String name, Department dpt) {
        this.name = name;
        this.dpt = dpt;
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
}
