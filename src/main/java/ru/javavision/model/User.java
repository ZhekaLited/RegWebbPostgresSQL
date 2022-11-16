package ru.javavision.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author : Evgeniy Nechaev .
 * Created : 03/11/2022.
 * <p>
 */
public class User {

    private int id;

    private String login;

    private String password;

    private String email;
    private String surname;

    private String name;

    private String patronymic;

    private Date birthday = null;
    private ROLE role;

    private SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = formatDate.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public User() {
    }

    public User(int id, String login, String password, String email, String surname, String name, String patronymic, String birthday, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;

        try {
            this.birthday = formatDate.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public enum ROLE {
        USER, UNKNOWN, ADMIN
    }
}
