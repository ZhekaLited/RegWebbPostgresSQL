package ru.javavision.dao;

import ru.javavision.model.User;

public interface Dao {
    public boolean add(final User user);
    public User.ROLE getRoleByLoginPassword(final String login, final String password);
    public boolean userIsExist(final String login, final String password);
}
