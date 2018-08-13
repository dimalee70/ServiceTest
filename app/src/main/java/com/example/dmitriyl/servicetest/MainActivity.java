package com.example.dmitriyl.servicetest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    private PendingIntent pendingIntent;
    private AlarmManager manager;

    @SuppressLint("ShortAlarm")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,BootCompleted.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        assert alarmManager != null;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),10,pendingIntent);
//
//
//
//       ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//        List<ActivityManager.RunningServiceInfo> rs = activityManager.getRunningServices(50);
//
//        for (int i = 0; i < rs.size(); i++) {
//            ActivityManager.RunningServiceInfo rsi = rs.get(i);
//            System.out.println("Service" + "," + "Process " + rsi.process + " with component "
//                    + rsi.service.getClassName());
//        }




//        Intent intent = new Intent(this,AndroidStartServiceOnBoot.class);
//        startService(intent);
//        this.sendBroadcast(intent);

        //true

//        BootCompleted bootCompleted = new BootCompleted();
//        Intent intent = new Intent(this,AndroidStartServiceOnBoot.class);
//        bootCompleted.onReceive(this,intent);

//        ComponentName componentName =  new ComponentName(this, BootCompleted.class);
//        PackageManager packageManager = getPackageManager();
//        packageManager.setComponentEnabledSetting(componentName,
//                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                PackageManager.DONT_KILL_APP);
//        BootCompleted bootCompleted = new BootCompleted();
//        Intent serviceIntent = new Intent(this,AndroidStartServiceOnBoot.class);
//        startService(serviceIntent);
    }
//
}
