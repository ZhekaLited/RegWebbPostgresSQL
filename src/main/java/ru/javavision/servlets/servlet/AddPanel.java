package ru.javavision.servlets.servlet;

import ru.javavision.model.User;
import ru.javavision.servlets.ContextListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.javavision.dao.UserDAO.store;

public class AddPanel extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/WEB-INF/jsp/addPanel.jsp").forward(req,resp);

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String patronymic = req.getParameter("patronymic");
        String birthday = req.getParameter("birthday");
        String role = req.getParameter("role");



        if (role.equals(User.ROLE.USER.toString())) {
            store.add(new User(3 ,login , password , email , surname , name , patronymic , birthday , User.ROLE.USER));
        }
        else {
            store.add(new User(2,login,password,email,surname,name,patronymic,birthday,User.ROLE.ADMIN));
        }
        resp.sendRedirect(req.getContextPath() + "/adminPanel");

    }
}
