package com.example.quangnguyen.mynativeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.nio.file.Watchable;

public class MainActivity extends AppCompatActivity {
    Wrapper mWrapper = new Wrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtText = (TextView)findViewById(R.id.txtText);
        TextView txtInt = (TextView)findViewById(R.id.txtInt);
        TextView txtByte = (TextView)findViewById(R.id.txtByte);

        txtText.setText(mWrapper.getMessages());

        int [] IntArray = null;
        IntArray = mWrapper.createIntArray(20);
        txtInt.setText("" + IntArray[7]);

        byte [] ByteArray = null;
        ByteArray = mWrapper.createByteArray(20);
        txtByte.setText("" + ByteArray[15]);
    }
}
