package com.mehboob.roomdatabase;

import android.app.Application;
import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepo noteRepo;
    private LiveData<List<Note>> noteList;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepo= new NoteRepo(application);
        noteList=noteRepo.getAllNotes();
    }

    public void insert(Note note){
        noteRepo.insertNote(note);
    }
    public void update(Note note){
        noteRepo.updateNote(note);
    }
    public void delete(Note note){
        noteRepo.deleteNote(note);
    }


    public LiveData<List<Note>> getNoteList(){
        return noteList;
    }

}
