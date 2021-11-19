package com.example.roomdb.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import java.util.Random;

@Entity(tableName = "quiz")
public class Quiz {
    @PrimaryKey
    @ColumnInfo(name = "quiz_id")
    private int quizId;
    @ColumnInfo(name = "quiz_name")
    private String name;

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = new Random().nextInt((9999 - 100) + 1) + 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
