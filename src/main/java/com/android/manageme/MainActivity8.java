package com.android.manageme;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {
    EditText e81,e82,e83;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        e81 = (EditText) findViewById(R.id.e81);
        e82 = (EditText) findViewById(R.id.e82);
        e83=(EditText) findViewById(R.id.e83);
    }
    public void addRowP(View v){
        if (e81.getText().toString().contentEquals("")||e82.getText().toString().contentEquals("")||e83.getText().toString().contentEquals(""))
        {
            Toast.makeText(MainActivity8.this,"Insufficient Details..",Toast.LENGTH_SHORT).show();
        }
        else {
            ContentValues values = new ContentValues();
            values.put("name", e81.getText().toString());
            values.put("grade", e82.getText().toString());
            values.put("time", e83.getText().toString());
            Cursor c = getContentResolver().query(CProviderP.CONTENT_URI, null, null, null, null);
            c.moveToLast();
            getContentResolver().insert(CProviderP.CONTENT_URI, values);
            finish();
        }
    }
}
