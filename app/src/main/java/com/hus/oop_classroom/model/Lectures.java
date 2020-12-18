package com.hus.oop_classroom.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hus.oop_classroom.R;

public class Lectures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}