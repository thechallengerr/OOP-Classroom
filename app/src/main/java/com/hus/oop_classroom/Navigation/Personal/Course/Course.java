package com.hus.oop_classroom.Navigation.Personal.Course;

import com.google.type.Date;

public class Course {
    private int course_photo_ID,attendant,fee;
    private String course_name;
    private String teacher;
    private Date course_startday;

    public Course(int course_photo_ID, int attendant,int fee, String course_name, String teacher, Date course_startday) {
        this.course_photo_ID = course_photo_ID;
        this.attendant = attendant;
        this.course_name = course_name;
        this.teacher = teacher;
        this.course_startday = course_startday;
        this.fee=fee;
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

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Date getCourse_startday() {
        return course_startday;
    }

    public void setCourse_startday(Date course_startday) {
        this.course_startday = course_startday;
    }
}
