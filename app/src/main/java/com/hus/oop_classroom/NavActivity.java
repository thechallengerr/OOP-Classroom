//package com.hus.oop_classroom;
//
//import android.content.ClipData;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//import java.util.ArrayList;
//
//public class NavActivity extends AppCompatActivity {
//    ListView listView;
//    NavAdapter navAdapter;
//    ArrayList<Select> list;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_drawer);
////        Toolbar appToolbar = (Toolbar) findViewById(R.id.app_toolbar);
////        setSupportActionBar(appToolbar);
////        list = new ArrayList<>();
////        listView = findViewById(R.id.Nav_setting);
////        list.add(new Select(R.drawable.ic_school,"Course"));
////        list.add(new Select(R.drawable.ic_schedule,"Schedule"));
////        list.add(new Select(R.drawable.ic_event,"Event"));
////        list.add(new Select(R.drawable.ic_profile,"Profile"));
////        list.add(new Select(R.drawable.ic_menu_send_24,"Send feedback"));
////        list.add(new Select(R.drawable.ic_menu_share,"Share this app"));
////        list.add(new Select(R.drawable.ic_baseline_bug_report_24,"Report bug"));
////        list.add(new Select(R.drawable.ic_exit_to_app,"Logout"));
////
////
////
////
////
////        navAdapter = new NavAdapter(list);
////        listView.setAdapter(navAdapter);
////        listView.setOnItemClickListener((parent, view, position, id) -> {
//            switch (list.get(position).getId()){
//                case R.drawable.ic_school:
//                    startActivity(new Intent(NavActivity.this,Course.class));
//
//                    break;
//                case R.drawable.ic_event:
//                    startActivity(new Intent(NavActivity.this,Events.class));
//                    break;
//                case R.drawable.ic_profile:
//                    startActivity(new Intent(NavActivity.this,UserProfile.class));
//                    break;
//                case  R.drawable.ic_menu_share:
//                    startActivity(new Intent(NavActivity.this,Share.class));
//                    break;
//                case R.drawable.ic_baseline_bug_report_24:
//                    startActivity(new Intent(NavActivity.this, Report.class));
//                case R.drawable.ic_exit_to_app:
//                    startActivity(new Intent(NavActivity.this,Login.class));
//                    finish();
//
//
//            }
//        });
//
//    }
//}
