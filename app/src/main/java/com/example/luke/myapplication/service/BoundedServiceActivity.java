package com.example.luke.myapplication.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.luke.myapplication.IRemoteService;
import com.example.luke.myapplication.R;

public class BoundedServiceActivity extends AppCompatActivity {

    private TextView actionTextView;

    private IRemoteService remoteService;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            remoteService = IRemoteService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            remoteService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service);

        actionTextView = findViewById(R.id.action_button_text);

        Intent intent = new Intent(IRemoteService.class.getName());

        // 롤리팝 이후 패키지명을 명시해줘야한다.
        intent.setPackage("com.example.luke.myapplication.IRemoteService");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        setEvent();
    }

    private void setEvent() {
        actionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionRemoteService();
            }
        });
    }

    private void actionRemoteService(){
        if(remoteService != null){
            try {
                boolean valid = remoteService.validCalendar(10L, "test");
                System.out.println(valid);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
