package com.example.roomdb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb.model.Course;

import java.util.List;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    List<Course> courses;
    Context context;

    public  MainAdapter(Context cx, List courses){
        this.context = cx;
        this.courses = courses;
    }


    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.course.setText(this.courses.get(position).getCourseName());
    }

    @Override
    public int getItemCount() {

        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button course;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           course =  itemView.findViewById(R.id.courseLink);
        }
    }
}
