package com.example.roomdb.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CourseWithQuiz {

    @Embedded public Course course;
    @Relation(parentColumn = "course_name", entityColumn = "id")
    public List<Quiz> quizzes;
}
