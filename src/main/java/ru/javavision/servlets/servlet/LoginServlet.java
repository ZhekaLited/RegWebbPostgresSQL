package ru.javavision.servlets.servlet;

import ru.javavision.dao.LoginDao;
import ru.javavision.model.User;
import ru.javavision.service.UserServiceImplFactory;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User loginBean = new User();
        loginBean.setLogin(login);
        loginBean.setPassword(password);

        try {
            if (UserServiceImplFactory.getUserService().validate(loginBean)) {
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                session.setAttribute("password", password);

                if (UserServiceImplFactory.getUserService().getRoles(login).contains("Admin") ||
                        UserServiceImplFactory.getUserService().getRoles(login).contains("Editor")) {
                    session.setAttribute("role", "ADMIN");
                    response.sendRedirect("/RegWebb_war/adminMenu");
                } else {
                    response.sendRedirect(request.getContextPath() + "/welcome");
                    session.setAttribute("role", "USER");
                }
            } else {
                response.sendRedirect("/RegWebb_war/login");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}