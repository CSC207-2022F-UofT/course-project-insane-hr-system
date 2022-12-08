package ui;

import presenter.DataFormatter;
import presenter.RankPresenter;
import rank_employees.RankResponseModel;
import salary_calculator.PayStub;
import salary_calculator.SalaryResponseModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RankEmployeesScreen extends JFrame {
    private JButton button;
    public RankEmployeesScreen() {
        setTitle("Employee Rankings");
        setSize(200,200);
        RankPresenter presenter = new RankPresenter();
        JScrollPane scrollPane = new JScrollPane(getJList(new RankResponseModel()));

        button.addActionListener(e -> {
            add(scrollPane);
            setVisible(true);
        }

    }


    public JList getJList(RankResponseModel responseModel){
        DefaultListModel<String> employeeList = new DefaultListModel<>();
        for(int i = 0; i < responseModel.getRankedEmployees().size(); i++){
            employeeList.addElement(responseModel.getRankedEmployees().get(i).getName());
        }
        JList<String> rankedUsers = new JList<>(employeeList);
        return rankedUsers;

    }
}



