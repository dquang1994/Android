package com.example.nvdq1.logandbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnButton1 = findViewById(R.id.btnButton1);
        btnButton1.setOnClickListener(this);
    }

    public void topClick(View v){
        Toast.makeText(this, "Top button clicked", Toast.LENGTH_SHORT).show();
        Log.i("info", "The user clicked the top button");
    }

    public void bottomClick(View v){
        Toast.makeText(this, "Bottom button clicked", Toast.LENGTH_SHORT).show();
        Log.i("info", "The user clicked the bottom button");
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
    }
}
