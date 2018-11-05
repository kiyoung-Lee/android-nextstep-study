package com.example.luke.myapplication.activity_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.R;

public class ActivityA extends AppCompatActivity {

    private TextView startActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // Activity A -> Activity B -> ActivityC
        // Activity A에서 Activity C의 결과를 받고싶음
        // Activity B는 바로 종료되며 결과값은 ActivityC 에서 셋팅한다

        startActivity = findViewById(R.id.start_activity_text_view);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), ActivityB.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("result code : " + resultCode);
        System.out.println("request code: " + requestCode);
        System.out.println(data.getStringExtra("value"));
    }
}
