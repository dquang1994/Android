package com.example.nvdq1.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DataManager mDataManager;

    EditText txtName;
    EditText txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataManager = new DataManager(this);

        txtName = (EditText)findViewById(R.id.txtName);
        txtAge = (EditText)findViewById(R.id.txtAge);

        Button btnInsert = (Button)findViewById(R.id.btnInsert);
        Button btnDelete = (Button)findViewById(R.id.btnDelete);
        Button btnSelectall = (Button)findViewById(R.id.btnSelectall);
        Button btnSearch = (Button)findViewById(R.id.btnSearch);

        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSelectall.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsert:
                mDataManager.insert(txtName.getText().toString(), txtAge.getText().toString());
                break;
            case R.id.btnDelete:
                mDataManager.delete(txtName.getText().toString());
                break;
            case R.id.btnSelectall:
                showData(mDataManager.selectAll());
                break;
            case R.id.btnSearch:
                showData(mDataManager.searchName(txtName.getText().toString()));
                break;

        }
    }

    public void showData(Cursor c){
        while (c.moveToNext()){
            Log.i(c.getString(1), c.getString(2));
        }
    }
}
