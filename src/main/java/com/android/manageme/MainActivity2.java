package com.android.manageme;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    int t;
    String  a;
    String[] daynames = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
    int[] dayimages = {R.drawable.monday, R.drawable.tuesday, R.drawable.wed, R.drawable.wakeup, R.drawable.friday};
    ListView slv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Creating list dynamically
        slv = (ListView) findViewById(R.id.slv);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < daynames.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", daynames[i]);
            hashMap.put("image", dayimages[i] + "");
            arrayList.add(hashMap);
        }
        String[] from = {"name", "image"};
        int[] to = {R.id.textview, R.id.imageview};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list_view_items, from, to);
        slv.setAdapter(simpleAdapter);
        slv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Cursor resultSet = getContentResolver().query(CProvider.CONTENT_URI, null, null, null, null);
                    if (resultSet.getCount() == 0) {
                        // THIS OPEN ACTIVITY FOR FIRST TIME FILLING TIME-TABLE
                        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                        intent.putExtra("day", "monday");
                        startActivity(intent);
                    } else {
                        // THIS OPENS ACTIVITY 5 DISPLAYING FILLED TIME-TABLE
                        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                        intent.putExtra("day", "monday");
                        startActivity(intent);
                    }
                } else if (position == 1) {
                    Cursor resultSet = getContentResolver().query(CProvider2.CONTENT_URI, null, null, null, null);
                    if (resultSet.getCount() == 0) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                        intent.putExtra("day", "tuesday");
                        startActivity(intent);
                    } else {
                        // THIS OPENS ACTIVITY 5
                        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                        intent.putExtra("day", "tuesday");
                        startActivity(intent);
                    }
                } else if (position == 2) {

                    Cursor resultSet = getContentResolver().query(CProvider3.CONTENT_URI, null, null, null, null);
                    if (resultSet.getCount() == 0) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                        intent.putExtra("day", "wednesday");
                        startActivity(intent);
                    } else {
                        // THIS OPENS ACTIVITY 5
                        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                        intent.putExtra("day", "wednesday");
                        startActivity(intent);
                    }
                } else if (position == 3) {
                    Cursor resultSet = getContentResolver().query(CProvider4.CONTENT_URI, null, null, null, null);
                    if (resultSet.getCount() == 0) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                        intent.putExtra("day", "thursday");
                        startActivity(intent);
                    } else {
                        // THIS OPENS ACTIVITY 5
                        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                        intent.putExtra("day", "thursday");
                        startActivity(intent);
                    }
                }
                if (position == 4) {
                    Cursor resultSet = getContentResolver().query(CProvider5.CONTENT_URI, null, null, null, null);
                    if (resultSet.getCount() == 0) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                        intent.putExtra("day", "friday");
                        startActivity(intent);
                    } else {
                        // THIS OPENS ACTIVITY 5
                        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                        intent.putExtra("day", "friday");
                        startActivity(intent);
                    }
                }

            }
        });
    }
}