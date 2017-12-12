package com.android.manageme;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    EditText et1, et2;
   int pos,po ;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
         pos = getIntent().getExtras().getInt("pos");
        po  = pos+1 ;
        str=getIntent().getExtras().getString("p");
        if(str.contentEquals("monday"))
        {
            Cursor c = getContentResolver().query(CProvider.CONTENT_URI, null, null, null, null);
            if (c != null && c.getCount() != 0) {
                c.moveToPosition(pos);
                et1.setText(c.getString(c.getColumnIndex(CProvider.NAME)));
                et2.setText(c.getString(c.getColumnIndex(CProvider.GRADE)));
            }
        }
        else if(str.contentEquals("tuesday")) {
            Cursor c = getContentResolver().query(CProvider2.CONTENT_URI, null,"_id = "+po,null, null);
            String s = "" ;
            c.moveToFirst() ;
            if (c != null && c.getCount() != 0) {
                c.moveToPosition(pos);
                et1.setText(c.getString(c.getColumnIndex(CProvider2.NAME)));
                et2.setText(c.getString(c.getColumnIndex(CProvider2.GRADE)));
            }
        }
        else if(str.contentEquals("wednesday"))
        {
            Cursor c = getContentResolver().query(CProvider3.CONTENT_URI, null, null, null, null);
            if (c != null && c.getCount() != 0) {
                c.moveToPosition(pos);
                et1.setText(c.getString(c.getColumnIndex(CProvider3.NAME)));
                et2.setText(c.getString(c.getColumnIndex(CProvider3.GRADE)));
            }
        }
        else if(str.contentEquals("thursday"))
        {
            Cursor c = getContentResolver().query(CProvider4.CONTENT_URI, null, null, null, null);
            if (c != null && c.getCount() != 0) {
                c.moveToPosition(pos);
                et1.setText(c.getString(c.getColumnIndex(CProvider4.NAME)));
                et2.setText(c.getString(c.getColumnIndex(CProvider4.GRADE)));
            }
        }
        else if(str.contentEquals("friday"))
        {
            Cursor c = getContentResolver().query(CProvider5.CONTENT_URI, null, null, null, null);
            if (c != null && c.getCount() != 0) {
                c.moveToPosition(pos);
                et1.setText(c.getString(c.getColumnIndex(CProvider5.NAME)));
                et2.setText(c.getString(c.getColumnIndex(CProvider5.GRADE)));
            }
        }

    }

    public void save(View v) {
        if (et1.getText().toString().contentEquals("")||et2.getText().toString().contentEquals(""))
        {
            Toast.makeText(MainActivity6.this,"Details Incomplete..",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ContentValues values = new ContentValues();
            values.put("name", et1.getText().toString());
            values.put("grade", et2.getText().toString());

            Cursor c = getContentResolver().query(CProvider2.CONTENT_URI, null, "_id = " + po, null, null);
            c.moveToFirst();
            if (str.contentEquals("monday"))
                getContentResolver().update(CProvider.CONTENT_URI, values, "_id = " + po, null);
            else if (str.contentEquals("tuesday"))
                getContentResolver().update(CProvider2.CONTENT_URI, values, "_id = " + po, null);
            else if (str.contentEquals("wednesday"))
                getContentResolver().update(CProvider3.CONTENT_URI, values, "_id = " + po, null);
            else if (str.contentEquals("thursday"))
                getContentResolver().update(CProvider4.CONTENT_URI, values, "_id = " + po, null);
            else if (str.contentEquals("friday"))
                getContentResolver().update(CProvider5.CONTENT_URI, values, "_id = " + po, null);
            finish();
        }
    }
}