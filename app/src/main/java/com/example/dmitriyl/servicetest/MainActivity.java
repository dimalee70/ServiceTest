package com.example.dmitriyl.servicetest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dmitriyl.servicetest.receivers.BootReceiver;
import com.example.dmitriyl.servicetest.receivers.RepeatingReceiver;
import com.example.dmitriyl.servicetest.service.GPSService;

import java.util.List;

public class MainActivity extends Activity {
    private PendingIntent pendingIntent;
    private AlarmManager manager;

    Intent GPSServiceIntent;
    private GPSService gpsService;

    Context ctx;
    public Context getCtx() {
        return ctx;
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        System.out.println("on Destroy");
//        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(this,RepeatingReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
//        assert alarmManager != null;
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),60000,pendingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) this,   new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
//        IntentFilter intentFilter = new IntentFilter(
//                "android.intent.action.BOOT_COMPLETED");
//        BootReceiver bootReceiver = new BootReceiver();
//        this.registerReceiver(bootReceiver,intentFilter);
//        ctx = this;
//        setContentView(R.layout.activity_main);
//
//        gpsService = new GPSService(getCtx());
//
//        GPSServiceIntent = new Intent(getCtx(),gpsService.getClass());
        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,RepeatingReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        assert alarmManager != null;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),100,pendingIntent);




//        ComponentName componentName = new ComponentName(this,MyJobService.class);
//        JobInfo jobInfo = new JobInfo.Builder(12,componentName)
//                .setRequiresCharging(true)
//                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
//                .setPeriodic(10)
//                .build();
//
//        JobScheduler jobScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
//        int resultCode = jobScheduler.schedule(jobInfo);
//        if(resultCode == JobScheduler.RESULT_SUCCESS)
//            System.out.println("Job sheduled");
//        else
//            {
//                System.out.println("Job is not shedulled");
//            }
////
//        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(this,BootCompleted.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
//        assert alarmManager != null;
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),60000,pendingIntent);
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
