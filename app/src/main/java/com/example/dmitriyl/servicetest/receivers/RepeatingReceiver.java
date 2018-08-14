package com.example.dmitriyl.servicetest.receivers;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.dmitriyl.servicetest.MainActivity;
import com.example.dmitriyl.servicetest.R;
import com.example.dmitriyl.servicetest.service.GPSService;
import com.example.dmitriyl.servicetest.storage.PersistantStorage;

public class RepeatingReceiver extends BroadcastReceiver
{

    NotificationManager nm;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        System.out.println("hello from receiver ");
        PersistantStorage.init(context);
        Intent serviceIntent = new Intent(context,GPSService.class);
        context.startService(serviceIntent);
        String longitude = PersistantStorage.getProperty("longitude");
        String latitude = PersistantStorage.getProperty("latitude");
        if((longitude != null) && !(longitude.equals("") &&
            latitude != null) && !(latitude.equals("")))
        {
            sendNotification(context,longitude,latitude);
            PersistantStorage.clear();
        }
//        AlarmManager alarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent myIntent = new Intent(context,BootReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,myIntent,0);
//        assert alarmManager != null;
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),100,pendingIntent);
    }
    protected void sendNotification(Context mContext,String Longitude, String Latitude) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mContext.getApplicationContext(), "notify_001");
        Intent ii = new Intent(mContext.getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, ii, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle("Your location");
        bigText.setSummaryText("You");

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle("Your location");
        mBuilder.setContentText("Longitude " + Longitude+"\nLatitude " + Latitude);
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);

        NotificationManager mNotificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notify_001",
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }

        mNotificationManager.notify(0, mBuilder.build());


    }
}
