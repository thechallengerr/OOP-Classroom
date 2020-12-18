package com.hus.oop_classroom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hus.oop_classroom.R;
import com.hus.oop_classroom.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Course> course_list;

    public CourseAdapter(Context context) {
        this.context = context;
    }

    public  void setData(ArrayList<Course> course_list){
        this.course_list=course_list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_custom_item,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = course_list.get(position);
        if (course==null){
            return;
        }
        holder.imageview.setImageResource(course.getCourse_photo_ID());
        holder.course_name.setText(course.getCourse_name());
        holder.teacher.setText(course.getTeacher());
        holder.attendant.setText(course.getAttendant());

    }

    @Override
    public int getItemCount() {
        if (course_list != null)
        {
            return course_list.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageview;
        private TextView course_name, course_time,course_startday,teacher,attendant;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.course_photo);
            course_time=itemView.findViewById(R.id.course_time);
            course_startday=itemView.findViewById(R.id.course_startday);
            course_name=itemView.findViewById(R.id.course_name);
            teacher=itemView.findViewById(R.id.teacher);
            attendant=itemView.findViewById(R.id.attendant);
        }
    }
}
