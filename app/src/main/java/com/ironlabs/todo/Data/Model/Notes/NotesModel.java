package com.ironlabs.todo.Data.Model.Notes;

import android.database.Cursor;
import android.provider.BaseColumns;

import com.ironlabs.todo.Data.Entity.Notes.Note;

public class NotesModel {

     public static abstract class Entry implements BaseColumns{

        public static final String TABLE_NAME = "note";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String TAG = "tag";
        public static final String TYPE = "type";
        public static final String CONTENT = "content";
        public static final String DATE_CREATED = "date_created";

    }

    public static Note noteFromCursor(Cursor cursor){

        int id = cursor.getColumnIndex(Entry.ID);
        int name = cursor.getColumnIndex(Entry.NAME);
        int content = cursor.getColumnIndex(Entry.CONTENT);
        int tag = cursor.getColumnIndex(Entry.TAG);
        int type = cursor.getColumnIndex(Entry.TYPE);
        int date = cursor.getColumnIndex(Entry.DATE_CREATED);

        Note n = new Note();

        n.setId(cursor.getString(id));
        n.setContent(cursor.getString(content));
        n.setName(cursor.getString(name));
        n.setType(cursor.getInt(type));
        n.setTag(cursor.getString(tag));
        n.setDateCreated(cursor.getString(date));

        return n;

    }

}
