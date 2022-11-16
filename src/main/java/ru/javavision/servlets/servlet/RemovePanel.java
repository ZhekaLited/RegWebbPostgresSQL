package ru.javavision.servlets.servlet;

import ru.javavision.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.javavision.dao.UserDAO.store;

public class RemovePanel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        for (User user : store) {
            if (user.getPassword().equals(id)) {
                store.remove(user);
                break;
            }
        }

        req.getRequestDispatcher("/WEB-INF/jsp/adminPanel.jsp").forward(req, resp);
    }

}
