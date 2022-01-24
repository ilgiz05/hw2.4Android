package com.example.hw24android.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.hw24android.interfaces.TaskDao;
import com.example.hw24android.model.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
        public abstract TaskDao taskDao();
}
