package com.example.sathya.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class service extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "Service created.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "Service started.");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("TAG", "Service started.");
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}