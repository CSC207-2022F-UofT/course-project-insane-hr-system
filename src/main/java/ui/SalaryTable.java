package ui;

import presenter.DataFormatter;
import use_case.salary_calculator.PayStub;
import use_case.salary_calculator.SalaryResponseModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalaryTable {
    private JTable table1;
    private JScrollPane tablePanel;
    private JButton button1;
    private JPanel rootPanel;


    public SalaryTable() {
        button1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                SalaryResponseModel responseModel = new SalaryResponseModel();
                PayStub payStub = new PayStub(LocalDate.now(), 1, "username", "name", 100,100,0);
                List<PayStub> payStubList = new ArrayList<>();
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                payStubList.add(payStub);
                responseModel.setPayStubs(payStubList);
                getTableByResponseModel(responseModel);


            }
        });
    }


    public JTable getTable1() {
        return table1;
    }

    public JScrollPane getTablePanel() {
        return tablePanel;
    }

    public JButton getButton1() {
        return button1;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTable getTableByResponseModel(SalaryResponseModel results) {
        Object[][] objects = DataFormatter.tableFormatter(results);
        Object[] columnNameObj = objects[0];
        String[] columnName = new String[columnNameObj.length];
        for (int i=0;i<columnNameObj.length; i++) {
            columnName[i] = columnNameObj[i].toString();
        }
        Object[][] data = Arrays.copyOfRange(objects, 1, objects.length + 1);
        table1.setModel(new DefaultTableModel(data, columnName));
        return this.table1;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("SalaryTable");
        frame.setContentPane(new SalaryTable().getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
