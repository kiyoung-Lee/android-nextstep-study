package com.example.luke.myapplication.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.R;

public class CrashServiceActivity extends AppCompatActivity {


    private TextView crashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_service);

        Intent intent = new Intent(this, CrashService.class);
        startService(intent);

        crashButton = findViewById(R.id.crash_text_view);
        setEvnet();
    }

    private void setEvnet(){
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 2/0;
            }
        });
    }
}
