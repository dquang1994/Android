package com.example.nvdq1.listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SampleListFragment extends ListFragment {
    private ArrayList<Note> mNotes = new ArrayList<Note>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Note note1 = new Note();
        Note note2 = new Note();
        Note note3 = new Note();

        note1.setTitle("Note 1");
        note1.setDescriotion("Description 1");
        note2.setTitle("Note 2");
        note2.setDescriotion("Description 2");
        note3.setTitle("Note 3");
        note3.setDescriotion("Description 3");

        mNotes.add(note1);
        mNotes.add(note2);
        mNotes.add(note3);

        AddressListAdapter adapter = new AddressListAdapter(mNotes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("debug", "Item at position " + position + " is clicked");
    }

    private class AddressListAdapter extends ArrayAdapter<Note>
    {
        /*
        This simple constructor lets the ArrayAdapter
        super class
        know what data to use. Notice we didn't need to bind
        the data in onCreate.
        Neither do we need to override getCount,
        getItem or getItemId
        It is all handled by ArrayAdapter because it is a more
        specialized version of Base Adapter
        */
        public AddressListAdapter(ArrayList<Note> notes) {
            super(getActivity(), R.layout.list_item, notes);
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
                view = inflater.inflate(R.layout.list_item, null);

                TextView txtTitle = view.findViewById(R.id.txtTitle);
                txtTitle.setText(mNotes.get(whichItem).getTitle());

                TextView txtDescription = view.findViewById(R.id.txtDescription);
                txtDescription.setText(mNotes.get(whichItem).getDescriotion());
            }

            return view;
        }
    }
}
