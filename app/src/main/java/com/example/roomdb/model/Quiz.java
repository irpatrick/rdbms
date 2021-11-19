package com.example.roomdb.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

@Entity(tableName = "quiz")
public class Quiz {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int quizId;
    @NonNull
    @ColumnInfo(name = "student_id")
    private int student;

    @NonNull
    @ColumnInfo(name = "course_name")
    private String course;
    @ColumnInfo(name = "student_grade")
    private int grade;


    public Quiz(int st, String c, int g){
      student = st;
      course = c;
      grade = g;
    }
    public Quiz(){
        this(0,null,0);
    }

    public int getQuizId(){
        return quizId;
    }

    public void setQuizId(int id){
        quizId = id;
    }
    public void setStudent(int st){
        student = st;
    }
    public void setGrade(int g){
        grade = g;
    }
    public void setCourse(String c){
        course = c;
    }

    public String getCourse(){
        return course;
    }
    public int getStudent(){
        return student;
    }
    public int getGrade(){
        return grade;
    }

    public String toString(){
        return student+" : "+grade;
    }
}
