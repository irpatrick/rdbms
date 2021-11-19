package com.example.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import com.example.roomdb.model.Quiz;

@Dao
public interface QuizDao {
    @Query("SELECT * FROM quiz")
    List<Quiz> getAll();

    @Query("SELECT * FROM quiz WHERE quiz_id = :quiz_id")
    Quiz getQuiz(int quiz_id);

    @Insert
    void insert(Quiz quiz);

    @Query("DELETE FROM quiz")
    void deleteAll();
}
