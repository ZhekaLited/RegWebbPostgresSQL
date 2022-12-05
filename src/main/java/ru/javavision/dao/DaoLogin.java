package ru.javavision.dao;

import ru.javavision.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DaoLogin {

     boolean validate(User loginBean) throws ClassNotFoundException;

    List<String> getRoles(String login) throws SQLException;
}
