package com.android.manageme;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    EditText e71,e72,e73;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        e71 = (EditText) findViewById(R.id.e71);
        e72 = (EditText) findViewById(R.id.e72);
        e73=(EditText) findViewById(R.id.e73);
    }
    public void addRowA(View v){

        if (e71.getText().toString().contentEquals("")||e72.getText().toString().contentEquals("")||e73.getText().toString().contentEquals(""))
        {
            Toast.makeText(MainActivity7.this,"Insufficient Details..",Toast.LENGTH_SHORT).show();
        }
        else {
            ContentValues values = new ContentValues();
            values.put("name", e71.getText().toString());
            values.put("grade", e72.getText().toString());
            values.put("time", e73.getText().toString());
            Cursor c = getContentResolver().query(CProviderA.CONTENT_URI, null, null, null, null);
            c.moveToLast();
            getContentResolver().insert(CProviderA.CONTENT_URI, values);
            finish();
        }
    }
}
