package com.example.nvdq1.json;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoteAdapter = new NoteAdapter();

        ListView listNote = (ListView) findViewById(R.id.listView);
        listNote.setAdapter(mNoteAdapter);

        Button btnAddNote = (Button)findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note.setTitle("Title");
                note.setDescription("Description");
                mNoteAdapter.addNote(note);
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        mNoteAdapter.saveNotes();
    }

    public class NoteAdapter extends BaseAdapter {
        private JSONSerializer mSerializer;
        List<Note> noteList = new ArrayList<Note>();

        public NoteAdapter(){
            mSerializer = new JSONSerializer("Note.json", MainActivity.this.getApplicationContext());
            try {
                noteList = mSerializer.load();
            } catch (Exception e) {
                noteList = new ArrayList<Note>();
                Log.e("Error loading notes: ", "", e);
            }
        }

        @Override
        public int getCount() {
            return noteList.size();
        }

        @Override
        public Note getItem(int whichItem) {
            return noteList.get(whichItem);
        }

        @Override
        public long getItemId(int whichItem) {
            return whichItem;
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup)
        {
            if(view == null){
                // If not, do so here
                // First create a LayoutInflater
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                // Now instantiate view using inflater.inflate
                // using the listitem layout
                view = inflater.inflate(R.layout.listitem, viewGroup,false);
                // The false parameter is neccessary
                // because of the way that we want to use listitem

                TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
                TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            }

            return view;
        }

        public void addNote(Note n){
            noteList.add(n);
            notifyDataSetChanged(); //when this method is called, getView will be recalled to refresh the UI for list view
        }

        public void saveNotes(){
            try{
                mSerializer.save(noteList);
            }catch(Exception e){
                Log.e("Error Saving Notes","", e);
            }
        }
    }
}
