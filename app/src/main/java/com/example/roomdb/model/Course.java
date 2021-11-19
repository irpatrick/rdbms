package com.example.roomdb.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Random;

@Entity(tableName = "course")
public class Course {
    @PrimaryKey
    @ColumnInfo(name = "course_name")
    @NonNull
    private String courseName;


    public Course(){

        this("RandomName-"+new Random().nextInt());
    }
    public Course(String course){
        courseName = course;
    }
    public void setCourseName(String course){
        courseName = course;
    }

    public String getCourseName(){
        return  courseName;
    }

    public String toString(){
        return  courseName;
    }

}
