package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataSource {
    public static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "https://github.com/CSC207-2022F-UofT/course-project-insane-hr-system/blob/5cd8c7a09586b81d6e2b1383766f67b439440efe/src/main/database/HR_DB.sqlite";
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
