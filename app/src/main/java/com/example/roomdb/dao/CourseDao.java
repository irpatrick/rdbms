package com.example.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.example.roomdb.model.Course;


@Dao
public interface CourseDao {
    @Query("SELECT * FROM course")
    List<Course> getAll();


    @Query("SELECT * FROM course WHERE course_name = :course_name")
    Course getCourse(String course_name);

    @Insert
    void insert(Course course);


    @Query("DELETE FROM course")
    void deleteAll();

}
