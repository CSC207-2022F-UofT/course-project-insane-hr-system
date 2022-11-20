package salary_calculator;

import entity.Position;

public class SalaryPositionMap {
    static Integer getHourSalaryByPosition(Position position) throws IllegalArgumentException {
        if (position == Position.CEO) {
            return 100;
        } else if (position == Position.DepartmentHead) {
            return 50;
        } else if (position == Position.ProjectHead) {
            return 25;
        } else if (position == Position.Member) {
            return 20;
        } else throw new IllegalArgumentException();
    }
}
