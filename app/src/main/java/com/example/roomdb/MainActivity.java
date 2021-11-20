package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.roomdb.dao.AppDatabase;
import com.example.roomdb.model.Course;
import com.example.roomdb.model.Grade;
import com.example.roomdb.model.Quiz;
import com.example.roomdb.model.Student;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    AppDatabase database;
    MainAdapter datapter;
    List<Course> courses;
//    private Object MainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initDatabase();
        getAllCourses();

    }



    public void addRow(String text){
        View layout = getLayoutInflater().inflate(R.layout.row, null, false);
        Button b = layout.findViewById(R.id.courseLink);
        b.setText(text);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.roomdb.Course.class);
                intent.putExtra("course", text);
                startActivity(intent);
            }
        });
        ((LinearLayout)findViewById(R.id.ll)).addView(layout);
    }
    public void getAllCourses(){
        database = AppDatabase.getInstance(this);
        courses = database.courseDao().getAll();
        for (Course c : courses){
            addRow(c.getCourseName());
        }
    }

    public void initDatabase(){

        database = AppDatabase.getInstance(this);

        if(database.courseDao().getAll().size()>0){
            return;
        }
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
                    g.setScore(i+j*i);
                    g.setStudentId(st.getStudentId());
                    database.gradeDao().insert(g);
                }
            }


        Course c2 = new Course("DIAML");
        database.courseDao().insert(c2);
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
                g.setCourseId(c2.getCourseName());
                g.setQuizId(q.getQuizId());
                g.setScore(i*j);
                g.setStudentId(st.getStudentId());
                database.gradeDao().insert(g);
            }
        }


        Course c3 = new Course("FS");
        database.courseDao().insert(c3);
        for (int j=1;j<3;j++){
            Student st = new Student();
            database.studentDao().insert(st);
            for(int i=1; i<6; i++){
                Quiz q = new Quiz();
                q.setQuizId( new Random().nextInt(i*j)+(i*j));
                q.setName("Q"+i);
                database.quizDao().insert(q);
                Grade g = new Grade();
//                    g.setGradeId(new Random().nextInt(i+j)+(i+j));
                g.setCourseId(c3.getCourseName());
                g.setQuizId(q.getQuizId());
                g.setScore(i*j);
                g.setStudentId(st.getStudentId());
                database.gradeDao().insert(g);
            }
        }
//        List<Course> courses = database.courseDao().getAll();
//        List<Student> l = database.studentDao().getAll();
//        List<Grade> grades = database.gradeDao().getWhereCourse(courses.get(0).getCourseName());
//        List<Quiz> quizzes = database.quizDao().getAll();
//        for(Grade g: grades){
//            System.out.println(g.getQuizId());
//        }

    }
}