package com.hus.oop_classroom.model;

import com.google.type.Date;

import java.util.List;

public class Course {
    private int course_photo_ID;
    private int attendant,price;
    private String course_name;
    private String teacher;
    private Date course_startday;
    private String course_description;

    private List<Lectures> lectures = null;

    public Course(int course_photo_ID, int attendant, int price, String course_name, String teacher, Date course_startday, String course_description, List<Lectures> lectures) {
        this.course_photo_ID = course_photo_ID;
        this.attendant = attendant;
        this.price = price;
        this.course_name = course_name;
        this.teacher = teacher;
        this.course_startday = course_startday;
        this.course_description = course_description;
        this.lectures = lectures;
    }

    public int getCourse_photo_ID() {
        return course_photo_ID;
    }

    public void setCourse_photo_ID(int course_photo_ID) {
        this.course_photo_ID = course_photo_ID;
    }

    public int getAttendant() {
        return attendant;
    }

    public void setAttendant(int attendant) {
        this.attendant = attendant;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public Date getCourse_startday() {
        return course_startday;
    }

    public void setCourse_startday(Date course_startday) {
        this.course_startday = course_startday;
    }

    public List<Lectures> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lectures> lectures) {
        this.lectures = lectures;
    }
}
