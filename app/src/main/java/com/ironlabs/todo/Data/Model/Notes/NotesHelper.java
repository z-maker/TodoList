package com.ironlabs.todo.Data.Model.Notes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class NotesHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "notes.db";

    private static final String CREATE_TABLE = "CREATE TABLE " + NotesModel.Entry.TABLE_NAME +
        "("
        + NotesModel.Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + NotesModel.Entry.ID + " TEXT NOT NULL,"
        + NotesModel.Entry.NAME + " TEXT NOT NULL,"
        + NotesModel.Entry.CONTENT + " TEXT NOT NULL,"
        + NotesModel.Entry.TAG + " TEXT NOT NULL,"
        + NotesModel.Entry.DATE_CREATED + " TIMESTAMP DEFAULT (datetime(CURRENT_TIMESTAMP, 'localtime')),"
        + NotesModel.Entry.TYPE + " INTEGER NOT NULL,"
        + "UNIQUE (" + NotesModel.Entry.ID + "))";

    NotesHelper(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NotesModel.Entry.TABLE_NAME);
        onCreate(db);
    }

}
