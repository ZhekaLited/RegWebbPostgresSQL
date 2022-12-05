package ru.javavision.service;

import ru.javavision.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    boolean checkExistsPerson(String login);

    User getUserLogin(String login);

    List<String> getUserRole(String login);

    List<User> selectAllUsers();

    boolean insertUser(User user) throws SQLException;

    boolean updateUser(User user, String id) throws SQLException;

    boolean deleteUser(String login) throws SQLException;

    boolean validate(User loginBean) throws ClassNotFoundException;

    List<String> getRoles(String login) throws SQLException;

     boolean Validation(String login, String password, String salary, String name, String birthday);

}
