package com.example.roomdb.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdb.model.Course;
import com.example.roomdb.model.Grade;
import com.example.roomdb.model.Quiz;
import com.example.roomdb.model.Student;

@Database(entities = {Course.class, Quiz.class, Student.class, Grade.class}, version = 11, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static  AppDatabase instance;
    public abstract CourseDao courseDao();
    public abstract StudentDao studentDao();
    public abstract QuizDao quizDao();
    public abstract GradeDao gradeDao();
    public static boolean isCreated = true;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            isCreated = false;
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "course_database")
                            .fallbackToDestructiveMigration().allowMainThreadQueries()
                            .build();
        }

        return instance;
    }



}