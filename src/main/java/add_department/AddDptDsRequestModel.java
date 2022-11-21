package add_department;

import entity.Department;
import entity.Organization;

public class AddDptDsRequestModel {
    private Organization department;

    public AddDptDsRequestModel(Organization department) {
        this.department = department;
    }
}
