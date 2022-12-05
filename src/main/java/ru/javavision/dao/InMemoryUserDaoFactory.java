package ru.javavision.dao;

public class InMemoryUserDaoFactory {
    private InMemoryUserDaoFactory() {
    }
    public static DaoUser daoUser() {
        return new UserDAO();
    }

    public static LoginDao loginDao() {
        return new LoginDao();
    }
}
