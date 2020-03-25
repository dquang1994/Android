package com.example.nvdq1.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSwitchToActivity2 = findViewById(R.id.btnSwitchToActivity2);
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

        final EditText editText = findViewById(R.id.editText);
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}
