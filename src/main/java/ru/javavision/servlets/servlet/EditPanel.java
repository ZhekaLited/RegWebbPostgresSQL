package ru.javavision.servlets.servlet;


import ru.javavision.model.User;
import ru.javavision.service.UserServiceImplFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class EditPanel extends HttpServlet {

//    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = UserServiceImplFactory.getUserService().getUserLogin(req.getParameter("id"));
        List<String> roles = UserServiceImplFactory.getUserService().getUserRole(req.getParameter("id"));

        req.setAttribute("login", user.getLogin());
        req.setAttribute("password", user.getPassword());
        req.setAttribute("name", user.getName());
        req.setAttribute("birthday", user.getBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        req.setAttribute("salary", user.getSalary());
        for (String role : roles) {
            switch (role) {
                case "Admin":
                    req.setAttribute("selectedAdmin", "selected");
                    break;
                case "User":
                    req.setAttribute("selectedUser", "selected");
                    break;
                case "Author":
                    req.setAttribute("selectedAuthor", "selected");
                    break;
                case "Manager":
                    req.setAttribute("selectedManager", "selected");
                    break;
                case "Editor":
                    req.setAttribute("selectedEditor", "selected");
                    break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/editPanel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean correct = false;

            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            LocalDate birthday = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            int age = Period.between(birthday, LocalDate.now()).getYears();
            int salary = Integer.parseInt(req.getParameter("salary"));
            List<String> roles = null;
            if (req.getParameterValues("role") != null) {
                roles = Arrays.asList(req.getParameterValues("role"));
            }

            try {
                UserServiceImplFactory.getUserService().updateUser(new User(0, login, password, age, salary, name, birthday, roles), req.getParameter("id"));
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }

//        if (correct) {
//            resp.sendRedirect(req.getContextPath() + "/editPanel");
//        } else {
        resp.sendRedirect(req.getContextPath() + "/adminPanel");
    }
}