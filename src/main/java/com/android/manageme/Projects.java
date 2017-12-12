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

public class Projects extends AppCompatActivity {
    ArrayList<String> assignment1S=new ArrayList<>();
    ArrayList<String> assignment1D=new ArrayList<>();
    ArrayList<String> assignment1T=new ArrayList<>();
    int j=0,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Cursor cu= getContentResolver().query(CProviderP.CONTENT_URI,null,null,null,null);
        if (cu!=null) {
            if (cu.getCount() != 0) {
                if (cu.moveToFirst()) {
                    do {
                        assignment1S.add(0,cu.getString(cu.getColumnIndex(CProviderP.NAME)));
                        assignment1D.add(0,cu.getString(cu.getColumnIndex(CProviderP.GRADE)));
                        assignment1T.add(0,cu.getString(cu.getColumnIndex(CProviderP.TIME)));
                        j++;
                    } while (cu.moveToNext());
                }
            }
        }
        ListView pro = (ListView) findViewById(R.id.pro);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for(i=0;i<j;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("subject", assignment1S.get(i));
            hashMap.put("details",assignment1D.get(i));
            hashMap.put("date",assignment1T.get(i));
            arrayList.add(hashMap);
        }
        String from[]={"subject","details","date"};
        int to[]={R.id.tv1,R.id.tv2,R.id.iv1};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.activty_single_item, from, to);
        pro.setAdapter(simpleAdapter);
        pro.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int pp=position+1;
                getContentResolver().delete(CProviderP.CONTENT_URI,"_id="+pp,null);
                finish();
                return true;
            }
        });
    }
}