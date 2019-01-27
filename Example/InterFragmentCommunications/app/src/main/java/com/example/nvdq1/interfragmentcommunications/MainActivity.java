package com.example.nvdq1.interfragmentcommunications;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActivityComs{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a fragment manager
        FragmentManager fManager = getFragmentManager();

        // Create a new fragment using the manager
        // Passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.fragmentHolder); //find fragment that associated with holder, null if not
        // Check the fragment has not already been initialized
        if(frag == null){
            // Initialize the fragment based on our SimpleFragment
            frag = new SimpleFragment();
            fManager.beginTransaction()
                    .add(R.id.fragmentHolder, frag)
                    .commit();
        }
    }

    @Override
    public void onListItemSelected(Movie movie) {
        Log.i("debug", "data receive: " + movie.getTitle() + " " + movie.getDescription());
    }
}
