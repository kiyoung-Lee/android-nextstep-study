package com.example.luke.myapplication.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luke.myapplication.R;

public class DataBaseActivity extends AppCompatActivity {

    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        dbHelper = new DataBaseHelper(this);
    }
}
