package ru.javavision.service;

import ru.javavision.dao.DaoUser;
import ru.javavision.dao.InMemoryUserDaoFactory;
import ru.javavision.dao.LoginDao;
import ru.javavision.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static DaoUser UserDao = InMemoryUserDaoFactory.daoUser();

    private static LoginDao loginDao = InMemoryUserDaoFactory.loginDao();

    private static UserServiceImpl INSTANCE;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public boolean Validation(String login, String password, String salary, String name, String birthday){
        return (UserDao.Validation(login, password, salary, name , birthday));
    }

    @Override
    public boolean checkExistsPerson(String login) {
        return (UserDao.checkExistsPerson(login));
    }

    @Override
    public User getUserLogin(String login) {
        return (UserDao.getUserLogin(login));
    }

    @Override
    public List<String> getUserRole(String login) {
        return (UserDao.getUserRole(login));
    }

    @Override
    public List<User> selectAllUsers() {
        return (UserDao.selectAllUsers());
    }

    @Override
    public boolean insertUser(User user) throws SQLException {
        return (UserDao.insertUser(user));
    }

    @Override
    public boolean updateUser(User user, String id) throws SQLException {
        return (UserDao.updateUser(user, id));
    }

    @Override
    public boolean deleteUser(String login) throws SQLException {
        return (UserDao.deleteUser(login));
    }

    @Override
    public boolean validate(User loginBean) throws ClassNotFoundException {
        return (loginDao.validate(loginBean));
    }

    @Override
    public List<String> getRoles(String login) throws SQLException {
        return (loginDao.getRoles(login));
    }
}
