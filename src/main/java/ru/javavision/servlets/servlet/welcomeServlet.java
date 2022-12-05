package ru.javavision.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Welcome.
 * Show welcome page.
 */

public class welcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hide", "hidden");
        req.setAttribute("hideAdmin", "hidden");
        req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);
    }
}
