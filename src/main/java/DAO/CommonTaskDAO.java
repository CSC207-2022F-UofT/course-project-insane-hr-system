package DAO;

import entity.CommonProject;
import entity.CommonTask;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import static utilities.SQLiteDataSource.connection;

public class CommonTaskDAO implements CommonTaskDAOInterface {

    /// save a task in the database ///

    public void createCommonTask(CommonTask task){

        // check the status of the task.
        String sql;
        if(task.getState().equals("CLOSED")){
            sql = "INSERT INTO tasks (id, projectID, name, description, head, status, start, type, end, results) VALUES (?,?,?,?,?,?,?,?,?,?)";
        } else {
            sql = "INSERT INTO tasks (id, projectID, name, description, head, status, start, type) VALUES (?,?,?,?,?,?,?)";
        }

        // insert data
        PreparedStatement statement;

        try {

            // connect to the database
            statement = connection.prepareStatement(sql);

            // insert a new row
            statement.setString(1, task.getOid().toString());
            statement.setString(2, task.getProject().getOid().toString());
            statement.setString(3, task.getName());
            statement.setString(4, task.getDescription());
            statement.setInt(5, task.getHead());
            statement.setString(6, task.getState());
            statement.setString(7, task.getCreateTime().toString());
            statement.setString(8, "COMMON");

            // if the task is closed, insert the rating and end date
            if (task.getState().equals("CLOSED")){
                statement.setString(9, task.getCloseTime().toString());
                statement.setString(10, task.getStar().toString());
            }

            statement.executeUpdate();

            // save all task members to the database as well
            saveTaskMembers(task);

            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    // delete a task in the database (won't be used externally) //

    public void deleteTask(UUID taskID){
        String sql = "DELETE FROM tasks WHERE ID=?";
        String sqlTaskMap = "DELETE FROM task_map WHERE ID=?";
        PreparedStatement statement;

        try {

            // create a connection to the database
            statement = connection.prepareStatement(sql);

            // delete the task with the given oid.
            statement.setString(1, taskID.toString());
            statement.executeUpdate();

            connection.commit();

            // switch connection
            statement = connection.prepareStatement(sqlTaskMap);

            // delete all task member relationships
            statement.setString(1, taskID.toString());
            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // update a task in the database

    public void updateCommonTask(CommonTask task){
        // delete the current task with the same oid
        deleteTask(task.getOid());

        // create a task with the updated corrections
        createCommonTask(task);

    }

    // the following method will be used as a helper method in createCommonTask().
    private void saveTaskMembers(CommonTask task){
        String sql = "INSERT INTO task_map (ID, memberID) VALUES (?,?)";
        PreparedStatement statement;

        try{

            // connect to the database for each row.
            // insert each member.

            for (int memberID: task.getMembers()) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, task.getOid().toString());
                statement.setInt(2, memberID);
                statement.executeUpdate();
            }
            connection.commit();
            connection.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    // get all tasks from the database
    public List<CommonTask>  getAllCommonTasks(){
        String query = "SELECT * FROM tasks";
        List<CommonTask> tasks = new ArrayList<>();
        Statement statement;
        ResultSet result;

        try{

            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()){
                UUID id = UUID.fromString(result.getString("ID"));
                String projectID = result.getString("projectID");
                CommonProject project = new CommonProjectDAO().getCommonProject(UUID.fromString(projectID));
                CommonTask task = getProjectTask(id, project);
                tasks.add(task);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return tasks;



    }

    // get a list of memberIDs
    public Set<Integer> getTaskMembers(UUID taskID){

        String querySQL = "SELECT * FROM task_map where ID=" + taskID.toString();
        Set<Integer> memberIds = new TreeSet<>();
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                Integer memberID = resultSet.getInt("memberID");
                memberIds.add(memberID);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberIds;

    }

    // get a common task under a project
    public CommonTask getProjectTask(UUID taskID, CommonProject project){

        String querySQL = "SELECT * FROM tasks where ID=" + taskID.toString();
        CommonTask task = null;

        Statement statement;
        ResultSet resultSet = null;

        try {
            // create a connection
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {

                // retrieve given data
                UUID id = UUID.fromString(resultSet.getString("ID"));
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Integer head = resultSet.getInt("head");
                Set<Integer> memberIds = getTaskMembers(taskID);
                LocalDateTime start = LocalDateTime.parse(resultSet.getString("start"));

                if (resultSet.getString("state").equals("CLOSED")){
                    int star = Integer.parseInt(resultSet.getString("results"));
                    LocalDateTime end = LocalDateTime.parse(resultSet.getString("end"));
                    task = new CommonTask(id,name,head,memberIds,description,start,end,project,star);
                }
                else{
                    task = new CommonTask(id,name,head,memberIds,description,start,project);
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;

    }










}
