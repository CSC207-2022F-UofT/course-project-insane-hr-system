package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataSource {
    public static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "src/main/database/HR_DB.sqlite";
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbURL);
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
}
