package com.hus.oop_classroom.model;

import java.util.ArrayList;

public class Teacher extends Users{
    public Teacher(String email, Integer role, String username, String password, String avatar, ArrayList<com.hus.oop_classroom.model.Courses_Accessed> courses_Accessed) {
        super(email, role, username, password, avatar, courses_Accessed);
    }
    public  Teacher() {

    }
    public boolean addCourse(Course course) {

        return true;
    }
    public boolean editCourse(Course course) {
        return true;
    }
    public boolean deleteCourse(Course course) {
        return true;
    }
    public boolean updateCourse(Course course) {
        return true;
    }

    @Override
    public void getCourse(Users users) {
    }

    @Override
    public void ActionCourse(Users users) {
    }

}
