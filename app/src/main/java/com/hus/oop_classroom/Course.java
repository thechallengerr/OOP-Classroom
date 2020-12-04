package com.hus.oop_classroom;

public class Course {
    String course_name, teacher;
    int attendant;

    public Course(String course_name, String teacher, int attendant) {
        this.course_name = course_name;
        this.teacher = teacher;
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

    public int getAttendant() {
        return attendant;
    }

    public void setAttendant(int attendant) {
        this.attendant = attendant;
    }
}
