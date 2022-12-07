package DAO;

import DAOInterfaces.UserDAOInterface;
import entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static utilities.SQLiteDataSource.connection;
import static entity.Constants.CLOSED;

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

    /**
     * get user by id
     * @param uid uid
     * @return user
     */
    @Override
    public User getUser(Integer uid) {
        User user = new CommonUser(uid);  // initialize user class
        String userQuery = "SELECT * FROM employees WHERE employee_id=" + uid;
        String taskQuery = "SELECT * FROM task_map WHERE memberID=" + uid;
        String projectQuery = "SELECT * FROM projectMemberMap WHERE memberID=" + uid;

        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();

            // get basic user info
            resultSet = statement.executeQuery(userQuery);
            while (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setOnboardDate(LocalDate.parse(resultSet.getString("onboarding_date")));

                String status = resultSet.getString("status");
                if (status.equals(CLOSED)) {
                    user.setDepartureDate(LocalDate.parse(resultSet.getString("departure_date")));
                }

                UUID dptID = UUID.fromString(resultSet.getString("department_id"));
                user.setDpt(new DepartmentDAO().getDepartment(dptID));

                user.setBio(resultSet.getString("bio"));
                user.setPosition(Position.valueOf(resultSet.getString("position")));
                user.setStatus(status);
            }

            // get user's tasks
            List<Task> tasks = new ArrayList<>();
            resultSet = statement.executeQuery(taskQuery);
            while (resultSet.next()) {
                UUID taskID = UUID.fromString(resultSet.getString("ID"));
                tasks.add(new TaskDAO().getTask(taskID));
            }
            user.setTasks(tasks);

            // get user's projects
            List<Project> projects = new ArrayList<>();
            resultSet = statement.executeQuery(projectQuery);
            while (resultSet.next()) {
                UUID projectID = UUID.fromString(resultSet.getString("projectID"));
                projects.add(new ProjectDAO().getProject(projectID));
            }
            user.setProjects(projects);

            // set user's roles
            new RoleSetter().resetRoleOfUser(user);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void createUser(User user) {
        String userQuery;
        String projectQuery = "INSERT INTO projectMemberMap (projectID, memberID) VALUES (?,?)";
        String taskQuery = "INSERT INTO task_map (ID, memberID) VALUES (?,?)";

        if (user.getStatus().equals(CLOSED)) {
            userQuery = "INSERT INTO employees (employee_id, username, password, name, onboarding_date, " +
                    "departure_date, department_id, bio, position, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
        } else {
            userQuery = "INSERT INTO employees (employee_id, username, password, name, roles, onboarding_date, department_id, " +
                    "bio, position, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
            // TODO: drop roles column and update column index below
            statement.setString(6, user.getOnboardDate().toString());

            String status = user.getStatus();
            if (status.equals(CLOSED)) {
                statement.setString(7, user.getDepartureDate().toString());
            }

            statement.setString(8, user.getDpt().getOid().toString());
            statement.setString(9, user.getBio());
            statement.setString(10, user.getPosition().toString());
            statement.setString(11, status);

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
        String userQuery = "DELETE FROM employees WHERE employee_id=?";
        String taskQuery = "DELETE FROM task_map WHERE memberID=?";
        String projectQuery = "DELETE FROM projectMemberMap WHERE memberID=?";

        PreparedStatement statement;

        try {
            // remove from employees
            statement = connection.prepareStatement(userQuery);
            statement.setInt(1, uid);
            statement.executeUpdate();

            // remove task connections
            statement = connection.prepareStatement(taskQuery);
            statement.setInt(1, uid);
            statement.executeUpdate();

            // remove project connections
            statement = connection.prepareStatement(projectQuery);
            statement.setInt(1, uid);
            statement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
