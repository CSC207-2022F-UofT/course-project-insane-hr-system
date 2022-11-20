package salary_calculator;

import entity.Position;

public class SalaryPositionMap {
    static Integer getHourSalaryByPosition(Position position) throws IllegalArgumentException {
        if (position == Position.CEO) {
            return 100;
        } else if (position == Position.DEPARTMENT_HEAD) {
            return 50;
        } else if (position == Position.PROJECT_HEAD) {
            return 25;
        } else if (position == Position.MEMBER) {
            return 20;
        } else throw new IllegalArgumentException();
    }
}
