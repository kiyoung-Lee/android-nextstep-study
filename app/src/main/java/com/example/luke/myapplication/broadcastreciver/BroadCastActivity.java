package com.example.luke.myapplication.broadcastreciver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.R;

public class BroadCastActivity extends AppCompatActivity {

    TextView staticBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        staticBroadCast = findViewById(R.id.static_broadcast_text_view);

        setEvent();

        SampleBroadcastReciver reciver = new SampleBroadcastReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("test");
        registerReceiver(reciver, intentFilter);
    }

    private void setEvent() {
        staticBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendBroadcast(new Intent("test"));
//
//                Intent intent = new Intent();
//                intent.setAction("test");
//                sendBroadcast(intent);

                sendBroadcast(new Intent("action.test"), "test.permission");

            }
        });
    }


}
