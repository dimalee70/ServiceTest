package com.example.dmitriyl.servicetest;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import static android.content.Context.LOCATION_SERVICE;

public class BootCompleted extends BroadcastReceiver
{
    Location location;

    LocationManager locationManager;
    @Override
    public void onReceive(Context context, Intent intent)
    {
//        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED))
//        {
            Intent serviceIntent = new Intent(context,AndroidStartServiceOnBoot.class);
            context.startService(serviceIntent);
//            locationManager = (LocationManager)context.getSystemService(LOCATION_SERVICE);
//            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                System.out.println("inside check permission");
//                ActivityCompat.requestPermissions((Activity) context,   new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
//            }
//            System.out.println(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude());
//        }
    }

//    public Location getLocation(Context context) {
//        try {
//            System.out.println("Start get loc");
//            locationManager = (LocationManager)context.getSystemService(LOCATION_SERVICE);
//            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                System.out.println("inside check permission");
//                ActivityCompat.requestPermissions((Activity) context,   new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
//            }
//            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            System.out.println(location.getLatitude());
////                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
////            System.out.println("Latitude " +locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude());
////            System.out.println("Longitude " + locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude());
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return location;
//    }
}
