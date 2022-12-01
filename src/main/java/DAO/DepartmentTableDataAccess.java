package DAO;

import entity.CommonProject;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
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

public class DepartmentTableDataAccess {

    public Object get(UUID oid, String column) {
        String querySQL = "SELECT "+ column + " FROM project WHERE ID=" + oid;
        Object result;
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySQL);
            result = resultSet.getString(column);
            return result;
        }   catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }
}
