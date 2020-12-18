package com.hus.oop_classroom.Navigation.Personal.Course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hus.oop_classroom.Adapter.CourseAdapter;
import com.hus.oop_classroom.R;

public class Nav_Course extends AppCompatActivity {
    private RecyclerView RvCourse;
    private CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        RvCourse= findViewById(R.id.course_recycler);
        courseAdapter= new CourseAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RvCourse.setLayoutManager(linearLayoutManager);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}