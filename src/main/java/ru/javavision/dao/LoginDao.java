package ru.javavision.dao;

import ru.javavision.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDao implements DaoLogin {

    public boolean validate(User loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/MyDB", "Admin", "root");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from \"authorization\".\"Users\" where  \"authorization\".\"Users\".\"login\" = ? and  \"authorization\".\"Users\".\"password\" = ? ")) {
            preparedStatement.setString(1, loginBean.getLogin());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private String jdbcURL = "jdbc:postgresql://localhost:5432/MyDB";
    private String jdbcUsername = "Admin";
    private String jdbcPassword = "root";

    public List<String> getRoles(String login) throws SQLException {
        List<String> roles = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String command = String.format("SELECT \"roles_names\".\"name\" " +
                        "FROM \"authorization\".\"Users\" AS \"users\",\"UsersRole\".\"Roles\" AS \"roles_names\", \"UsersRole\".\"UsersRole\" AS \"users_roles\" " +
                        "WHERE \"users\".\"login\" = '%s' AND \"users\".\"Id\" = \"users_roles\".\"UsersId\" AND \"roles_names\".\"id\" = \"users_roles\".\"RoleId\" ",
                login
        );
        ResultSet resultSet = statement.executeQuery(command);

        while (resultSet.next()) {
            roles.add(resultSet.getString("name"));
        }
        connection.close();
        return roles;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
