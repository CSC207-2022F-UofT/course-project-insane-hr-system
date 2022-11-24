package initialize_company;

import entity.Department;
import entity.User;

public class InitializationResponseModel {
    private final User ceo;
    private final Department firstDpt;

    public InitializationResponseModel(User ceo, Department firstDpt) {
        this.ceo = ceo;
        this.firstDpt = firstDpt;
    }

    public User getCeo() {
        return ceo;
    }

    public Department getFirstDpt() {
        return firstDpt;
    }
}
