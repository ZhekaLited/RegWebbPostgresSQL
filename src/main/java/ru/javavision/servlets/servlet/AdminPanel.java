package ru.javavision.servlets.servlet;

import ru.javavision.model.User;
import ru.javavision.service.UserServiceImplFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Welcome.
 * Show adminPanel page.
 */
public class AdminPanel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("hide", "hidden");
        List<User> listUser = UserServiceImplFactory.getUserService().selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("WEB-INF/jsp/adminPanel.jsp").forward(request, response);
    }
}
