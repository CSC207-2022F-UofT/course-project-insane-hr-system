package DAO;

import DAOInterfaces.ProjectDAOInterface;
import entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import static entity.Constants.CLOSED;
import static utilities.SQLiteDataSource.connection;

public class ProjectDAO implements ProjectDAOInterface {
    @Override
    public List<Project> getAllProjects() {
        // to get each project a project with no tasks must be created.
        // the tasks must be created individually.
        // then project is added to each task.
        // finally each task is added to the project.

    }

    // helper 1. create the intended project with no tasks.
    private Project getEmptyProject(String projectID){
        String querySQL = "SELECT * FROM project WHERE ID=" + projectID;
        Project project = null;
        Statement statement;
        ResultSet resultSet ;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {

                UUID id = UUID.fromString(resultSet.getString("ID"));
                String name = resultSet.getString("name");
                Integer head = resultSet.getInt("head");
                Set<Integer> memberIds = getMemberIDs(projectID);
                List<Task> tasks = new ArrayList<>();
                String description = resultSet.getString("description");
                LocalDateTime create = LocalDateTime.parse(resultSet.getString("start"));

                if(resultSet.getString("type").equals("COMMON")){
                    Department department = new DepartmentDAO().getDepartment(UUID.fromString(resultSet.getString("department")));
                    int funds = resultSet.getInt("funds");

                    if(resultSet.getString("status").equals("CLOSED")){
                        int star = resultSet.getInt("star");
                        LocalDateTime end = LocalDateTime.parse(resultSet.getString("end"));
                        project = new CommonProject(id, name, star, head, memberIds, description, create, end, department, tasks, funds);
                    }
                    else{
                        project = new CommonProject(id, name, head, memberIds, description, create, department, tasks, funds);
                    }

                }
                else{
                    int vacationDays = resultSet.getInt("vacation_days");

                    LeaveType leaveType = LeaveType.valueOf(resultSet.getString("leave_type"));

                    if(resultSet.getString("status").equals(CLOSED)){
                        LocalDateTime end = LocalDateTime.parse(resultSet.getString("end"));
                        project = new LeaveRequestProject(id,name,head,memberIds,description,create,end,vacationDays,leaveType);
                    }
                    else{
                        project = new LeaveRequestProject(id,name,head,memberIds,description,create,vacationDays,leaveType);

                    }

                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;


    }

    // helper 2. create a task with a project
    private Task getProjectTask(String taskID, Project project){
        String SQL = "SELECT * FROM tasks WHERE ID="+ taskID;
        Statement statement;
        ResultSet resultSet;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                UUID id;
                String name;
                String description;
                int head;
                LocalDateTime start;

                if (resultSet.getString("type").equals("COMMON")){
                    //




                } else if (resultSet.getString("type").equals("STAR")) {

                    /// TODO:

                } else if (resultSet.getString("type").equals("LEAVE")) {

                }


            }


        } catch (SQLException e){
            e.printStackTrace();
        }







    }

    // helper 3. get a list of project members.
    private Set<Integer> getMemberIDs(String projectID){
        String querySQL = "SELECT * FROM project_member_map where projectID = " + projectID;
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





    @Override
    public Project getProject(UUID id) {
        return null;
    }

    @Override
    public void createProject(Project project) {
        PreparedStatement statement;

        // the insert statement into the project table. depends on the project type and state.
        String SQL;

        if (project.getState().equals(CLOSED)){
            if (project.getType().equals("COMMON")){
                SQL = "INSERT INTO project (ID, name, head, description, start, status," +
                        " type, department, funds, end, star) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }
            else{
                SQL = "INSERT INTO project (ID, name, head, description, start, status," +
                        " type, vacation_days, leave_type, end) VALUES (?,?,?,?,?,?,?,?,?,?)";

            }

        }
        else{
            if (project.getType().equals("COMMON")){
                SQL = "INSERT INTO project (ID, name, head, description, start, status," +
                        " type, department, funds) VALUES (?,?,?,?,?,?,?,?,?)";
            } else{
                SQL = "INSERT INTO project (ID, name, head, description, start, status," +
                        " type, vacation_days, leave_type) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }


        }


        // keep track of project members in the project_member_map table.
        String memberSQL = "INSERT INTO project_member_map (projectID, memberID) VALUES (?,?)";
        String taskSQL = "INSERT INTO project_task_map (projectID, taskID) VALUES (?,?)";



        try{

            // create a connection.
            statement = connection.prepareStatement(SQL);

            // insert data.
            statement.setString(1, project.getOid().toString());
            statement.setString(2, project.getName());
            statement.setInt(3, project.getHead());
            statement.setString(4, project.getDescription());
            statement.setString(5, project.getCreateTime().toString());
            statement.setString(6, project.getState());
            statement.setString(7, project.getType());

            // if the project is common. also set the department and funds.
            if (project.getType().equals("COMMON")){
                statement.setString(8, ((CommonProject) project).getDpt().getOid().toString());
                statement.setInt(9, ((CommonProject) project).getFunds());
                if (project.getState().equals(CLOSED)){
                    statement.setString(10, project.getCloseTime().toString());
                    statement.setInt(11, ((CommonProject) project).getStar());
                }


            }
            else{
                statement.setInt(8, ((LeaveRequestProject) project).getVacationDays());

                statement.setString(9, ((LeaveRequestProject) project).getLeaveType().toString());

                if (project.getState().equals(CLOSED)){
                    statement.setString(10, project.getCloseTime().toString());
                }
            }


            // update the table.
            statement.executeUpdate();

            // for each memberID the project_member_map stores, create a new connection and insert a row.
            for (int memberID: project.getMembers()){

                statement = connection.prepareStatement(memberSQL);
                statement.setString(1, project.getOid().toString());
                statement.setInt(2, memberID);

                // each row should be updated.
                statement.executeUpdate();
            }

            // for each taskID the project_task_map stores, create a new connection and insert a row.
            for(Task task: project.getTasks()){
                statement = connection.prepareStatement(taskSQL);
                statement.setString(1, project.getOid().toString());
                statement.setString(2, task.getOid().toString());
            }



            // commit all changes then close the connection.
            connection.commit();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    // this is a helper function to update the project.
    private void deleteProject(UUID id){
        String taskSQL = "DELETE FROM project_task_map WHERE projectID=?";
        String memberSQL = "DELETE FROM project_member_map WHERE projectID=?";
        String SQL = "DELETE FROM project where ID=?";

        PreparedStatement statement;

        try{

            statement = connection.prepareStatement(taskSQL);
            statement.setString(1, id.toString());
            statement.executeUpdate();
            statement = connection.prepareStatement(memberSQL);
            statement.setString(1, id.toString());
            statement.executeUpdate();
            statement = connection.prepareStatement(SQL);
            statement.setString(1, id.toString());
            statement.executeUpdate();
            connection.commit();
            connection.close();


        } catch (SQLException e){
            e.printStackTrace();
        }



    }

    @Override
    public void updateProject(Project project) {
        deleteProject(project.getOid());
        createProject(project);

    }


    private Set<Integer> getTaskMembers(UUID taskID){

        String querySQL = "SELECT * FROM task_map where ID=" + taskID.toString();
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
}
