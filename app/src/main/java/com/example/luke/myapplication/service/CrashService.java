package com.example.luke.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class CrashService extends Service {
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
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("I am Crash Service!!!");
        System.out.println("I am Crash Service!!!");
        System.out.println("I am Crash Service!!!");

        return START_STICKY;
    }
}
