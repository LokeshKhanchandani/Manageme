package com.android.manageme;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class Notification_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeating_intent=new Intent(context,Notification.class);

        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String s=intent.getExtras().getString("x");
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
        repeating_intent.putExtra("p",s );
        PendingIntent pendingIntent=PendingIntent.getActivity(context,1,repeating_intent,0);
        NotificationCompat.Builder builder= (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle("Class After 15 minutes")
                .setContentText("Tap to see details")
                .setWhen(System.currentTimeMillis())
                .setShowWhen(true)
                .setSmallIcon(R.drawable.xxx);
        nm.notify(1,builder.build());
    }
}