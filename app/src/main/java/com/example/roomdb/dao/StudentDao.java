package com.example.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import com.example.roomdb.model.Student;
import com.example.roomdb.model.StudentWithQuiz;

@Dao
public interface StudentDao {
    @Transaction
    @Query("SELECT * FROM student")
    List<StudentWithQuiz> getStudentWithQuiz();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Student student);

}
