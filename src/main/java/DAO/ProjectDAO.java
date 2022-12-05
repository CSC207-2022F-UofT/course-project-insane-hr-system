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

public class ProjectDAO{

    // get a project //
    public Project getProject(UUID projectID){
        Project project = getEmptyProject(projectID);
        String query = "SELECT * FROM projectTaskMap WHERE projectID=" + projectID.toString();

        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                UUID taskID = UUID.fromString(resultSet.getString("taskID"));
                Task projectTask = (new TaskDAO()).getProjectTask(taskID, project);
                project.addTask(projectTask);

            }
            connection.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return project;
    }

    // get all projects //
    public List<Project> getAllProjects(){
        String query = "SELECT * FROM project";
        List<Project> projects = new ArrayList<>();

        Statement statement;
        ResultSet resultSet;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                UUID projectID = UUID.fromString(resultSet.getString("results"));
                Project currentProject = getProject(projectID);
                projects.add(currentProject);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return projects;



    }

    // create a project //
    public void createProject(Project project){

        String taskQuery = "INSERT INTO projectTaskMap (projectID, taskID) VALUES (?,?)";
        String memberQuery = "INSERT INTO projectMemberMap (projectID, memberID) VALUES (?,?)";

        // check the type of the project //
        String query;
        if (project.getType().equals("COMMON")){
            if (project.getState().equals(CLOSED)){
                query = "INSERT INTO project (id, name, head, description, start, type, status, department, funds, end) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }
            else{
                query = "INSERT INTO project (id, name, head, description, start, type, status, department, funds) VALUES (?,?,?,?,?,?,?,?,?)";
            }
        }
        else{
            if (project.getState().equals(CLOSED)){
                query = "INSERT INTO project (id, name, head, description, start, type, status, vacation_days, leave_type, num_responses, end) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }
            else{
                query = "INSERT INTO project (id, name, head, description, start, type, status, vacation_days, leave_type, num_responses) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

        }

        // insert data
        PreparedStatement statement;

        try {

            // connect to the database
            statement = connection.prepareStatement(query);

            // insert a new row
            statement.setString(1, project.getOid().toString());
            statement.setString(2, project.getName());
            statement.setInt(3, project.getHead());
            statement.setString(4, project.getDescription());
            statement.setString(5, project.getCreateTime().toString());
            statement.setString(6, project.getType());
            statement.setString(7, project.getState());

            if (project.getType().equals("COMMON")){
                statement.setString(8, ((CommonProject) project).getDpt().getOid().toString());
                statement.setInt(9, ((CommonProject) project).getFunds());

                if (project.getState().equals(CLOSED)){
                    statement.setString(10, ((CommonProject) project).getCloseTime().toString());

                }

            }
            else {
                statement.setInt(8, ((LeaveRequestProject) project).getVacationDays());
                // TODO : LOOK OVER WHETHER THE FOLLOWING IS A STRING
                statement.setString(9, ((LeaveRequestProject) project).getLeaveType().toString()) ;
                statement.setInt(10, ((LeaveRequestProject) project).getNumResponses());

            }


            statement.executeUpdate();

            // save all project members to the database as well

            for (int memberID: project.getMembers()){

                statement = connection.prepareStatement(memberQuery);
                statement.setString(1, project.getOid().toString());
                statement.setInt(2, memberID);

                // each row should be updated.
                statement.executeUpdate();
            }

            // for each taskID the project_task_map stores, create a new connection and insert a row.
            for(Task task: project.getTasks()){
                statement = connection.prepareStatement(taskQuery);
                statement.setString(1, project.getOid().toString());
                statement.setString(2, task.getOid().toString());
                statement.executeUpdate();

            }


            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }









    }


    // delete a project //
    private void deleteProject(UUID id) {
        String taskSQL = "DELETE FROM projectTaskMap WHERE projectID=?";
        String memberSQL = "DELETE FROM projectMemberMap WHERE projectID=?";
        String SQL = "DELETE FROM project where ID=?";

        PreparedStatement statement;

        try {

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


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // update a project //
    public void updateProject(Project project){
        deleteProject(project.getOid());
        createProject(project);
    }


/////////////////// HELPERS BELOW /////////////////////////////////


    // helper function : get all project members //
    public Set<Integer> getProjectMembers(UUID projectID){
        String querySQL = "SELECT * FROM projectMemberMap where projectID = " + projectID.toString();
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

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberIds;
    }

    // helper function : get an empty project //
    public Project getEmptyProject(UUID projectID){

        Set<Integer> members = getProjectMembers(projectID);
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM project WHERE ID=" + projectID.toString();
        Project project = null;
        Statement statement;
        ResultSet result;

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(query);

            while(result.next()){

                UUID id = UUID.fromString(result.getString("ID"));
                String name = result.getString("name");
                Integer head = result.getInt("head");
                String description = result.getString("description");
                LocalDateTime start = LocalDateTime.parse(result.getString("start"));

                if(result.getString("type").equals("COMMON")){
                    // get department //
                    Department dept = new DepartmentDAO().getDepartment(UUID.fromString(result.getString("department")));
                    int funds = result.getInt("funds");

                    if (result.getString("status").equals(CLOSED)){
                        LocalDateTime end = LocalDateTime.parse(result.getString("end"));
                        project = new CommonProject(id, name, head, members, description, start, end, dept, tasks, funds);
                    }
                    else{
                        project = new CommonProject(id, name, head, members, description, start, dept, tasks, funds);
                    }

                } else{
                    int vacationDays = result.getInt("vacation_days");

                    // TODO : CONVERT THE STRING TO LEAVETYPE
                    LeaveType leaveType = result.getString("leave_type");

                    int numResponses = result.getInt("num_responses");

                    if(result.getString("status").equals(CLOSED)){
                        LocalDateTime end = LocalDateTime.parse(result.getString("end"));
                        LeaveRequestProject requestProject = new LeaveRequestProject(id, name, head, members, description, start, end, vacationDays, leaveType);
                        requestProject.setNumResponses(numResponses);
                        project = requestProject;



                    }
                    else{
                        LeaveRequestProject leaveRequestProject = new LeaveRequestProject(id, name, head, members, description, start, vacationDays, leaveType);
                        leaveRequestProject.setNumResponses(numResponses);
                        project = leaveRequestProject;
                    }

                }

            }
            connection.close();


        } catch(SQLException e){
            e.printStackTrace();
        }
        return project;




    }






}