package DAO;

import DAOInterfaces.TaskDAOInterface;
import entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import static entity.Constants.CLOSED;
import static utilities.SQLiteDataSource.connection;

public class TaskDAO implements TaskDAOInterface {

    // get one task. //
    @Override
    public Task getTask(UUID taskID){
        Task task = null;

        String query = "SELECT * FROM tasks WHERE ID='" + taskID.toString() + "'";
        Statement statement;
        ResultSet resultSet;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                UUID projectID = UUID.fromString(resultSet.getString("projectID"));
                Project project = new ProjectDAO().getProject(projectID);
                task = getProjectTask(taskID, project);
            }




        } catch (SQLException e){
            e.printStackTrace();
        }
        return task;



    }

    // get all tasks //
    @Override
    public List<Task> getAllTasks(){
        String query = "SELECT * FROM tasks";
        List<Task> tasks = new ArrayList<>();

        Statement statement;
        ResultSet resultSet;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                UUID taskID = UUID.fromString(resultSet.getString("ID"));
                tasks.add(getTask(taskID));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return tasks;


    }

    // create a task in the database //
    @Override
    public void createTask(Task task){

        String query;
        // check the status and type of task.

        if (task.getType().equals("STAR")){

            if(task.getState().equals(CLOSED)){
                query = "INSERT INTO tasks (id, projectID, name, head, description, status, start, type, evalTask, 'end', results) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            } else {
                query = "INSERT INTO tasks (id, projectID, name, description, head, status, start, type, evalTask) VALUES (?,?,?,?,?,?,?,?,?)";
            }


        } else{
            if (task.getState().equals(CLOSED)){
                query = "INSERT INTO tasks (id, projectID, name, head, description, status, start, type, 'end', results) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }
            else{
                query = "INSERT INTO tasks (id, projectID, name, head, description, status, start, type) VALUES (?,?,?,?,?,?,?,?)";
            }

        }


        // insert data
        PreparedStatement statement;

        try {

            // connect to the database
            statement = connection.prepareStatement(query);

            // insert a new row
            statement.setString(1, task.getOid().toString());
            statement.setString(2, task.getProject().getOid().toString());
            statement.setString(3, task.getName());
            statement.setInt(4, task.getHead());
            statement.setString(5, task.getDescription());
            statement.setString(6, task.getState());
            statement.setString(7, task.getCreateTime().toString());
            statement.setString(8, task.getType());

            if (task.getType().equals("STAR")){
                statement.setString(9, task.getOid().toString());
                if(task.getState().equals(CLOSED)){
                    statement.setString(10, task.getCloseTime().toString());
                    statement.setString(11, task.getResults().toString());
                }

            } else if (task.getState().equals(CLOSED)) {
                statement.setString(9, task.getCloseTime().toString());
                statement.setString(10, task.getResults().toString());

            }

            statement.executeUpdate();
            connection.commit();

            // save all task members to the database as well
            saveTaskMembers(task);



        } catch (SQLException e) {
            e.printStackTrace();
        }









    }


    // delete a task from the database //

    public void deleteTask(UUID taskID){
        String sql = "DELETE FROM tasks WHERE ID=?";
        String sqlTaskMap = "DELETE FROM task_map WHERE ID=?";
        PreparedStatement statement;

        try {

            statement = connection.prepareStatement(sqlTaskMap);

            // delete all task member relationships
            statement.setString(1, taskID.toString());
            statement.executeUpdate();


            // switch connection
            statement = connection.prepareStatement(sql);

            // delete the task with the given oid.
            statement.setString(1, taskID.toString());
            statement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateTask(Task task){
        deleteTask(task.getOid());
        createTask(task);
    }






////////////////// HELPER FUNCTIONS ////////////////////////



    // helper function : get a task with the given project //
    public Task getProjectTask(UUID taskID, Project project) {
        Task task = null;
        Set<Integer> members = getTaskMembers(taskID);
        String query = "SELECT * FROM tasks WHERE ID='" + taskID + "'";
        Statement statement;
        ResultSet result;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {

                UUID id = UUID.fromString(result.getString("ID"));
                String name = result.getString("name");
                Integer head = result.getInt("head");
                String description = result.getString("description");
                LocalDateTime start = LocalDateTime.parse(result.getString("start"));

                if (result.getString("type").equals("STAR")) {
                    UUID evalTaskID = UUID.fromString(result.getString("evalTask"));
                    CommonTask evalTask = (CommonTask) getTask(evalTaskID);

                    if (result.getString("status").equals(CLOSED)) {
                        LocalDateTime end = LocalDateTime.parse(result.getString("end"));
                        int ratingResults = Integer.parseInt(result.getString("results"));

                        StarEvaluationTask starTask = new StarEvaluationTask(id, name, head, members, description, start, end, evalTask, project);
                        starTask.setResults(ratingResults);
                        task = starTask;

                    } else {
                        task = new StarEvaluationTask(id, name, head, members, description, start, evalTask, project);
                    }


                } else if (result.getString("type").equals("COMMON")) {
                    if (result.getString("status").equals(CLOSED)) {
                        LocalDateTime end = LocalDateTime.parse(result.getString("end"));
                        int star = Integer.parseInt(result.getString("results"));

                        task = new CommonTask(id, name, head, members, description, start, end, (CommonProject) project, star);

                    } else {
                        task = new CommonTask(id, name, head, members, description, start, (CommonProject) project);
                    }

                } else {
                    if (result.getString("status").equals(CLOSED)) {
                        LocalDateTime end = LocalDateTime.parse(result.getString("end"));
                        Boolean taskResult = Boolean.getBoolean(result.getString("results"));

                        LeaveRequestTask leaveTask = new LeaveRequestTask(id, name, head, members, description, start, end, (LeaveRequestProject) project);
                        leaveTask.setResults(taskResult);
                        task = leaveTask;
                    } else {
                        task = new LeaveRequestTask(id, name, head, members, description, start, (LeaveRequestProject) project);
                    }

                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }


    // helper function : get task members //
    public Set<Integer> getTaskMembers(UUID taskID){

        String querySQL = "SELECT * FROM task_map where ID='" + taskID.toString() + "'";
        Set<Integer> memberIds = new TreeSet<>();
        Statement statement;
        ResultSet resultSet;
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


    // the following method will be used as a helper method in createTask().
    private void saveTaskMembers(Task task){
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

        } catch(SQLException e){
            e.printStackTrace();
        }
    }








}
