package com.example.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.example.roomdb.model.Course;


@Dao
public interface CourseDao {
    @Query("SELECT * FROM course")
    List<Course> getAll();
    @Insert
    void insert(Course course);

}
