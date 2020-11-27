package com.hus.oop_classroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Home extends AppCompatActivity implements  View.OnClickListener{

    LinearLayout profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Wtf man", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
//        View header = navigationView.getHeaderView(0);
//        profile = header.findViewById(R.id.profile);
//        profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.profile) {
            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
            startActivity(intent);
        }

    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_courses) {
//            Intent intent = new Intent(getApplicationContext(), Course.class);
//            startActivity(intent);
//        } else if (id == R.id.nav_events) {
//            Intent intent = new Intent(getApplicationContext(), Events.class);
//            startActivity(intent);
//
//        } else if (id == R.id.nav_lectures) {
//            Intent intent = new Intent(getApplicationContext(), Lectures.class);
//            startActivity(intent);
//        } else if (id == R.id.nav_announcements) {
//            Intent intent = new Intent(getApplicationContext(), Announcements.class);
//            startActivity(intent);
//        } else if (id == R.id.nav_settings) {
//            Intent intent = new Intent(getApplicationContext(), Setting.class);
//            startActivity(intent);
//
//        } else if (id == R.id.nav_logout) {
//            finish();
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_rate) {
//
//        }
//
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;    }

}