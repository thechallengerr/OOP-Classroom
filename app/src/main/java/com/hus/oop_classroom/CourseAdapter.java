package com.hus.oop_classroom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CourseAdapter> course_list;
     ImageView imageview;
     TextView course_name, course_time,course_startday,teacher,attendant;

    public CourseAdapter(Context context, ArrayList<CourseAdapter> course_list) {
        this.context = context;
        this.course_list = course_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return course_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.course_photo);
            course_name=itemView.findViewById(R.id.course_name);
            course_startday=itemView.findViewById(R.id.course_startday);
            course_time= itemView.findViewById(R.id.course_time);
            teacher= itemView.findViewById(R.id.teacher);
            attendant=itemView.findViewById(R.id.attendant);
        }


    }
}
