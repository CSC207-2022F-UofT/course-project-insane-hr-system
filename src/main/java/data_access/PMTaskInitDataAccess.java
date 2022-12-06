package data_access;

import DAO.CommonTaskDAO;
import project_manager_task_init_use_case.PMTaskInitDsRequestModel;
import project_manager_task_init_use_case.PMTaskInitGateway;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import static utilities.SQLiteDataSource.connection;


public class PMTaskInitDataAccess extends CommonTaskDAO implements PMTaskInitGateway {



    public PMTaskInitDataAccess() {

    }

    /**
     * saving the task from the dsrequestmodel in the database.
     */
    @Override
    public void saveTask(PMTaskInitDsRequestModel requestModel) {
        super.saveTask(requestModel.getTask());
    }

        // check the status of the task.
//        String sql;
//        if(requestModel.getTask().getState().equals("CLOSED")){
//            sql = "INSERT INTO tasks (id, projectID, name, description, head, status, start, type, end, results) VALUES (?,?,?,?,?,?,?,?,?,?)";
//        } else {
//            sql = "INSERT INTO tasks (id, projectID, name, description, head, status, start, type) VALUES (?,?,?,?,?,?,?)";
//        }
//
//        // insert data
//        PreparedStatement statement;
//
//        try {

            // connect to the database
//            statement = connection.prepareStatement(sql);

            // insert a new row
//            statement.setString(1, requestModel.getTask().getOid().toString());
//            statement.setString(2, requestModel.getTask().getProject().getOid().toString());
//            statement.setString(3, requestModel.getTask().getName());
//            statement.setString(4, requestModel.getTask().getDescription());
//            statement.setInt(5, requestModel.getTask().getHead());
//            statement.setString(6, requestModel.getTask().getState());
//            statement.setString(7, requestModel.getTask().getCreateTime().toString());
//            statement.setString(8, "COMMON");

            // if the task is closed, insert the rating and end date
//            if (requestModel.getTask().getState().equals("CLOSED")){
//                statement.setString(9, requestModel.getTask().getCloseTime().toString());
//                statement.setString(10, requestModel.getTask().getStar().toString());
//            }
//
//            statement.executeUpdate();

            // save all task members to the database as well
            //saveTaskMembers(task);
//
//            connection.commit();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
