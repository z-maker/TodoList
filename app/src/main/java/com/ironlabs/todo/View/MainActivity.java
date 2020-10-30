package com.ironlabs.todo.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ironlabs.todo.Data.Contract.Notes.NotesContract;
import com.ironlabs.todo.Data.Adapter.Notes.NotesAdapter;
import com.ironlabs.todo.Data.Entity.Notes.Note;
import com.ironlabs.todo.Data.Model.Notes.NotesModel;
import com.ironlabs.todo.Data.Presenter.Notes.NotePresenter;
import com.ironlabs.todo.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements NotesContract.View, NotesAdapter.OnNoteClickListener {


    public static final int NOTE_RESULT = 0;
    private Context context;

    private NotesContract.Presenter presenter;

    private RecyclerView recyclerNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context = this;

        presenter = new NotePresenter(this,this);

        recyclerNotes = findViewById(R.id.notes_recycler);

        recyclerNotes.setAdapter(presenter.getNotes());

        presenter.getNotes().setListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                startActivityForResult(new Intent(context,NoteActivity.class),NOTE_RESULT);

            }
        });

    }

    @Override
    public void onNoteClicked(Note note) {
        presenter.deleteNote(note.getId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){

            Note note = (Note) data.getSerializableExtra(NotesModel.Entry.TABLE_NAME);
            presenter.addNote(note);

        }

    }

    @Override
    public void updateNotes(NotesAdapter adapter) {
        adapter.setListener(this);
        recyclerNotes.setAdapter(adapter);

    }
}
