package com.example.dmitriyl.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class AndroidStartServiceOnBoot extends Service
{
    public AndroidStartServiceOnBoot()
    {

    }

//    @Override
//    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
//        Intent dialogIntent = new Intent(this, MainActivity.class);
//        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(dialogIntent);
//    }

    @Override
    public void onCreate()
    {
        super.onCreate();
//        if(checkCallingOrSelfPermission(BootCompleted),)BootCompleted
        System.out.println("hello");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
