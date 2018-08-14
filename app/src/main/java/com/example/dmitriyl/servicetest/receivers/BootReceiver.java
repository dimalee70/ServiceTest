package com.example.dmitriyl.servicetest.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        System.out.println("hello from boot receiver");
//        Intent serviceIntent = new Intent(context,GPSService.class);
//        context.startService(serviceIntent);
        AlarmManager alarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context,RepeatingReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,myIntent,0);
        assert alarmManager != null;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),100,pendingIntent);
//        RepeatingReceiver repeatingReceiver = new RepeatingReceiver();

//
//        context.sendBroadcast(new Intent("com.ActivityRecognition.RepeatReceiver"));
    }
}
