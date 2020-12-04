package com.hus.oop_classroom.Navigation.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hus.oop_classroom.R;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}