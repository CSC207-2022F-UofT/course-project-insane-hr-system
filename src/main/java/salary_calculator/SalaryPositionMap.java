package salary_calculator;

import entity.Position;
import entity.Role;

public class SalaryPositionMap {
    static Integer getHourSalaryByPosition(Role role) throws IllegalArgumentException {
        if (role.getPosition() == Position.CEO) {
            return 100;
        } else if (role.getPosition() == Position.DEPARTMENT_HEAD) {
            return 50;
        } else if (role.getPosition() == Position.PROJECT_HEAD) {
            return 25;
        } else if (role.getPosition() == Position.MEMBER) {
            return 20;
        } else throw new IllegalArgumentException();
    }
}
