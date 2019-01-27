package com.example.nvdq1.interfragmentcommunications;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SimpleFragment extends Fragment {
    private ActivityComs mActivityComs;
    Movie movie = new Movie();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

	/*
	activity is a ActivityComs but must
	still be explicitly cast to the type
	*/
        mActivityComs = (ActivityComs)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

	/*
	Set the reference to null.
	Now there is no active reference
	the garbage collector will clean it up
	*/
        mActivityComs = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        movie.setTitle("Sample Title");
        movie.setDescription("Sample description");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        Button btnSend = (Button)view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityComs.onListItemSelected(movie);
            }
        });

        return view;
    }
}
