package Utilities;

import Entity.CommonUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataSource {

    private static SQLiteDataSource sqLiteDataSource = null;
    public static Connection connection = null;

    private SQLiteDataSource(){
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:/Users/tarachakkithara/Desktop/CSC207/course-project-insane-hr-system/src/main/HRDatabase/HR_DB.db";
            connection = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException e) {
            System.out.println("connection fail");
            e.printStackTrace();
            //throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Connection ahfkja");
            e.printStackTrace();
            //throw new RuntimeException(e);
        }


    }

   public static Connection getConnection(){
        if (sqLiteDataSource == null){
            sqLiteDataSource = new SQLiteDataSource();
        }
        return connection;
   }

}
