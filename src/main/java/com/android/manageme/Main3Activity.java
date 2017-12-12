package com.android.manageme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
TextView x2,x4,x6,x8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        x2=(TextView)findViewById(R.id.x2);
        x2.setText(getIntent().getExtras().getString("user1"));
        x4=(TextView)findViewById(R.id.x4);
        x4.setText(getIntent().getExtras().getString("college2"));
        x6=(TextView)findViewById(R.id.x6);
        x6.setText(getIntent().getExtras().getString("year2"));
        x8=(TextView)findViewById(R.id.x8);
        x8.setText(getIntent().getExtras().getString("course2"));
    }
}