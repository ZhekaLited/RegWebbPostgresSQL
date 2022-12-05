package ru.javavision.service;

public class UserServiceImplFactory {
    private UserServiceImplFactory() {
    }

    public static UserService getUserService() {
        return UserServiceImpl.getINSTANCE();
    }
}

