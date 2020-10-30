package com.ironlabs.todo.Data.Adapter.Notes;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ironlabs.todo.R;
import com.ironlabs.todo.Data.Model.Notes.NotesModel;
import com.ironlabs.todo.Data.Entity.Notes.Note;

public class NotesAdapter extends CursorNotesAdapter<NotesAdapter.NotesViewHolder> {

    private OnNoteClickListener listener;

    public NotesAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note,viewGroup,false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder viewHolder, Cursor cursor) {
        viewHolder.bind(NotesModel.noteFromCursor(cursor));
    }

    public void setListener(OnNoteClickListener listener){
        this.listener = listener;
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private TextView txtPrev;
        private TextView txtTag;
        private TextView txtDate;
        private Note note;

        private View view;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            txtName = view.findViewById(R.id.txt_note_name);
            txtPrev = view.findViewById(R.id.note_prev);
            txtTag = view.findViewById(R.id.txt_note_tag);
            txtDate = view.findViewById(R.id.txt_note_date);

        }

        void bind(final Note n){
            note = n;
            txtName.setText(n.getName());
            txtPrev.setText(n.getContent());
            txtTag.setText(n.getTag());
            txtDate.setText(n.getDateCreated());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onNoteClicked(n);
                    }
                }
            });


        }

    }

    public interface OnNoteClickListener{
        void onNoteClicked(Note note);
    }

}
