package com.example.dmitriyl.servicetest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;

import android.support.v4.app.ActivityCompat;
import android.os.Bundle;

import com.example.dmitriyl.servicetest.receivers.RepeatingReceiver;
import com.example.dmitriyl.servicetest.receivers.disablestop.AdminDeviceReceiver;
import com.example.dmitriyl.servicetest.receivers.disablestop.PolicyManager;
import com.example.dmitriyl.servicetest.service.GPSService;

import java.util.List;

public class MainActivity extends Activity
{
    private PolicyManager policyManager;
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
        policyManager = new PolicyManager(this);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) this,   new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
//        System.out.println("here");
//        if (!policyManager.isAdminActive()) {
//            Intent activateDeviceAdmin = new Intent(
//                    DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
//            activateDeviceAdmin.putExtra(
//                    DevicePolicyManager.EXTRA_DEVICE_ADMIN,
//                    policyManager.getAdminComponent());
//            activateDeviceAdmin
//                    .putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
//                            "After activating admin, you will be able to block application uninstallation.");
//            startActivityForResult(activateDeviceAdmin,
//                    PolicyManager.DPM_ACTIVATION_REQUEST_CODE);
//            policyManager.enableAdmin();
//        }

        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,RepeatingReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        assert alarmManager != null;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),100,pendingIntent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (resultCode == Activity.RESULT_OK
                && requestCode == PolicyManager.DPM_ACTIVATION_REQUEST_CODE) {
            // handle code for successfull enable of admin
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
