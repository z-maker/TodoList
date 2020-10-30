package com.ironlabs.todo.View;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ironlabs.todo.Data.Adapter.Notes.NotesAdapter;
import com.ironlabs.todo.Data.Contract.Notes.NotesContract;
import com.ironlabs.todo.Data.Entity.Notes.Note;
import com.ironlabs.todo.Data.Model.Notes.NotesManager;
import com.ironlabs.todo.Data.Model.Notes.NotesModel;
import com.ironlabs.todo.Data.Presenter.Notes.NotePresenter;
import com.ironlabs.todo.R;

import java.util.UUID;

public class NoteActivity extends AppCompatActivity {


    private TextInputLayout txtNoteName;
    private TextInputLayout txtNotecontent;
    private Button bntAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        txtNoteName = findViewById(R.id.note_name);
        txtNotecontent = findViewById(R.id.note_content);

        bntAdd = findViewById(R.id.addNote);

        bntAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });


    }


    void setData(){

        String name = txtNoteName.getEditText().getText().toString();
        String content = txtNotecontent.getEditText().getText().toString();

        Note n = new Note(UUID.randomUUID().toString(),name,"my tag",0,content);

        Intent i = getIntent();
        i.putExtra(NotesModel.Entry.TABLE_NAME,n);
        setResult(RESULT_OK,i);

        finish();


    }




}
