package utilities;

import entity.CommonUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataSource {

    private static SQLiteDataSource sqLiteDataSource = null;
    public static Connection connection = null;

    private SQLiteDataSource(){
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "/Users/wukunlong/IdeaProjects/course-project-insane-hr-system/src/main/database/HR_DB.sqlite";
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
