package com.hus.oop_classroom.model;

import java.util.ArrayList;

public abstract class Users {
    private String email;
    private Integer role;
    private String username;
    private String password;
    private String avatar;
    private ArrayList<Courses_Accessed> Courses_Accessed;

    public Users(String email, Integer role, String username, String password, String avatar, ArrayList<Courses_Accessed> courses_Accessed) {
        this.email = email;
        this.role = role;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        Courses_Accessed = courses_Accessed;
    }

    public Users() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(String email, Integer role, String username, String password) {
        this.email = email;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return role;
    }

    public void setType(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    public String getRoleName(Users users) {
//        if(users.getType() == 1 ){
//            return "Giảng viên";
//        }else{
//            return "Sinh viên";
//        }
//    }
    public abstract void ActionCourse(Users users);

    public abstract void getCourse(Users users);


}
