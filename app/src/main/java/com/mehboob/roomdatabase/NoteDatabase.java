package com.mehboob.roomdatabase;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class,version = 1)
public abstract class NoteDatabase extends RoomDatabase {
private static final String DATABASE_NAME="note_database";
    public static NoteDatabase instance;

    public abstract NoteDao noteDao();
    public static synchronized NoteDatabase getInstance(Application application){


        if (instance==null){
            instance= Room.databaseBuilder(application,NoteDatabase.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
