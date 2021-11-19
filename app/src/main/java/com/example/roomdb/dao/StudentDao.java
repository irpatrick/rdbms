package com.example.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import com.example.roomdb.model.Student;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student")
    List<Student> getAll();


    @Query("SELECT * FROM student WHERE student_id = :student_id")
    Student getStudent(int student_id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Student student);

    @Query("DELETE FROM student")
    void deleteAll();

}
