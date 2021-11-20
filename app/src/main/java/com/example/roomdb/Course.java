package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.roomdb.dao.AppDatabase;
import com.example.roomdb.model.Grade;
import com.example.roomdb.model.Quiz;

import java.util.List;

public class Course extends AppCompatActivity {
    List<Grade> grades;
    AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        getRows();

    }



    public void getRows(){
        database = AppDatabase.getInstance(this);

        grades = database.gradeDao().getWhereCourse(getIntent().getExtras().get("course").toString());
        for(Grade grade : grades){
            View layout = getLayoutInflater().inflate(R.layout.row_view, null, false);
            ((TextView)layout.findViewById(R.id.student)).setText(grade.getStudentId()+"");
            Quiz quiz = database.quizDao().getQuiz(grade.getQuizId());
            ((TextView)layout.findViewById(R.id.quiz)).setText(quiz.getName());
            ((TextView)layout.findViewById(R.id.score)).setText(grade.getScore()+"");
            ((LinearLayout)findViewById(R.id.ll2)).addView(layout);
        }
    }
}