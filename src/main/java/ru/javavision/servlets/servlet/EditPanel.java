package ru.javavision.servlets.servlet;

import ru.javavision.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ru.javavision.dao.UserDAO.store;

public class EditPanel extends HttpServlet {
    public String id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getParameter("id");

        for (User user : store) {
            if (user.getPassword().equals(id)) {
                req.setAttribute("login", user.getLogin());
                req.setAttribute("password", user.getPassword());
                req.setAttribute("email", user.getEmail());
                req.setAttribute("surname", user.getSurname());
                req.setAttribute("name", user.getName());
                req.setAttribute("patronymic", user.getPatronymic());
                Date date = user.getBirthday();
                req.setAttribute("birthday", (new SimpleDateFormat("dd.MM.yyyy")).format(date));

                if(user.getRole().toString().equals("USER")) {
                    req.setAttribute("selectedUser","selected");
                }
                else {
                    req.setAttribute("selectedAdmin" , "selected");
                }
            }
        }

        req.getRequestDispatcher("/WEB-INF/jsp/editPanel.jsp").forward(req, resp);
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

        for (User user : store) {
            if(id.equals(user.getPassword())) {
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                user.setSurname(surname);
                user.setName(name);
                user.setPatronymic(patronymic);
                user.setBirthday(birthday);

                if (role.equals(User.ROLE.USER.toString())) {
                    user.setRole(User.ROLE.USER);
                }
                else {
                    user.setRole(User.ROLE.ADMIN);
                }
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/adminPanel.jsp").forward(req, resp);
    }
}
