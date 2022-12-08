package ui;

import controller.RankController;
import data_access.RankDataAccess;
import entity.Curr;
import entity.Department;
import entity.user.CommonUser;
import entity.user.User;
import presenter.RankPresenter;
import use_case.rank_employees.*;
import use_case.unused_delete_employee.EmployeeDeleteScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class RankEmployeesScreen extends JPanel {

    public RankEmployeesScreen(int id){

        // get a response model.
        RankGateway data = new RankDataAccess();
        RankOutputBoundary output = new RankPresenter();
        RankInputBoundary input = new RankInteractor(data, output);
        RankController controller = new RankController(input);
        RankResponseModel response = controller.create(id);


        JLabel title = new JLabel("Employee Rankings");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // create a list of string names.

        DefaultListModel<String> rankedNames = new DefaultListModel<>();
        for(int i = 0; i < response.getRankedEmployees().size(); i++){
            String name = response.getRankedEmployees().get(i);
            rankedNames.addElement(name);
        }
        JList<String> employeeRanking = new JList<>();
        employeeRanking.setModel(rankedNames);

        this.add(new JScrollPane(employeeRanking));



    }


    public static void main(String[] args) {
        // for testing purposes.
        int id = 137;
        JFrame frame = new JFrame();
        frame.setContentPane(new RankEmployeesScreen(id));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
