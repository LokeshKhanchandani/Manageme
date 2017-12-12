package com.android.manageme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity5 extends AppCompatActivity {

    ListView listView;
    String subject[]={"","","","","","","",""};
    String classes[]={"","","","","","","",""};
    int time[]={0,0,0,0,0,0,0,0};
    String str,p,q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
             p = getIntent().getExtras().getString("day");

        if (p.contentEquals("monday")) {
            // DISPLAYING TIME-TABLE BY FETCHING DATA FROM RESPECTIVE DATABASES
                 Cursor resultSet = getContentResolver().query(CProvider.CONTENT_URI, null, null, null, null);
                 int index = 0;
                 getSupportActionBar().setTitle("MONDAY");
                 if (resultSet != null) {
                     if (resultSet.getCount() != 0) {
                         if (resultSet.moveToFirst()) {
                             do {
                                 subject[index] = resultSet.getString(resultSet.getColumnIndex(CProvider.NAME));
                                 if (subject[index].equalsIgnoreCase(""))
                                     subject[index] = "FREE";

                                 classes[index] = resultSet.getString(resultSet.getColumnIndex(CProvider.GRADE));
                                 time[index] = resultSet.getInt(resultSet.getColumnIndex(CProvider.TIME));
                                 index++;
                             } while (resultSet.moveToNext());
                         }
                     }
                 }
             }

         else if (p.equals("tuesday"))
        {
            Cursor resultSet = getContentResolver().query(CProvider2.CONTENT_URI,null,null,null,null) ;
            int index=0;
            getSupportActionBar().setTitle("TUESDAY");
            if (resultSet!=null) {
                if (resultSet.getCount() != 0) {
                    if (resultSet.moveToFirst()) {
                        do {
                            subject[index]=resultSet.getString(resultSet.getColumnIndex(CProvider2.NAME));

                        if(subject[index].equalsIgnoreCase(""))
                            subject[index]="FREE";


                           classes[index]=resultSet.getString(resultSet.getColumnIndex(CProvider2.GRADE));
                            time[index]=resultSet.getInt(resultSet.getColumnIndex(CProvider2.TIME));
                            index++;
                        } while (resultSet.moveToNext());
                    }
                }
            }
        }
             else if (p.equals("wednesday"))
             {
                 Cursor resultSet = getContentResolver().query(CProvider3.CONTENT_URI,null,null,null,null) ;
                 int index=0;
                 getSupportActionBar().setTitle("WEDNESDAY");
                 if (resultSet!=null) {
                     if (resultSet.getCount() != 0) {
                         if (resultSet.moveToFirst()) {
                             do {
                                 subject[index]=resultSet.getString(resultSet.getColumnIndex(CProvider3.NAME));

                                 if(subject[index].equalsIgnoreCase(""))
                                     subject[index]="FREE";


                                 classes[index]=resultSet.getString(resultSet.getColumnIndex(CProvider3.GRADE));
                                 time[index]=resultSet.getInt(resultSet.getColumnIndex(CProvider3.TIME));
                                 index++;
                             } while (resultSet.moveToNext());
                         }
                     }
                 }
             }
             else if (p.equals("thursday"))
             {
                 Cursor resultSet = getContentResolver().query(CProvider4.CONTENT_URI,null,null,null,null) ;
                 int index=0;
                 getSupportActionBar().setTitle("THURSDAY");
                 if (resultSet!=null) {
                     if (resultSet.getCount() != 0) {
                         if (resultSet.moveToFirst()) {
                             do {
                                 subject[index]=resultSet.getString(resultSet.getColumnIndex(CProvider4.NAME));

                                 if(subject[index].equalsIgnoreCase(""))
                                     subject[index]="FREE";


                                 classes[index]=resultSet.getString(resultSet.getColumnIndex(CProvider4.GRADE));
                                 time[index]=resultSet.getInt(resultSet.getColumnIndex(CProvider4.TIME));
                                 index++;
                             } while (resultSet.moveToNext());
                         }
                     }
                 }
             }
             else if (p.equals("friday"))
             {
                 Cursor resultSet = getContentResolver().query(CProvider5.CONTENT_URI,null,null,null,null) ;
                 int index=0;
                 getSupportActionBar().setTitle("FRIDAY");
                 if (resultSet!=null) {
                     if (resultSet.getCount() != 0) {
                         if (resultSet.moveToFirst()) {
                             do {
                                 subject[index]=resultSet.getString(resultSet.getColumnIndex(CProvider5.NAME));

                                 if(subject[index].equalsIgnoreCase(""))
                                     subject[index]="FREE";


                                 classes[index]=resultSet.getString(resultSet.getColumnIndex(CProvider5.GRADE));
                                 time[index]=resultSet.getInt(resultSet.getColumnIndex(CProvider5.TIME));
                                 index++;
                             } while (resultSet.moveToNext());
                         }
                     }
                 }
             }
        // DISPLAYING TIME TABLE BY LIST VIEW
        listView = (ListView) findViewById(R.id.lv);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            str = (time[i] + 1) + "";
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", subject[i]);
            hashMap.put("image", classes[i]);
            hashMap.put("time", time[i] + "-" + str);
            arrayList.add(hashMap);
        }
        String[] from = {"time", "name", "image"};
        int[] to = {R.id.iv1, R.id.tv1, R.id.tv2};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.activty_single_item, from, to);
        listView.setAdapter(simpleAdapter);

        // EDIT TIME TABLE BY LONG TAP
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity5.this,MainActivity6.class);
                i.putExtra("pos",position) ;
                i.putExtra("p",p);
                startActivity(i);
                return true;
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        Cursor resultSet;
        if (p.contentEquals("monday")) {
            resultSet = getContentResolver().query(CProvider.CONTENT_URI, null, null, null, null);
        }
        else if(p.contentEquals("tuesday"))
        {
            resultSet = getContentResolver().query(CProvider2.CONTENT_URI, null, null, null, null);
        }
        else if(p.contentEquals("wednesday"))
        {
            resultSet = getContentResolver().query(CProvider3.CONTENT_URI, null, null, null, null);
        }
        else if(p.contentEquals("thursday"))
        {
            resultSet = getContentResolver().query(CProvider4.CONTENT_URI, null, null, null, null);
        }
        else
        {
            resultSet = getContentResolver().query(CProvider5.CONTENT_URI, null, null, null, null);
        }
        int index = 0;
        if (resultSet != null) {
            if (resultSet.getCount() != 0) {
                if (resultSet.moveToFirst()) {
                    do {
                        subject[index] = resultSet.getString(1);

                        if (subject[index].equalsIgnoreCase(""))
                            subject[index] = "FREE";

                        classes[index] = resultSet.getString(2);
                        time[index] = resultSet.getInt(3);
                        index++;
                    } while (resultSet.moveToNext());
                }
            }
        }
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if(time[i]!=12)
            str = (time[i] + 1) + "";
            else
                str="1";
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", subject[i]);
            hashMap.put("image", classes[i]);
            hashMap.put("time", time[i] + "-" + str);
            arrayList.add(hashMap);
        }
        String[] from = {"time", "name", "image"};
        int[] to = {R.id.iv1, R.id.tv1, R.id.tv2};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.activty_single_item, from, to);
        listView.setAdapter(simpleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater() ;
        m.inflate(R.menu.menu_create,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // DELETING WHOLE TIME TABLE AND STOP GETTING NOTIFICATIONS
        if(item.getItemId()==R.id.action_favorite)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity5.this);
            alertDialogBuilder.setMessage("Are you sure, You want to delete");
            alertDialogBuilder.setPositiveButton("yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                         if(p.contentEquals("monday"))
                         {
                             getContentResolver().delete(CProvider.CONTENT_URI,null,null) ;
                             Intent intent = new Intent(MainActivity5.this, Notification_receiver.class);
                             PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, 0);
                             AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                             alarmManager.cancel(sender);
                             Toast.makeText(MainActivity5.this,"Monday Timetable Deleted..",Toast.LENGTH_SHORT).show();
                             finish() ;
                         }
                         else if (p.contentEquals("tuesday"))
                         {
                             getContentResolver().delete(CProvider2.CONTENT_URI,null,null);
                             Intent intent = new Intent(MainActivity5.this, Notification_receiver.class);
                             PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 2, intent, 0);
                             AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                             alarmManager.cancel(sender);
                             Toast.makeText(MainActivity5.this,"Tuesday Timetable Deleted..",Toast.LENGTH_SHORT).show();
                             finish();
                         }
                         else if (p.contentEquals("wednesday"))
                         {
                             getContentResolver().delete(CProvider3.CONTENT_URI,null,null);
                             Intent intent = new Intent(MainActivity5.this, Notification_receiver.class);
                             PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 3, intent, 0);
                             AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                             alarmManager.cancel(sender);
                             Toast.makeText(MainActivity5.this,"Wednesday Timetable Deleted..",Toast.LENGTH_SHORT).show();
                             finish();
                         }
                         else if (p.contentEquals("thursday"))
                         {
                             getContentResolver().delete(CProvider4.CONTENT_URI,null,null);
                             Intent intent = new Intent(MainActivity5.this, Notification_receiver.class);
                             PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 4, intent, 0);
                             AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                             alarmManager.cancel(sender);
                             Toast.makeText(MainActivity5.this,"Thursday Timetable Deleted..",Toast.LENGTH_SHORT).show();
                             finish();
                         }
                         else
                         {
                             getContentResolver().delete(CProvider5.CONTENT_URI,null,null);
                             Intent intent = new Intent(MainActivity5.this, Notification_receiver.class);
                             PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 5, intent, 0);
                             AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                             alarmManager.cancel(sender);
                             Toast.makeText(MainActivity5.this,"Friday Timetable Deleted..",Toast.LENGTH_SHORT).show();
                             finish();
                         }
                        }
                    });

            alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); ;
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        // SHARING TIME-TABLE
        else if (item.getItemId()==R.id.share) {
            if (p.contentEquals("monday")) {
                String string = "MONDAY\n";

                Cursor cu = getContentResolver().query(CProvider.CONTENT_URI, null, null, null, null);
               if (cu != null) {
                    if (cu.getCount() != 0) {
                        if (cu.moveToFirst()) {
                            do {
                                int t = cu.getInt(cu.getColumnIndex(CProvider.TIME)) + 1;
                                String time = t + "";
                                String x = cu.getString(cu.getColumnIndex(CProvider.NAME));
                                if (x.contentEquals(""))
                                    x = "FREE";
                                if (t == 13)
                                    time = 1 + "";
                                string = string + "\t\t" + cu.getString(cu.getColumnIndex(CProvider.TIME)) + "-" + time + "\t\t" + x + "\t\t" + cu.getString(cu.getColumnIndex(CProvider.GRADE)) + "\n";
                            } while (cu.moveToNext());
                        }
                    }
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, string);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else if (p.contentEquals("tuesday")) {
                String string = "TUESDAY\n";

                Cursor cu = getContentResolver().query(CProvider2.CONTENT_URI, null, null, null, null);
                if (cu != null) {
                    if (cu.getCount() != 0) {
                        if (cu.moveToFirst()) {
                            do {
                                int t = cu.getInt(cu.getColumnIndex(CProvider2.TIME)) + 1;
                                String time = t + "";
                                String x = cu.getString(cu.getColumnIndex(CProvider2.NAME));
                                if (x.contentEquals(""))
                                    x = "FREE";
                                if (t == 13)
                                    time = 1 + "";
                                string = string + "\t\t" + cu.getString(cu.getColumnIndex(CProvider2.TIME)) + "-" + time + "\t\t" + x + "\t\t" + cu.getString(cu.getColumnIndex(CProvider2.GRADE)) + "\n";
                            } while (cu.moveToNext());
                        }
                    }
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, string);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else if (p.contentEquals("wednesday")) {
                String string = "WEDNESDAY\n";

                Cursor cu = getContentResolver().query(CProvider3.CONTENT_URI, null, null, null, null);
                if (cu != null) {
                    if (cu.getCount() != 0) {
                        if (cu.moveToFirst()) {
                            do {
                                int t = cu.getInt(cu.getColumnIndex(CProvider3.TIME)) + 1;
                                String x = cu.getString(cu.getColumnIndex(CProvider3.NAME));
                                if (x.contentEquals(""))
                                    x = "FREE";
                                String time = t + "";
                                if (t == 13)
                                    time = 1 + "";
                                string = string + "\t\t" + cu.getString(cu.getColumnIndex(CProvider3.TIME)) + "-" + time + "\t\t" + x + "\t\t" + cu.getString(cu.getColumnIndex(CProvider3.GRADE)) + "\n";
                            } while (cu.moveToNext());
                        }
                    }
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, string);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else if (p.contentEquals("thursday")) {
                String string = "THURSDAY\n";

                Cursor cu = getContentResolver().query(CProvider4.CONTENT_URI, null, null, null, null);
                if (cu != null) {
                    if (cu.getCount() != 0) {
                        if (cu.moveToFirst()) {
                            do {
                                int t = cu.getInt(cu.getColumnIndex(CProvider4.TIME)) + 1;
                                String x = cu.getString(cu.getColumnIndex(CProvider4.NAME));
                                if (x.contentEquals(""))
                                    x = "FREE";
                                String time = t + "";
                                if (t == 13)
                                    time = 1 + "";
                                string = string + "\t\t" + cu.getString(cu.getColumnIndex(CProvider4.TIME)) + "-" + time + "\t\t" + x + "\t\t" + cu.getString(cu.getColumnIndex(CProvider4.GRADE)) + "\n";
                            } while (cu.moveToNext());
                        }
                    }
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, string);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } else {
                String string = "FRIDAY\n";

                Cursor cu = getContentResolver().query(CProvider5.CONTENT_URI, null, null, null, null);
                if (cu != null) {
                    if (cu.getCount() != 0) {
                        if (cu.moveToFirst()) {
                            do {
                                int t = cu.getInt(cu.getColumnIndex(CProvider5.TIME)) + 1;
                                String x = cu.getString(cu.getColumnIndex(CProvider5.NAME));
                                if (x.contentEquals(""))
                                    x = "FREE";
                                String time = t + "";
                                if (t == 13)
                                    time = 1 + "";
                                string = string + "\t\t" + cu.getString(cu.getColumnIndex(CProvider5.TIME)) + "-" + time + "\t\t" + x + "\t\t" + cu.getString(cu.getColumnIndex(CProvider5.GRADE)) + "\n";
                            } while (cu.moveToNext());
                        }
                    }
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, string);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }

        }
    return true ;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}