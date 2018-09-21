package com.example.luke.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.handler.LooperThread;

public class MainActivity extends AppCompatActivity {

    private LooperThread thread;
    private TextView textView;
    private TextView clickButton;
    private int count = 0;
    private static final int DELAY_TIME = 500;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.center_text);
        clickButton = findViewById(R.id.click_text_view);
        handler = new Handler();

        thread = new LooperThread(textView);
        thread.start();

        setClickEvent();
    }

    private void setClickEvent(){
        clickButton.setOnClickListener(new View.OnClickListener() {
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
    }

    private Runnable updateTimeTask = new Runnable() {
        @Override
        public void run() {
            textView.setText("Update Count " + count ++);
            handler.postDelayed(this, DELAY_TIME);
        }
    };
}
