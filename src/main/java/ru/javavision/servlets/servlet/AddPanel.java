package ru.javavision.servlets.servlet;

import ru.javavision.model.User;
import ru.javavision.service.UserServiceImplFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class AddPanel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String name = request.getParameter("name");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        int age = Period.between(birthday, LocalDate.now()).getYears();

        List<String> roles = null;
        if (request.getParameterValues("roles") != null) {
            roles = Arrays.asList(request.getParameterValues("roles"));
        }

        User newUser = new User(0, login, password, age, salary, name, birthday, roles);
        try {
            UserServiceImplFactory.getUserService().insertUser(newUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/adminPanel");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/addPanel.jsp").forward(request, response);
    }


//    private static UserService userServiceImpl = UserServiceImplFactory.getUserService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter("rer").equals("t")) {
//            req.setAttribute("ShowError", "You need to enter the correct data");
//        }
//        req.getRequestDispatcher("/WEB-INF/jsp/addPanel.jsp").forward(req, resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean addd = false;
//
//        if (UserServiceImplFactory.getUserService().Validation(req.getParameter("login"), req.getParameter("password"),
//                req.getParameter("email"), req.getParameter("surname"), req.getParameter("name"), req.getParameter("patronymic"),
//                req.getParameter("birthday"))) {
//
//
//            String login = req.getParameter("login");
//            String password = req.getParameter("password");
//            String email = req.getParameter("email");
//            String surname = req.getParameter("surname");
//            String name = req.getParameter("name");
//            String patronymic = req.getParameter("patronymic");
//            String birthday = req.getParameter("birthday");
//            String role = req.getParameter("role");
//
//            if (role.equals(User.ROLE.USER.toString())) {
//                addd = (userServiceImpl.create(new User(1, login, password, email, surname, name, patronymic, birthday, User.ROLE.USER)));
//            } else {
//                addd = (userServiceImpl.create(new User(2, login, password, email, surname, name, patronymic, birthday, User.ROLE.ADMIN)));
//            }
//            if (addd)
//                resp.sendRedirect(req.getContextPath() + "/adminPanel");
//            else {
//                resp.sendRedirect(req.getContextPath() + "/addPanel?rer=t");
//
//            }
//        }
//    }
}