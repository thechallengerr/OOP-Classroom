package com.hus.oop_classroom;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseList extends AppCompatActivity {
    ArrayList<Course>   courseArrayList;
    RecyclerView recyclerView;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        recyclerView = findViewById(R.id.recycler_course);
        courseArrayList= new ArrayList<>();



    }
}
