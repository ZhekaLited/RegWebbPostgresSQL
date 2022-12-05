package ru.javavision.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Author : Evgeniy Nechaev .
 * Created : 03/11/2022.
 * <p>
 */
public class User {

    private Integer Id;


    private String login;

    private String password;

    private int age;

    private int salary;

    private String name;

    private LocalDate birthday = null;



    private List<String> role;

    public User(Integer Id, String login, String password, int age, int salary, String name, LocalDate birthday, List<String> role) {
        this.Id = Id;
        this.login = login;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
    }

    public User() {
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public enum ROLE {
        USER, UNKNOWN, ADMIN
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        User user = (User) o;
//        return login.equals(user.getLogin());
//    }
//
//    @Override
//    public int hashCode() {
//        return this.id;
//    }
}
