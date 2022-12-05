package DAO;

import DAOInterfaces.UserDAOInterface;
import entity.Project;
import entity.Task;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static entity.Constants.CLOSED;
import static utilities.SQLiteDataSource.connection;

public class UserDAO implements UserDAOInterface {
    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM employees";
        List<User> users = new ArrayList<>();

        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int uid = resultSet.getInt("employee_id");
                users.add(getUser(uid));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void createUser(User user) {
        String userQuery;
        String projectQuery = "INSERT INTO projectMemberMap (projectID, memberID) VALUES (?,?)";
        String taskQuery = "INSERT INTO task_map (ID, memberID) VALUES (?,?)";

        if (user.getStatus().equals(CLOSED)) {
            userQuery = "INSERT INTO employees (employee_id, username, password, name, onboarding_date, " +
                    "departure_date, department_id, bio, position) VALUES (?,?,?,?,?,?,?,?,?)";
        } else {
            userQuery = "INSERT INTO employees (employee_id, username, password, name, roles, onboarding_date, department_id, " +
                    "bio, position) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        PreparedStatement statement;

        try {
            //connect to database
            statement = connection.prepareStatement(userQuery);

            // insert into new row
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            // TODO: drop roles and update column index here
            statement.setString(6, user.getOnboardDate().toString());
            if (user.getStatus().equals(CLOSED)) {
                statement.setString(7, user.getDepartureDate().toString());
            }
            statement.setString(8, user.getDpt().getOid().toString());
            statement.setString(9, user.getBio());
            statement.setString(10, user.getPosition().toString());

            statement.executeUpdate();

            // connect user to projects
            for (Project p : user.getProjects()) {
                statement = connection.prepareStatement(projectQuery);
                statement.setString(1, p.getOid().toString());
                statement.setInt(2, user.getId());
                statement.executeUpdate();
            }

            // connect user to tasks
            for (Task t: user.getTasks()) {
                statement = connection.prepareStatement(taskQuery);
                statement.setString(1, t.getOid().toString());
                statement.setInt(2, user.getId());
                statement.executeUpdate();
            }

            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        deleteUser(user.getId());
        createUser(user);
    }

    public void deleteUser(Integer uid) {

    }
}
