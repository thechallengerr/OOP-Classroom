package com.hus.oop_classroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hus.oop_classroom.Navigation.Personal.Course.Nav_Course;
import com.hus.oop_classroom.model.Teacher;

public class TeachersHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_home);
    }
    public void Back_home (View v){
        startActivity(new Intent(TeachersHome.this, Home.class));
        finish();
    }

}