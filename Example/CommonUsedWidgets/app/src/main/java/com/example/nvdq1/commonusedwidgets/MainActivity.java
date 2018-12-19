package com.example.nvdq1.commonusedwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        Toast.makeText(getApplicationContext(), "radio button 1 is chosen", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(getApplicationContext(), "radio button 2 is chosen", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        Switch switch1 = (Switch) findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "switch is on", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "switch is off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "check box is checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "check box is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final WebView webView = (WebView) findViewById(R.id.WebView);

        webView.loadUrl("http://www.cs.yale.edu/homes/tap/Files/hopper-story.html");
    }
}
