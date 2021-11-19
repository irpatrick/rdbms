package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.roomdb.dao.AppDatabase;
import com.example.roomdb.model.Course;
import com.example.roomdb.model.Grade;
import com.example.roomdb.model.Quiz;
import com.example.roomdb.model.Student;

import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    AppDatabase database;
    MainAdapter datapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatabase();
    }

//    private void startAsyncTask(View v){
//        ExecuteInBack task = new ExecuteInBack();
//        task.execute(12);
//    }
//
//    private class ExecuteInBack extends AsyncTask<Integer, Integer, String>{
//
//        @Override
//        protected String doInBackground(Integer... integers) {
//            initDatabase();
//            return "Hello";
//        }
//    }

    public void initDatabase(){

        database = AppDatabase.getInstance(this);
            database.studentDao().deleteAll();
            database.gradeDao().deleteAll();
            database.quizDao().deleteAll();
            database.courseDao().deleteAll();
            Course c = new Course("DPSD");
            database.courseDao().insert(c);
            for (int j=1;j<6;j++){
                Student st = new Student();
                database.studentDao().insert(st);
                for(int i=1; i<6; i++){
                    Quiz q = new Quiz();
                    q.setQuizId( new Random().nextInt(i*j)+(i*j));
                    q.setName("Q"+i);
                    database.quizDao().insert(q);
                    Grade g = new Grade();
//                    g.setGradeId(new Random().nextInt(i+j)+(i+j));
                    g.setCourseId(c.getCourseName());
                    g.setQuizId(q.getQuizId());
                    g.setStudentId(st.getStudentId());
                    database.gradeDao().insert(g);
                }
            }
        List<Course> courses = database.courseDao().getAll();
        List<Student> l = database.studentDao().getAll();
        List<Grade> grades = database.gradeDao().getWhereCourse(courses.get(0).getCourseName());
        List<Quiz> quizzes = database.quizDao().getAll();
        for(Grade g: grades){
            System.out.println(g.getQuizId());
        }

    }
}