package ru.javavision.dao;


import ru.javavision.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Author : Evgeniy Nechaev.
 * Created : 03/11/2022.
 * UserDAO
 */
public class UserDAO implements DaoUser {

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

    private static final String SELECT_ALL_USERS = "select * from \"authorization\".\"Users\"";
    private static final String INSERT_USERS = "INSERT INTO \"authorization\".\"Users\" " + "(login,password,birthday,age,salary,name) VALUES  ('%s','%s','%s','%d','%d','%s')";
    private static final String UPDATE_USERS = "UPDATE \"authorization\".\"Users\" " + "SET \"login\" = '%s' , \"password\" = '%s' , \"birthday\" = '%s' , \"age\" = '%d' , \"salary\" = '%d' , \"name\" = '%s' " + "WHERE \"login\" = '%s';";
    private static final String INSERT_ROLES = "INSERT INTO \"UsersRole\".\"UsersRole\" " + "select \"users\".\"Id\", \"roles\".\"id\" " + "from \"authorization\".\"Users\" as \"users\" , \"UsersRole\".\"Roles\" as \"roles\" " + "where \"users\".\"login\" = '%s' and \"roles\".\"name\" = '%s'";

    private static final String DELETE_USERS = "DELETE FROM \"authorization\".\"Users\" " + "WHERE \"authorization\".\"Users\".\"login\"= ?";

    private static final String SELECT_USERS = "SELECT 1 FROM \"authorization\".\"Users\" WHERE login ='%s'";

    private static final String DELETE_ROLES = "DELETE FROM \"UsersRole\".\"UsersRole\" WHERE \"UsersId\" = (" + "SELECT \"Id\" FROM \"authorization\".\"Users\" WHERE \"login\" = '%s')";

    private static final String GET_ALL_ROLE = "SELECT \"roles_name\".\"name\"" + " FROM \"authorization\".\"Users\" as \"users\" , \"UsersRole\".\"Roles\" as \"roles_name\" , " + "\"UsersRole\".\"UsersRole\" as \"users_roles\"" + "WHERE \"users\".\"login\" = '%s' AND \"users\".\"Id\" = \"users_roles\".\"UsersId\" AND \"roles_name\".\"id\" = \"users_roles\".\"RoleId\"";

    private static final String GET_USER_BYLOGIN = "SELECT * FROM \"authorization\".\"Users\" where \"login\" = '%s'";

    @Override
    public boolean checkExistsPerson(String login) {
        boolean exists = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(String.format(SELECT_USERS, login));

            while (resultSet.next()) {
                if (resultSet.getBoolean(1)) {
                    exists = true;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return exists;
    }

    @Override
    public boolean Validation(String login, String password, String salary, String name, String birthday) {
        boolean checked = false;

        if (login.equals("") || password.equals("") || salary.equals("") || name.equals("") || birthday.equals("")) {
            checked = false;
        } else {
            if (Pattern.matches("[A-Za-zАяа-яЁё0-9]+", login) &&
                    Pattern.matches("[A-Za-zАяа-яЁё0-9]+", password) &&
                    Pattern.matches("[0-9+]", salary) &&
                    Pattern.matches("[A-Za-zАяа-яЁё]+", name) &&
                    Pattern.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}", birthday)) {
                checked = true;
            } else {
                checked = false;
            }
        }
        return checked;

    }

    @Override
    public User getUserLogin(String login) {
        User user = null;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(GET_USER_BYLOGIN, login));
            while (resultSet.next()) {
                System.out.println(resultSet.getString("login"));
                LocalDate birthday = null;
                if (resultSet.getDate("birthday") != null) {
                    birthday = LocalDate.parse(new SimpleDateFormat("dd.MM.yyyy").format(resultSet.getDate("birthday")), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                }
                user = new User(0, resultSet.getString("login"), resultSet.getString("password"), resultSet.getInt("age"), resultSet.getInt("salary"), resultSet.getString("name"), birthday, getUserRole(resultSet.getString("login")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<String> getUserRole(String login) {
        List<String> rolesList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sqlCommand = String.format(GET_ALL_ROLE, login);

            ResultSet resultSet = statement.executeQuery(sqlCommand);

            while (resultSet.next()) {
                rolesList.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolesList;
    }

    @Override
    public List<User> selectAllUsers() {

        List<User> listUser = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatementt = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatementt);
            ResultSet rs = preparedStatementt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                String name = rs.getString("name");
                LocalDate birthday = null;
                if (rs.getDate("birthday") != null) {
                    birthday = LocalDate.parse(new SimpleDateFormat("dd.MM.yyyy").format(rs.getDate("birthday")), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                }
                listUser.add(new User(id, login, password, age, salary, name, birthday, getUserRole(login)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listUser;
    }

    @Override
    public boolean insertUser(User user) throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(INSERT_USERS, user.getLogin(), user.getPassword(), user.getBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), user.getAge(), user.getSalary(), user.getName()));
            if (user.getRole() != null) {
                for (String role : user.getRole()) {
                    String sqlCommandRole = String.format(INSERT_ROLES, user.getLogin(), role);
                    statement.executeUpdate(sqlCommandRole);
                }
            }
            System.out.println(statement);
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    @Override
    public boolean updateUser(User user, String id) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(UPDATE_USERS, user.getLogin(), user.getPassword(), user.getBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), user.getAge(), user.getSalary(), user.getName(), id));

            if (checkExistsPerson(user.getLogin())) {
                rowUpdated = true;
            }

            statement.executeUpdate(String.format(DELETE_ROLES, user.getLogin()));

            if (user.getRole() != null) {
                for (String role : user.getRole()) {
                    statement.executeUpdate(String.format(INSERT_ROLES, user.getLogin(), role));
                }
            }
        }

        return rowUpdated;
    }

    @Override
    public boolean deleteUser(String login) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS)) {
            statement.setString(1, login);
            rowDeleted = statement.executeUpdate() > 0;
            System.out.println(statement);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public void printSQLException(SQLException ex) {
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


//
//
//    public static Set<User> store = new LinkedHashSet<>();
//
//    public boolean add(final User user) {
//
//        for (User u : store) {
//            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
//                return false;
//            }
//        }
//
//        return store.add(user);
//    }
//
////    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
////        User.ROLE result = User.ROLE.UNKNOWN;
////
////        for (User user : store) {
////            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
////                result = user.getRole();
////            }
////        }
////
////        return result;
////    }
//
//    public boolean userIsExist(final String login, final String password) {
//
//        boolean result = false;
//
//        for (User user : store) {
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//                result = true;
//                break;
//            }
//        }
//
//        return result;
//    }
//
//
//    public boolean create(User user) {
//        return store.add(user);
//    }
//
//
//    public boolean update(User user, String Person) {
//        boolean flag = false;
//        for (User element : store) {
//            if (Person.equals(element.getLogin())) {
//                for (User u : store) {
//                    if (user.getLogin().equals(u.getLogin()) && !Person.equals(user.getLogin())) {
//                        flag = false;
//                        break;
//                    } else {
//                        flag = true;
//                    }
//                }
//                if (flag) {
//                    element.setLogin(user.getLogin());
//                    element.setPassword(user.getPassword());
//                    element.setEmail(user.getEmail());
//                    element.setSurname(user.getSurname());
//                    element.setName(user.getName());
//                    element.setPatronymic(user.getPatronymic());
//                    element.setRole(user.getRole());
//                    element.setBirthday(new SimpleDateFormat("dd.MM.yyyy").format(user.getBirthday()));
//                }
//            }
//        }
//        return flag;
//    }
//
//
//    public void delete(User user) {
//        store.remove(user);
//    }
//
}