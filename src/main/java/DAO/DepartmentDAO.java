package DAO;

import entity.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import static utilities.SQLiteDataSource.connection;

public class DepartmentDAO {

    public void createDepartment(Department department){

        PreparedStatement statement;
        String insertDepartmentSQL;
        String insertDepartmentMapSQL = "INSERT INTO department_map (departmentID, employeeID) VALUES (?,?)";

        if (department.getState().equals("CLOSED")){
            insertDepartmentSQL = "INSERT INTO department (ID, name, head, description, create, status, end) VALUES (?,?,?,?,?,?,?)";
        } else {
            insertDepartmentSQL = "INSERT INTO department (ID, name, head, description, create, status) VALUES (?,?,?,?,?,?)";
        }

        try{

            statement = connection.prepareStatement(insertDepartmentSQL);
            statement.setString(1, department.getOid().toString());
            statement.setString(2, department.getName());
            statement.setInt(3, department.getHead());
            statement.setString(4, department.getDescription());
            statement.setString(5, department.getCreateTime().toString());
            statement.setString(6, department.getState());

            if (department.getState().equals("CLOSED")){
                statement.setString(7, department.getCloseTime().toString());
            }
            statement.executeUpdate();

            for (int memberID: department.getMembers()){
                statement = connection.prepareStatement(insertDepartmentMapSQL);
                statement.setString(1, department.getOid().toString());
                statement.setInt(2, memberID);
                statement.executeUpdate();
            }

            connection.commit();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }


    public void deleteDepartment(UUID oid){

        String deleteDepartmentMapSQL = "DELETE FROM department_map WHERE departmentID=?";
        String deleteDepartmentSQL = "DELETE FROM department WHERE ID=?";

        PreparedStatement statement;

        try{

            statement = connection.prepareStatement(deleteDepartmentMapSQL);
            statement.setString(1, oid.toString());
            statement.executeUpdate();
            statement = connection.prepareStatement(deleteDepartmentSQL);
            statement.setString(1, oid.toString());
            statement.executeUpdate();
            connection.commit();
            connection.close();


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateDepartment(Department department){
        deleteDepartment(department.getOid());
        createDepartment(department);



    }

    public List<Department> getAllDepartments(){

        String departmentSQL = "SELECT * FROM department";
        String departmentMapSQL = "SELECT * FROM department_map WHERE departmentID=";

        List<Department> departments = new ArrayList<>();
        Statement statement;
        ResultSet departmentResult = null;

        try{
            statement = connection.createStatement();
            departmentResult = statement.executeQuery(departmentSQL);

            while (departmentResult.next()){
                Set<Integer> memberIds = new TreeSet<>();
                String departmentID = departmentResult.getString("ID");
                ResultSet departmentMapResult = statement.executeQuery(departmentMapSQL+departmentID);

                while (departmentMapResult.next()){
                    memberIds.add(departmentMapResult.getInt("employeeID"));
                }

                // create a department
                UUID id = UUID.fromString(departmentResult.getString("ID"));
                String name = departmentResult.getString("name");
                Integer head = departmentResult.getInt("head");
                String description = departmentResult.getString("description");
                LocalDateTime create = LocalDateTime.parse(departmentResult.getString("create"));
                Department department;
                if (departmentResult.getString("status").equals("CLOSED")){
                    LocalDateTime end = LocalDateTime.parse(departmentResult.getString("end"));
                    department = new Department(id,name,head,memberIds,description,create,end);

                } else {
                    department = new Department(id,name,head,memberIds,description,create);
                }
                departments.add(department);


            }
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return departments;
    }

    public Department getDepartment(UUID id){
        List<Department> departments = getAllDepartments();
        for (int i=0; i<departments.size(); i++){
            if(departments.get(i).getOid().equals(id)){
                return departments.get(i);
            }
        }

        return null;
    }

}
