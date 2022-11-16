package ru.javavision.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.javavision.dao.UserDAO.store;

/**
 * Welcome.
 * Show adminPanel page.
 */
public class AdminPanel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("User",store);
        req.setAttribute("hide" , "hidden");
        req.getRequestDispatcher("/WEB-INF/jsp/adminPanel.jsp").forward(req,resp);

    }
}
