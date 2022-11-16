package ru.javavision.servlets;


import ru.javavision.dao.UserDAO;
import ru.javavision.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static ru.javavision.model.User.ROLE.ADMIN;
import static ru.javavision.model.User.ROLE.USER;

/**
 * ContextListener put user dao to servlet context.
 */
@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * Fake database connector.
     */
    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "Vlad", "12345", "vlad@mail.ru" , "Petrov" , "Vlad" ,"Alexey","04.07.1985",USER));
        dao.get().add(new User(2, "Anna", "1234", "Anna@mail.ru" , "Lopushkova" , "Anna" ,"Viktor","04.04.1999",USER));
        dao.get().add(new User(3, "Zhenya", "123", "Zhenya@mail.ru" , "Geralkov" , "Zhenya" ,"Alex","04.06.1999",ADMIN));
        dao.get().add(new User(4, "Andrey", "1235", "Andrey@mail.ru" , "Mahanov" , "Zhenya" ,"Gena","04.06.1949",USER));
        dao.get().add(new User(5, "Gleb", "1236", "Gleb@mail.ru" , "Svintsov" , "Sasha" ,"Petya","04.06.1995",USER));
        dao.get().add(new User(6, "Anton", "1237", "Anton@mail.ru" , "Reznik" , "Vasya" ,"Anton","04.06.1997",USER));
        dao.get().add(new User(7, "Sasha", "1238", "Sasha@mail.ru" , "Mashkin" , "Lovko" ,"Alex","04.06.1998",USER));


        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}