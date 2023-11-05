package com.mehboob.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepo {

    private NoteDatabase noteDatabase;
    private Application application;
    private NoteDao noteDao;
    private LiveData<List<Note>> listLiveData;


    public NoteRepo(Application application) {
        this.application = application;
        noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        listLiveData = noteDao.getAllNotes();
    }

    public void insertNote(Note note) {
        new InsertTask(noteDatabase).execute(note);
    }

    public void updateNote(Note note) {
        new UpdateTask(noteDatabase).execute(note);
    }

    public void deleteNote(Note note
    ) {
        new DeleteTask(noteDatabase).execute(note);
    }

    public LiveData<List<Note>> getAllNotes() {
        return listLiveData;
    }

    private static class InsertTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public InsertTask(NoteDatabase noteDatabase) {
            noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class UpdateTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public UpdateTask(NoteDatabase noteDatabase) {
            noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public DeleteTask(NoteDatabase noteDatabase) {
            noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
}
