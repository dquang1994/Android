package com.example.nvdq1.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SampleAdapter mSampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSampleAdapter = new SampleAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mSampleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int whichItem, long id) {
                Toast.makeText(getApplicationContext(), "item " + whichItem + " clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setLongClickable(true);

        // Now to detect long clicks and delete the note
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int whichItem, long id) {
                Toast.makeText(getApplicationContext(), "Long clicked on item " + whichItem + " !", Toast.LENGTH_SHORT).show();
                mSampleAdapter.deleteNote(whichItem);

                return true;
            }
        });

        Button btnButton = findViewById(R.id.btnAddItem);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note newNote = new Note();
                newNote.setTitle("Title");
                newNote.setDescription("Description");

                mSampleAdapter.addNote(newNote);
            }
        });
    }

    public class SampleAdapter extends BaseAdapter {
        List<Note> noteList = new ArrayList<Note>();

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
            }

            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);

            Note tempNote = noteList.get(whichItem);

            txtTitle.setText(tempNote.getTitle());
            txtDescription.setText(tempNote.getDescription());

            return view;
        }

        public void addNote(Note n){
            noteList.add(n);
            notifyDataSetChanged(); //when this method is called, getView will be recalled to refresh the UI for list view
        }

        public void deleteNote(int n){
            noteList.remove(n);
            notifyDataSetChanged();
        }
    }
}
