package com.android.manageme;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Fields extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String field[]={"Time-Table","Assignments","Projects"};
    int images[]={R.drawable.schooltimetable,R.drawable.assign,R.drawable.xxx};
    Spinner spinner;
    String x, y;
    String z, a;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);
        x = getIntent().getExtras().getString("username");
        y = getIntent().getExtras().getString("college");
        z = getIntent().getExtras().getString("year");
        a = getIntent().getExtras().getString("course");
        String[] banks = {x, "Profile", "Logout"};
        // Creating first row to display name and spinner for profile and logout
        tv = (TextView) findViewById(R.id.te);
        tv.setText("Welcome.");
        tv.setTextSize(20);

        spinner = (Spinner) findViewById(R.id.sp);
        spinner.animate();
        spinner.setOnItemSelectedListener(Fields.this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, banks);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // creating lists dynamically
        ListView fields = (ListView) findViewById(R.id.fields);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", field[i]);
            hashMap.put("image", images[i] + "");
            arrayList.add(hashMap);
        }
        String[] from = {"name", "image"};
        int[] to = {R.id.textview, R.id.imageview};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list_view_items, from, to);
        fields.setAdapter(simpleAdapter);
        fields.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent i=new Intent(Fields.this,MainActivity2.class);
                    startActivity(i);
                }
                else if(position==1)
                {
                    Cursor ce=getContentResolver().query(CProviderA.CONTENT_URI,null,null,null,null);
                    if (ce.getCount()==0)
                        Toast.makeText(Fields.this,"No Assignment present..",Toast.LENGTH_SHORT).show();
                    else
                    {
                    Intent i=new Intent(Fields.this,Assignments.class);
                    startActivity(i);}
                }
                else if(position==2)
                {

                    Cursor ce =getContentResolver().query(CProviderP.CONTENT_URI,null,null,null,null);
                    if (ce.getCount()==0)
                        Toast.makeText(Fields.this,"No Project present..",Toast.LENGTH_SHORT).show();
                    else{
                    Intent i=new Intent(Fields.this,Projects.class);
                    startActivity(i);}
                }
            }
        });
        fields.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    return false;
                else if (position == 1) {
                    Intent intent7 = new Intent(Fields.this, MainActivity7.class);
                    startActivity(intent7);
                    return true;
                } else{
                    Intent intent8 = new Intent(Fields.this, MainActivity8.class);
                    startActivity(intent8);
                    return true;
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 1) {

            Intent intent2 = new Intent(Fields.this, Main3Activity.class);
            intent2.putExtra("user1", x);
            intent2.putExtra("college2", y);
            intent2.putExtra("year2", z);
            intent2.putExtra("course2", a);
            startActivity(intent2);
        } else if (position == 2) {
            finish();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}