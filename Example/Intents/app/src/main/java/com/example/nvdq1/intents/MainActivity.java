package com.example.nvdq1.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSwitchToActivity2 = (Button) findViewById(R.id.btnSwitchToActivity2);
        btnSwitchToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Declare and initialize a new Intent object called myIntent
                Intent myIntent = new Intent(getApplicationContext(), Main2Activity.class);

                String str = "Data from Activity 1";
                myIntent.putExtra("DATA", str);

                // Switch to the SettingsActivity
                startActivity(myIntent);
            }
        });
    }
}
