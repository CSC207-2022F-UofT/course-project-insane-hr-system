package enroll_employee;



public class EnrollRequestModel {
    private String name;
    private String dpt;
    private String position;

    public EnrollRequestModel(String name, String dpt, String position) {
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

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
