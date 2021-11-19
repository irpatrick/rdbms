package com.example.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.roomdb.model.Grade;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("SELECT * FROM grade")
    List<Grade> getAll();

    @Query("SELECT * FROM grade WHERE course_name = :course_name")
    List<Grade> getWhereCourse(String course_name);

    @Insert
    void insert(Grade grade);

    @Delete
    void delete(Grade grade);

    @Query("DELETE FROM grade")
    void deleteAll();

}
