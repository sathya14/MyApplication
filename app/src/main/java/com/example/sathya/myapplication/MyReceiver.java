package com.example.sathya.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "MyReceiver");
        Intent serviceIntent = new Intent(context, service.class);
        context.startService(serviceIntent);
    }
}
