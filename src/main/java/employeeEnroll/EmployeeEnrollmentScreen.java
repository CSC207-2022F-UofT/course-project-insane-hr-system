package employeeEnroll;

import javax.swing.*;
import java.awt.*;

// unfinished

public class EmployeeEnrollmentScreen {
    JTextField name = new JTextField(15);
    EnrollController enrollController;

    public EmployeeEnrollmentScreen(EnrollController enrollController) {
        this.enrollController = enrollController;

        JLabel title = new JLabel("Enrollment Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

    }
}
