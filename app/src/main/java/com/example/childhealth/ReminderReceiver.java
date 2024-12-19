package com.example.childhealth;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

public class ReminderReceiver extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 123;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Display the notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context, "channel_id")
                .setContentTitle("Reminder")
                .setContentText("It's time for your reminder!")
                .setSmallIcon(R.drawable.ic_notification)
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}

