package com.example.roomdb.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class StudentWithQuiz {
    @Embedded public Student student;
    @Relation(
            parentColumn = "student_id",
            entityColumn = "id"
    )
    public List<Quiz> quizzes;
}
