package com.android.manageme;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Assignments extends AppCompatActivity {
    ArrayList<String> assignmentS=new ArrayList<>();
    ArrayList<String> assignmentD=new ArrayList<>();
    ArrayList<String> assignmentT=new ArrayList<>();
    int j=0,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
        Cursor cu= getContentResolver().query(CProviderA.CONTENT_URI,null,null,null,null);
        if (cu!=null) {
            if (cu.getCount() != 0) {
                if (cu.moveToFirst()) {
                    do {
                        assignmentS.add(0,cu.getString(cu.getColumnIndex(CProviderA.NAME)));
                        assignmentD.add(0,cu.getString(cu.getColumnIndex(CProviderA.GRADE)));
                        assignmentT.add(0,cu.getString(cu.getColumnIndex(CProviderA.TIME)));
                        j++;
                    } while (cu.moveToNext());
                }
            }
        }
        ListView assign = (ListView) findViewById(R.id.assign);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for(i=0;i<j;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("subject", assignmentS.get(i));
            hashMap.put("details",assignmentD.get(i));
            hashMap.put("date",assignmentT.get(i));
            arrayList.add(hashMap);
        }
        String from[]={"subject","details","date"};
        int to[]={R.id.tv1,R.id.tv2,R.id.iv1};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.activty_single_item, from, to);
        assign.setAdapter(simpleAdapter);
        assign.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int pp=position+1;
                getContentResolver().delete(CProviderA.CONTENT_URI,"_id="+pp,null);
                finish();
                return true;
            }
        });
    }
}