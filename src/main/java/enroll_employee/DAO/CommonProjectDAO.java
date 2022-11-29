package enroll_employee.DAO;

import entity.CommonProject;
import entity.CommonTask;
import entity.Department;
import entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import static utilities.SQLiteDataSource.connection;

public class CommonProjectDAO {
    public CommonProject getEmptyProject(String projectID){
        String querySQL = "SELECT * FROM project WHERE ID=" + projectID;
        CommonProject project = null;
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {

                UUID id = UUID.fromString(resultSet.getString("ID"));
                String name = resultSet.getString("name");
                Integer head = resultSet.getInt("head");
                Set<Integer> memberIds = getMemberIds(projectID);
                List<Task> tasks = new ArrayList<>();
                String description = resultSet.getString("description");
                LocalDateTime create = LocalDateTime.parse(resultSet.getString("start"));
                Department department = new DepartmentDAO().getDepartment(UUID.fromString(resultSet.getString("department")));
                int funds = resultSet.getInt("funds");

                if (resultSet.getString("status").equals("CLOSED")){
                    int star = Integer.parseInt(resultSet.getString("results"));
                    LocalDateTime end = LocalDateTime.parse(resultSet.getString("end"));
                    project = new CommonProject(id,name,star,head,memberIds,description,create,end,department,tasks,funds);

                } else{
                    project = new CommonProject(id,name,head,memberIds,description,create,department,tasks,funds);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;



    }

    public Set<Integer> getMemberIds(String projectID){
        String querySQL = "SELECT * FROM project_member_map where projectID = " + projectID;
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

    public List<String> getTaskIds(String projectID){
        String querySQL = "SELECT * FROM project_task_map where projectID = " + projectID;
        List<String> taskIds = new ArrayList<>();

        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                String taskID = resultSet.getString("taskID");
                taskIds.add(taskID);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskIds;


    }

    public Set<Integer> getTaskMemberIds(String taskID){

        String querySQL = "SELECT * FROM task_map where ID=" + taskID;
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

    public Task getProjectTask(UUID taskID, CommonProject project){
        String querySQL = "SELECT * FROM tasks where ID=" + taskID;
        CommonTask task = null;

        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString("ID"));
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Integer head = resultSet.getInt("head");
                Set<Integer> memberIds = getTaskMemberIds(taskID.toString());
                LocalDateTime start = LocalDateTime.parse(resultSet.getString("start"));

                if (resultSet.getString("state").equals("CLOSED")){
                    int star = Integer.parseInt(resultSet.getString("results"));
                    LocalDateTime end = LocalDateTime.parse(resultSet.getString("end"));
                    task = new CommonTask(id,name,head,memberIds,description,start,project);
                    // fix above
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

    public List<CommonProject> getAllCommonProjects(){
        String querySQL = "SELECT * FROM project";
        List<CommonProject> projects = new ArrayList<>();
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                CommonProject project = getEmptyProject(resultSet.getString("ID"));
                List<String> taskIds = getTaskIds(resultSet.getString("ID"));
                for(int i = 0; i < taskIds.size(); i++){
                    CommonTask task = (CommonTask) getProjectTask(UUID.fromString(taskIds.get(0)), project);
                    project.addTask(task);
                }
                projects.add(project);


            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;

    }

    public CommonProject getProject(UUID id){
        List<CommonProject> projects = getAllCommonProjects();
        for(int i = 0; i<projects.size(); i++){
            if (projects.get(i).getOid().equals(id)){
                return projects.get(i);
            }
        }
        return null;
    }




}













