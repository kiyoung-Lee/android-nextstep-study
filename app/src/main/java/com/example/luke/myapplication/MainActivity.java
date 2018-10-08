package com.example.luke.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.asynctask.AsyncTaskActivity;
import com.example.luke.myapplication.handler.LooperThread;
import com.example.luke.myapplication.handlerthread.HandlerThreadActivity;

public class MainActivity extends AppCompatActivity {

    private LooperThread thread;
    private TextView textView;
    private TextView handlerButton;
    private TextView moveHandlerTheradActivityButton;
    private TextView asyncTaskButton;

    private int count = 0;
    private static final int DELAY_TIME = 500;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.center_text);
        handlerButton = findViewById(R.id.click_text_view);
        moveHandlerTheradActivityButton = findViewById(R.id.handler_thread_activity_text_view);
        asyncTaskButton = findViewById(R.id.async_task_text_view);
        handler = new Handler();

        thread = new LooperThread(textView);
        thread.start();

        setClickEvent();
    }

    private void setClickEvent(){
        handlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Handler().post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("I am from World");
//                    }
//                });

                handler.post(updateTimeTask);
            }
        });

        moveHandlerTheradActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HandlerThreadActivity.class);
                startActivity(intent);
            }
        });

        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AsyncTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    private Runnable updateTimeTask = new Runnable() {
        @Override
        public void run() {
            textView.setText("Update Count " + count ++);
            handler.postDelayed(this, DELAY_TIME);
        }
    };
}
