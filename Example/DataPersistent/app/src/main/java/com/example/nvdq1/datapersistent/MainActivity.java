package com.example.nvdq1.datapersistent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtText1 = (TextView)findViewById(R.id.txtText1);
        final TextView txtText2 = (TextView)findViewById(R.id.txtText2);
        Button btnButton = (Button)findViewById(R.id.button);

        //First string represent for a bunk of data, Mode_Private means that any class, in this app only, can access it
        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mEditor = mPrefs.edit();

        String str = mPrefs.getString("saved_string", "default");
        txtText1.setText(str);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = txtText2.getText().toString();
                mEditor.putString("saved_string", temp);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save the settings here
        mEditor.commit();
    }
}
