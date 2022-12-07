package DAO;

import DAOInterfaces.DepartmentDAOInterface;
import entity.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;

import static utilities.SQLiteDataSource.connection;

public class DepartmentDAO implements DepartmentDAOInterface {

    // create a Department.. //
    @Override
    public void createDepartment(Department department){

        PreparedStatement statement;

        // the insert statement into the department table depends on whether the department is open or closed.
        String insertDepartmentSQL;

        // keep track of department members in the department_map table. in this table the departmentID isn't unique.
        String insertDepartmentMapSQL = "INSERT INTO department_map (departmentID, employeeID) VALUES (?,?)";


        if (department.getState().equals("CLOSED")){

            // if a department is closed it has an end date.
            insertDepartmentSQL = "INSERT INTO department (ID, name, head, description, 'create', status, end) VALUES (?,?,?,?,?,?,?)";
        } else {

            // if a department is open it has no end date. the end date is an optional key in the table.
            insertDepartmentSQL = "INSERT INTO department (ID, name, head, description, 'create', status) VALUES (?,?,?,?,?,?)";
        }

        try{

            // create a connection.
            statement = connection.prepareStatement(insertDepartmentSQL);

            // insert data
            statement.setString(1, department.getOid().toString());
            statement.setString(2, department.getName());
            statement.setInt(3, department.getHead());
            statement.setString(4, department.getDescription());
            statement.setString(5, department.getCreateTime().toString());
            statement.setString(6, department.getState());

            // if the department is closed insert the end time into the table.
            if (department.getState().equals("CLOSED")){
                statement.setString(7, department.getCloseTime().toString());
            }
            // update the tables.
            statement.executeUpdate();

            // for each memberID the department stores create a new connection and insert a row into the department_map.
            for (int memberID: department.getMembers()){

                statement = connection.prepareStatement(insertDepartmentMapSQL);
                statement.setString(1, department.getOid().toString());
                statement.setInt(2, memberID);

                // each row should be updated.
                statement.executeUpdate();
            }

            // commit all changes then close the connection.
            connection.commit();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }


    private void deleteDepartment(UUID oid){

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


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateDepartment(Department department){
        deleteDepartment(department.getOid());
        createDepartment(department);



    }

    @Override
    public List<Department> getAllDepartments(){

        String departmentSQL = "SELECT * FROM department";
        String departmentMapSQL = "SELECT * FROM department_map WHERE departmentID=";

        List<Department> departments = new ArrayList<>();
        Statement statement;
        ResultSet departmentResult;

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

        } catch (SQLException e){
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Department getDepartment(UUID id){
        List<Department> departments = getAllDepartments();
        for (Department department : departments) {
            if (department.getOid().equals(id)) {
                return department;
            }
        }

        return null;
    }

}
