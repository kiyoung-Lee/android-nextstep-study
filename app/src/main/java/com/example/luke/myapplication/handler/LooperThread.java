package com.example.luke.myapplication.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;


public class LooperThread extends Thread {

    private TextView textView;
    public Handler handler;

    public LooperThread(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void run() {
        Looper.prepare();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                System.out.println("Looper Test");
            }
        };

        handler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Handler Post");
//                textView.setText("Other Thread Set Text");      // throw Exception
            }
        });

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                textView.setText("Other Thread Set Text");
            }
        });

        handler.sendMessage(new Message());

        Looper.loop();
    }
}
