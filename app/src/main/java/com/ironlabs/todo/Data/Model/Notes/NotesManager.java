package com.ironlabs.todo.Data.Model.Notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ironlabs.todo.Data.Entity.Notes.Note;

public class NotesManager {

    private NotesHelper notesHelper;
    private Context context;
    private SQLiteDatabase database;

    public NotesManager(Context context) {
        this.context = context;
    }

    public NotesManager open() throws SQLException {
        notesHelper = new NotesHelper(context);
        database = notesHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        notesHelper.close();
    }

    public Cursor getAll(){

        String[] columns = {
                NotesModel.Entry.ID,
                NotesModel.Entry.NAME,
                NotesModel.Entry.CONTENT,
                NotesModel.Entry.DATE_CREATED,
                NotesModel.Entry.TAG,
                NotesModel.Entry.TYPE};

        Cursor cursor = database.query(
                NotesModel.Entry.TABLE_NAME,
                columns,
                null,null,null,null,null
        );

        return cursor;

    }

    public boolean add(Note note){
        ContentValues values = new ContentValues();
        values.put(NotesModel.Entry.ID,note.getId());
        values.put(NotesModel.Entry.NAME,note.getName());
        values.put(NotesModel.Entry.CONTENT,note.getContent());
        values.put(NotesModel.Entry.TAG,note.getTag());
        values.put(NotesModel.Entry.TYPE,note.getType());
        return database.insert(NotesModel.Entry.TABLE_NAME, null, values) >= 0;
    }

    public boolean delete(String id){
        return database.delete(NotesModel.Entry.TABLE_NAME,NotesModel.Entry.ID + " = '" +id +"'",null) >= 0;
    }


}
