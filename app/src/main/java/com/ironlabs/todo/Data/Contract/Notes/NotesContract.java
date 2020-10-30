package com.ironlabs.todo.Data.Contract.Notes;

import com.ironlabs.todo.Data.Adapter.Notes.NotesAdapter;
import com.ironlabs.todo.Data.Entity.Notes.Note;

public interface NotesContract {

    interface View {

        void updateNotes(NotesAdapter adapter);
    }

    interface Presenter {
        void addNote(Note note);
        NotesAdapter getNotes();
        void deleteNote(String id);
    }


}
