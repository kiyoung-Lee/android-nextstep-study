package com.example.luke.myapplication.service;

import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.R;

public class StartedServiceActivity extends AppCompatActivity {

    private TextView startServiceButton;
    private TextView startCrashServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);

        startServiceButton = findViewById(R.id.service_start_text_view);
        startCrashServiceButton = findViewById(R.id.service_crash_text_view);

        Intent intent = new Intent(getApplicationContext(), StartedServiceA.class);
        startService(intent);

        setEvent();
    }

    private void setEvent() {
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ResultReceiverService.class);
                intent1.putExtra("Reciever", resultReceiver);
                startService(intent1);
                startService(intent1);
                startService(intent1);
            }
        });

        startCrashServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CrashServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    private Handler handler = new Handler();

    private ResultReceiver resultReceiver = new ResultReceiver(handler) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if(resultCode == 1){
                System.out.println("Recieve Success");
            }
        }
    };


}
