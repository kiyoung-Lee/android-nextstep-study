package com.example.luke.myapplication.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luke.myapplication.R;

public class HandlerThreadActivity extends AppCompatActivity {

    private Boolean startFlag = false;
    private Handler handler;
    private HandlerThread handlerThread;

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        startButton = findViewById(R.id.start_button);

        // 백그라운드에서 순차처리 하기에 좋다.
        handlerThread = new HandlerThread("Test");
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                if(startFlag){
                    System.out.println("StartFlage : True");
                }else {
                    System.out.println("StartFlage : False");
                }

                startFlag = !startFlag;
            }
        };

        setEvent();
    }

    private void setEvent() {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendMessageDelayed(new Message(), 500);
            }
        });
    }
}
