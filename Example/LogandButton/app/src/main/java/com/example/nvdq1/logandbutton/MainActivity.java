package com.example.nvdq1.logandbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void topClick(View v){
        Toast.makeText(this, "Top button clicked", Toast.LENGTH_SHORT).show();
        Log.i("info", "The user clicked the top button");
    }

    public void bottomClick(View v){
        Toast.makeText(this, "Bottom button clicked", Toast.LENGTH_SHORT).show();
        Log.i("info", "The user clicked the bottom button");
    }
}
