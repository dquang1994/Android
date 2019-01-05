package com.example.nvdq1.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Here we need an Intent also
        // But the default constructor will do
        // as we are not switching Activity
        Intent myIntent = getIntent();

        // Initialize username with the passed in String
        String Data = myIntent.getStringExtra("DATA");

        TextView txtData = (TextView)findViewById(R.id.txtText2);
        txtData.setText(Data);

        Button btnSwitchToActivity1 = (Button)findViewById(R.id.btnSwitchToActivity1);
        btnSwitchToActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Declare and initialize a new Intent object called myIntent
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);

                // Switch to the SettingsActivity
                startActivity(myIntent);
            }
        });
    }
}
