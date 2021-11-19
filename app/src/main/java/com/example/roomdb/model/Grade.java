package com.example.roomdb.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "grade")
public class Grade {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "grade_id")
    @NonNull
    private int gradeId;
    @ColumnInfo(name = "student_id")
    private int studentId;
    @ColumnInfo(name = "quiz_id")
    private int quizId;
    @ColumnInfo(name = "course_name")
    private String courseName;
    @ColumnInfo(name = "score")
    private double score;


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setQuizId(int id){
        quizId = id;
    }

    public void setGradeId(int id){
        gradeId = id;
    }

    public void setStudentId(int id){
        studentId = id;
    }

    public void setCourseId(String name){
        courseName = name;
    }

    public int getGradeId() {
        return gradeId;
    }

    public int  getStudentId() {
        return studentId;
    }

    public int getQuizId() {
        return quizId;
    }
}
