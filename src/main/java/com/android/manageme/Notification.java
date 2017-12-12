package com.android.manageme;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Notification extends AppCompatActivity {

    ListView listView;
    String subject[] = {"", "", "", "", "", "", "", ""};
    String classes[] = {"", "", "", "", "", "", "", ""};
    int time[] = {0, 0, 0, 0, 0, 0, 0, 0};
    Toolbar toolbar;
    String str, p, q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        p = getIntent().getExtras().getString("p");
        if (p.contentEquals("monday")) {
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
        } else if (p.equals("tuesday")) {
            Cursor resultSet = getContentResolver().query(CProvider2.CONTENT_URI, null, null, null, null);
            int index = 0;
            getSupportActionBar().setTitle("TUESDAY");
            if (resultSet != null) {
                if (resultSet.getCount() != 0) {
                    if (resultSet.moveToFirst()) {
                        do {
                            subject[index] = resultSet.getString(resultSet.getColumnIndex(CProvider2.NAME));
                            if (subject[index].equalsIgnoreCase(""))
                                subject[index] = "FREE";

                            classes[index] = resultSet.getString(resultSet.getColumnIndex(CProvider2.GRADE));
                            time[index] = resultSet.getInt(resultSet.getColumnIndex(CProvider2.TIME));
                            index++;
                        } while (resultSet.moveToNext());
                    }
                }
            }
        } else if (p.equals("wednesday")) {
            Cursor resultSet = getContentResolver().query(CProvider3.CONTENT_URI, null, null, null, null);
            int index = 0;
            getSupportActionBar().setTitle("WEDNESDAY");
            if (resultSet != null) {
                if (resultSet.getCount() != 0) {
                    if (resultSet.moveToFirst()) {
                        do {
                            subject[index] = resultSet.getString(resultSet.getColumnIndex(CProvider3.NAME));

                            if (subject[index].equalsIgnoreCase(""))
                                subject[index] = "FREE";

                            classes[index] = resultSet.getString(resultSet.getColumnIndex(CProvider3.GRADE));
                            time[index] = resultSet.getInt(resultSet.getColumnIndex(CProvider3.TIME));
                            index++;
                        } while (resultSet.moveToNext());
                    }
                }
            }
        } else if (p.equals("thursday")) {
            Cursor resultSet = getContentResolver().query(CProvider4.CONTENT_URI, null, null, null, null);
            int index = 0;
            getSupportActionBar().setTitle("THURSDAY");
            if (resultSet != null) {
                if (resultSet.getCount() != 0) {
                    if (resultSet.moveToFirst()) {
                        do {
                            subject[index] = resultSet.getString(resultSet.getColumnIndex(CProvider4.NAME));
                            if (subject[index].equalsIgnoreCase(""))
                                subject[index] = "FREE";

                            classes[index] = resultSet.getString(resultSet.getColumnIndex(CProvider4.GRADE));
                            time[index] = resultSet.getInt(resultSet.getColumnIndex(CProvider4.TIME));
                            index++;
                        } while (resultSet.moveToNext());
                    }
                }
            }
        } else if (p.equals("friday")) {
            Cursor resultSet = getContentResolver().query(CProvider5.CONTENT_URI, null, null, null, null);
            int index = 0;
            getSupportActionBar().setTitle("FRIDAY");
            if (resultSet != null) {
                if (resultSet.getCount() != 0) {
                    if (resultSet.moveToFirst()) {
                        do {
                            subject[index] = resultSet.getString(resultSet.getColumnIndex(CProvider5.NAME));
                            if (subject[index].equalsIgnoreCase(""))
                                subject[index] = "FREE";

                            classes[index] = resultSet.getString(resultSet.getColumnIndex(CProvider5.GRADE));
                            time[index] = resultSet.getInt(resultSet.getColumnIndex(CProvider5.TIME));
                            index++;
                        } while (resultSet.moveToNext());
                    }
                }
            }
        }

        // SETTING TIME TABLE ON LIST VIEW
        listView = (ListView) findViewById(R.id.lv1);
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
    }
}