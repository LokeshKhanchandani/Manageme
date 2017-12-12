package com.android.manageme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity4 extends AppCompatActivity {
Button bt;
    String p,q,s;
int i=0,t;
    int[] subId={R.id.s1,R.id.s2,R.id.s3,R.id.s4,R.id.s5,R.id.s6,R.id.s7,R.id.s8};
    int[] classId={R.id.c1,R.id.c2,R.id.c3,R.id.c4,R.id.c5,R.id.c6,R.id.c7,R.id.c8};
    int[] time={8,9,10,11,12,2,3,4,5};
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setTitle("FILL TIME TABLE");
        getSupportActionBar().setElevation(8);
        p=getIntent().getExtras().getString("day");
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   if (p.equals("monday")) {
                       // SAVES TIME-TABLE FIRST TIME IN DATABASE
                   for (i = 0; i < 8; i++) {

                            e1 = (EditText) findViewById(subId[i]);
                            e2 = (EditText) findViewById(classId[i]);

                            ContentValues contentValues = new ContentValues();
                            contentValues.put(CProvider.TIME, time[i]);
                            contentValues.put(CProvider.NAME, e1.getText().toString());
                            contentValues.put(CProvider.GRADE, e2.getText().toString());
                            getContentResolver().insert(CProvider.CONTENT_URI, contentValues);
                        }
                       // FOR GETTING NOTIFICATION 15 MINUTES BEFORE CLASS
                       Cursor result = getContentResolver().query(CProvider.CONTENT_URI, null, null, null, null);
                       if (result != null) {
                           if (result.getCount() != 0) {
                               if (result.moveToFirst()) {
                                   do {
                                       if (result.getString(result.getColumnIndex(CProvider.NAME)).contentEquals("")) { // continue;
                                           t = result.getInt(result.getColumnIndex(CProvider.TIME));
                                           if (t >= 1 && t <= 4)
                                               t += 12;
                                           break;
                                       }
                                   } while (result.moveToNext());
                                   Calendar calender = Calendar.getInstance();
                                   calender.setTime(new Date());
                                   Calendar s = Calendar.getInstance() ;
                                   s.set(Calendar.DAY_OF_WEEK, 2);
                                   s.set(Calendar.HOUR_OF_DAY, t-1);
                                   s.set(Calendar.MINUTE, 45);
                                   s.set(Calendar.SECOND, 0);

                                   int time = (int) Math.abs(s.getTimeInMillis() - calender.getTimeInMillis());
                                   Intent inte = new Intent(MainActivity4.this, Notification_receiver.class);
                                   inte.putExtra("x", "monday");
                                   PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, inte, 0);
                                   AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis()+time,7*24*60*60*1000, pendingIntent);
                                   }
                           }
                       }
                       finish();
                }

                  else if (p.equals("tuesday")) {
                    for (i = 0; i < 8; i++) {

                        e1 = (EditText) findViewById(subId[i]);
                        e2 = (EditText) findViewById(classId[i]);

                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CProvider2.TIME, time[i]);
                        contentValues.put(CProvider2.NAME, e1.getText().toString());
                        contentValues.put(CProvider2.GRADE, e2.getText().toString());
                        getContentResolver().insert(CProvider2.CONTENT_URI, contentValues);

                    }

                       Cursor result = getContentResolver().query(CProvider2.CONTENT_URI, null, null, null, null);
                       if (result != null) {
                           if (result.getCount() != 0) {
                               if (result.moveToFirst()) {
                                   do {
                                       if (result.getString(result.getColumnIndex(CProvider2.NAME)).contentEquals("")) { // continue;
                                           t = result.getInt(result.getColumnIndex(CProvider2.TIME));
                                           if (t >= 1 && t <= 4)
                                               t += 12;
                                           break;
                                       }
                                   } while (result.moveToNext());
                                   Calendar calender = Calendar.getInstance();
                                   calender.setTime(new Date());
                                   Calendar s = Calendar.getInstance() ;
                                   s.set(Calendar.DAY_OF_WEEK, 3);
                                   s.set(Calendar.HOUR_OF_DAY, t-1);
                                   s.set(Calendar.MINUTE, 45);
                                   s.set(Calendar.SECOND, 0);

                                   int time = (int) Math.abs(s.getTimeInMillis() - calender.getTimeInMillis());
                                   Intent inte = new Intent(MainActivity4.this, Notification_receiver.class);
                                   inte.putExtra("x", "tuesday");
                                   PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 2, inte, 0);
                                   AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis()+time,7*24*60*60*1000, pendingIntent);
                                   }
                           }
                       }
                    finish();
                }
                   else if (p.equals("wednesday")) {
                       for (i = 0; i < 8; i++) {

                           e1 = (EditText) findViewById(subId[i]);
                           e2 = (EditText) findViewById(classId[i]);

                           ContentValues contentValues = new ContentValues();
                           contentValues.put(CProvider3.TIME, time[i]);
                           contentValues.put(CProvider3.NAME, e1.getText().toString());
                           contentValues.put(CProvider3.GRADE, e2.getText().toString());
                           getContentResolver().insert(CProvider3.CONTENT_URI, contentValues);

                       }

                       Cursor result = getContentResolver().query(CProvider3.CONTENT_URI, null, null, null, null);
                       if (result != null) {
                           if (result.getCount() != 0) {
                               if (result.moveToFirst()) {
                                   do {
                                       if (result.getString(result.getColumnIndex(CProvider3.NAME)).contentEquals("")) { // continue;
                                           t = result.getInt(result.getColumnIndex(CProvider3.TIME));
                                           if (t >= 1 && t <= 4)
                                               t += 12;
                                           break;
                                       }
                                   } while (result.moveToNext());
                                   Calendar calender = Calendar.getInstance();
                                   calender.setTime(new Date());
                                   Calendar s = Calendar.getInstance() ;
                                   s.set(Calendar.DAY_OF_WEEK, 4);
                                   s.set(Calendar.HOUR_OF_DAY, t-1);
                                   s.set(Calendar.MINUTE, 45);
                                   s.set(Calendar.SECOND, 0);

                                   int time = (int) Math.abs(s.getTimeInMillis() - calender.getTimeInMillis());
                                   Intent inte = new Intent(MainActivity4.this, Notification_receiver.class);
                                   inte.putExtra("x", "wednesday");
                                   PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 3, inte, 0);
                                   AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis()+time,7*24*60*60*1000, pendingIntent);
                                   }
                           }
                       }
                       finish();
                   }
                   else if (p.equals("thursday")) {
                       for (i = 0; i < 8; i++) {

                           e1 = (EditText) findViewById(subId[i]);
                           e2 = (EditText) findViewById(classId[i]);

                           ContentValues contentValues = new ContentValues();
                           contentValues.put(CProvider4.TIME, time[i]);
                           contentValues.put(CProvider4.NAME, e1.getText().toString());
                           contentValues.put(CProvider4.GRADE, e2.getText().toString());
                           getContentResolver().insert(CProvider4.CONTENT_URI, contentValues);

                       }

                       Cursor result = getContentResolver().query(CProvider4.CONTENT_URI, null, null, null, null);
                       if (result != null) {
                           if (result.getCount() != 0) {
                               if (result.moveToFirst()) {
                                   do {
                                       if (result.getString(result.getColumnIndex(CProvider4.NAME)).contentEquals("")) { // continue;
                                           t = result.getInt(result.getColumnIndex(CProvider4.TIME));
                                           if (t >= 1 && t <= 4)
                                               t += 12;
                                           break;
                                       }
                                   } while (result.moveToNext());
                                   Calendar calender = Calendar.getInstance();
                                   calender.setTime(new Date());
                                   Calendar s = Calendar.getInstance() ;
                                   s.set(Calendar.DAY_OF_WEEK, 5);
                                   s.set(Calendar.HOUR_OF_DAY, t-1);
                                   s.set(Calendar.MINUTE, 45);
                                   s.set(Calendar.SECOND, 0);

                                   int time = (int) Math.abs(s.getTimeInMillis() - calender.getTimeInMillis());
                                   Intent inte = new Intent(MainActivity4.this, Notification_receiver.class);
                                   inte.putExtra("x", "thursday");
                                   PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 4, inte, 0);
                                   AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis()+time,7*24*60*60*1000, pendingIntent);
                                   }
                           }
                       }
                       finish();
                   }
                   else if (p.equals("friday")) {
                       for (i = 0; i < 8; i++) {

                           e1 = (EditText) findViewById(subId[i]);
                           e2 = (EditText) findViewById(classId[i]);

                           ContentValues contentValues = new ContentValues();
                           contentValues.put(CProvider5.TIME, time[i]);
                           contentValues.put(CProvider5.NAME, e1.getText().toString());
                           contentValues.put(CProvider5.GRADE, e2.getText().toString());
                           getContentResolver().insert(CProvider5.CONTENT_URI, contentValues);
                       }

                       Cursor result = getContentResolver().query(CProvider5.CONTENT_URI, null, null, null, null);
                       if (result != null) {
                           if (result.getCount() != 0) {
                               if (result.moveToFirst()) {
                                   do {
                                         if (result.getString(result.getColumnIndex(CProvider5.NAME)).contentEquals("")) {
                                           t = result.getInt(result.getColumnIndex(CProvider5.TIME));
                                           if (t >= 1 && t <= 4)
                                               t += 12;
                                           break;
                                       }
                                   } while (result.moveToNext());
                                   Calendar calender = Calendar.getInstance();
                                   calender.setTime(new Date());
                                   Calendar s = Calendar.getInstance() ;
                                   s.set(Calendar.DAY_OF_WEEK, 6);
                                   s.set(Calendar.HOUR_OF_DAY, t-1);
                                   s.set(Calendar.MINUTE, 45);
                                   s.set(Calendar.SECOND, 0);

                                   int time = (int) Math.abs(s.getTimeInMillis() - calender.getTimeInMillis());
                                   Intent inte = new Intent(MainActivity4.this, Notification_receiver.class);
                                   inte.putExtra("x", "friday");
                                   PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 5, inte, 0);
                                   AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis()+time,7*24*60*60*1000, pendingIntent);
                                   }
                           }
                       }
                       finish();
                   }
            }
        });
    }
}