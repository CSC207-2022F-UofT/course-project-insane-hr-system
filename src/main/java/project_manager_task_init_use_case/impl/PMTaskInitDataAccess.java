package project_manager_task_init_use_case.impl;

import Utilities.SQLiteDataSource;
import project_manager_task_init_use_case.PMTaskInitGateway;
import project_manager_task_init_use_case.PMTaskInitRequestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;


public class PMTaskInitDataAccess implements PMTaskInitGateway {
    @Override
    public void saveTask(PMTaskInitRequestModel requestModel) {

        int rowsInserted = 0;
        Connection connection = SQLiteDataSource.getConnection();
        String sql = "insert into tasks ( task_id, project_id, task_name, task_description, task_leader_emp_id, task_status," +
                " task_rating, task_start_date, task_end_date) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement;
        try{
            System.out.println(connection);
            statement = connection.prepareStatement(sql);
            statement.setInt(1,requestModel.getEmployeeId());
            statement.setInt(2, 1);
            statement.setString(3, "Testing");
            statement.setString(4, "");
            statement.setInt(5, 1);
            statement.setString(6, "");
            statement.setString(7, "");
            statement.setString(8, "");
            statement.setString(9, "");

            rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }


    }




}
