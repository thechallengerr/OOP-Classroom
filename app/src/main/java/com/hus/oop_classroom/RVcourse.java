package com.hus.oop_classroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hus.oop_classroom.Adapter.CourseAdapter;
import com.hus.oop_classroom.model.Course;

import java.util.ArrayList;
import java.util.List;

public class RVcourse extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef=firebaseDatabase.getReference();
    private ArrayList<Course> course_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        recyclerView=findViewById(R.id.course_recycler);
        courseAdapter = new CourseAdapter(this);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        courseAdapter.setData(getCourseList());

        course_list=new ArrayList<Course>();
        myRef=FirebaseDatabase.getInstance().getReference("Courses");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    Course course=ds.getValue(Course.class);
                    course_list.add(course);
                }
                recyclerView.setAdapter(courseAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private ArrayList<Course> getCourseList() {
        List<Course> list= new ArrayList<Course>();
        return (ArrayList<Course>) list;
    }
}