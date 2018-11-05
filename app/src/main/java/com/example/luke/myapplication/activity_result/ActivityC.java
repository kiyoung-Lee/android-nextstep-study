package com.example.luke.myapplication.activity_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luke.myapplication.R;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Intent intent = new Intent();
        intent.putExtra("value", "Android");
        setResult(1, intent);

        finish();
    }
}
