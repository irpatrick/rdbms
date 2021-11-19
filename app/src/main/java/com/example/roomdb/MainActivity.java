package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.roomdb.dao.AppDatabase;
import com.example.roomdb.model.Course;
import com.example.roomdb.model.Student;
import com.example.roomdb.model.StudentWithQuiz;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    AppDatabase database;
    MainAdapter datapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatabase();
    }

    private void startAsyncTask(View v){
        ExecuteInBack task = new ExecuteInBack();
        task.execute(12);
    }

    private class ExecuteInBack extends AsyncTask<Integer, Integer, String>{

        @Override
        protected String doInBackground(Integer... integers) {
            initDatabase();
            return "Hello";
        }
    }

    public void initDatabase(){
        database = AppDatabase.getInstance(this);

        for(int i=0;i<3;i++){
            Course c = new Course("DPSD"+i);
//            database.courseDao().insert(c);



        }
        List<Course> courses = database.courseDao().getAll();
        for(Course course: courses){
            System.out.println(course);
        }

        System.out.println("Hello world !@#@#@#@#@#");

    }
}