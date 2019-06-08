package com.example.serviceexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.text.Editable;

public class MyService extends Service {

    private static final String CHANEL_ID = "CHANEL_ID";
    private static final String NAME = "NAME";
    private static final int NOT_ID = 101;
    NotificationManager notificationManager;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        createMyNotificationChanel();
        sendNotification("asasd","hvh","hgvhvncgfc");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void sendNotification(String text1, String text2, String text3){
        Notification.Builder builder = new Notification.Builder(getApplicationContext(),CHANEL_ID)
                .setContentTitle(text1)
                .setContentText(text2)
                .setSmallIcon(R.drawable.ic_launcher_background);
        notificationManager.notify(NOT_ID,builder.build());

    }
    private void createMyNotificationChanel(){
        NotificationChannel channel = new NotificationChannel(CHANEL_ID,NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.setLightColor(Color.BLACK);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        notificationManager.createNotificationChannel(channel);
    }
}
