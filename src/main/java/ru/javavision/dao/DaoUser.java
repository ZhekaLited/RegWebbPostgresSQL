package ru.javavision.dao;

import ru.javavision.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DaoUser {


    boolean checkExistsPerson(String login);

    User getUserLogin(String login);

    List<String> getUserRole(String login);

    List<User> selectAllUsers();

    boolean insertUser(User user) throws SQLException;

    boolean updateUser(User user, String id) throws SQLException;

    boolean deleteUser(String login) throws SQLException;

    void printSQLException(SQLException ex);

     boolean Validation(String login, String password, String salary, String name, String birthday);

}
