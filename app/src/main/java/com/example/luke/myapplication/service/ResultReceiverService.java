package com.example.luke.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;

public class ResultReceiverService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final ResultReceiver receiver = intent.getParcelableExtra("Reciever");
                receiver.send(1, null);
                stopSelf();
            }
        }).start();

        return START_NOT_STICKY;
    }
}
