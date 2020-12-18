package com.hus.oop_classroom.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hus.oop_classroom.R;

public class Announcements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}