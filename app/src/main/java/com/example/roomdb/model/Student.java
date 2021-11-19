package com.example.roomdb.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Random;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "student_id")
    private int studentId;


    public Student(){
        int id = new Random().nextInt((9999 - 100) + 1) + 10;
        studentId = id;
    }

    public void setStudentId(int id){
        studentId = id;
    }

    public int getStudentId(){
        return  studentId;
    }

    public String toString(){
        return studentId+"";
    }
}
