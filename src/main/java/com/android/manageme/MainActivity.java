package com.android.manageme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Spinner spinner1;
    Button button;
    String a, b;
    String y, z;
    EditText et1, et2;
    String[] courses = {"NONE", "B.Tech.", "M.Tech.", "MCA", "M.Sc.", "MSW"};
    ArrayList<String> years ;
    ArrayAdapter<String> arrayAdapter1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        years = new ArrayList<String>() ;
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        spinner = (Spinner) findViewById(R.id.spinner1);

        if (savedInstanceState != null) {
            a = savedInstanceState.getString(String.valueOf(et1));
            b = savedInstanceState.getString(String.valueOf(et2));
        }
        if (a != null) {
            et1.setText(a);
        }
        if (b != null) {
            et2.setText(b);
        }

        String s=getIntent().getStringExtra("v");
        button=(Button)findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Fields.class);
                intent.putExtra("username", et1.getText().toString());
                intent.putExtra("college", et2.getText().toString());
                intent.putExtra("year", z);
                intent.putExtra("course", y);
                startActivity(intent);
                finish();
            }

        });
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courses);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner1:
                y = courses[position];
                if(position==0)
                {
                    years.clear();
                    arrayAdapter1 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, years);
                    arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(arrayAdapter1);
                    spinner1.setEnabled(false);
                    break;
                }
                spinner1.setEnabled(true);
                if (position == 2 || position == 4 || position == 5) {
                     years.clear();
                    years.add(0,"2nd Year");
                    years.add(0,"1st Year");
                } else if (position == 3) {
                    years.clear();
                    years.add(0, "3rd Year");
                    years.add(0, "2nd Year");
                    years.add(0, "1st Year");
                }
                else if (position == 1){
                    years.clear();
                    years.add(0,"4th Year");
                    years.add(0,"3rd Year");
                    years.add(0,"2nd Year");
                    years.add(0,"1st Year");
                }
                arrayAdapter1 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, years);
                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(arrayAdapter1);

        break;
        case R.id.spinner2:
        z = years.get(position);
        break;
    }
 }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}