package com.example.luke.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class StartedServiceA extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service OnCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Default Thread: Main Thread
        System.out.println("Service StartCommand");

        return super.onStartCommand(intent, flags, startId);
    }
}
