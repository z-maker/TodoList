package com.ironlabs.todo.Data.Presenter.Notes;

import android.content.Context;

import com.ironlabs.todo.Data.Contract.Notes.NotesContract;
import com.ironlabs.todo.Data.Adapter.Notes.NotesAdapter;
import com.ironlabs.todo.Data.Model.Notes.NotesManager;
import com.ironlabs.todo.Data.Entity.Notes.Note;

public class NotePresenter implements NotesContract.Presenter {

    private NotesContract.View view;
    private NotesManager manager;
    private Context context;

    public NotePresenter(NotesContract.View view, Context context) {
        this.view = view;
        this.context = context;
        this.manager = new NotesManager(context);
    }


    @Override
    public void addNote(Note note) {

        if (manager.open().add(note)){
         view.updateNotes(getNotes());
        }

    }


    @Override
    public NotesAdapter getNotes() {
        manager.open();

        NotesAdapter adapter = new NotesAdapter(context,manager.getAll());

        view.updateNotes(adapter);

        return adapter;

    }


    @Override
    public void deleteNote(String id) {

        manager.open().delete(id);

        view.updateNotes(new NotesAdapter(context,manager.getAll()));

    }
}
