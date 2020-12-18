package com.hus.oop_classroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.hus.oop_classroom.Navigation.Personal.Events;
import com.hus.oop_classroom.Navigation.Personal.Announcements;
import com.hus.oop_classroom.Navigation.Communication.ActivityAppRating;
import com.hus.oop_classroom.Navigation.Communication.ActivityReport;
import com.hus.oop_classroom.Navigation.Communication.ActivityShare;
import com.hus.oop_classroom.Navigation.Personal.Course.Nav_Course;
import com.hus.oop_classroom.Navigation.UserProfile;

public class Home extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.bringToFront();
        ActionBarDrawerToggle drawerToggle= new ActionBarDrawerToggle(this, drawerLayout,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
//        View header = navigationView.getHeaderView(0);
        navigationView.setCheckedItem(R.id.nav_home);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.profile) {
            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
            startActivity(intent);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_announcements:
                startActivity(new Intent(Home.this, Announcements.class));
                break;
            case R.id.nav_courses:
                startActivity(new Intent(Home.this, Nav_Course.class));
                break;
            case R.id.nav_events:
                startActivity(new Intent(Home.this, Events.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(Home.this,UserProfile.class));
                break;
            case R.id.nav_share:
                startActivity(new Intent(Home.this, ActivityShare.class));
                break;
            case R.id.nav_report_bug:
                startActivity(new Intent(Home.this, ActivityReport.class));
                break;
            case R.id.nav_rate:
                startActivity(new Intent(Home.this, ActivityAppRating.class));
                break;
            case R.id.nav_logout:
                startActivity(new Intent(Home.this,Login.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return  true;

    }


}