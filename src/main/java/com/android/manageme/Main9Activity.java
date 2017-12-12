package com.android.manageme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Main9Activity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main9);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Main9Activity.this,MainActivity.class);
                Main9Activity.this.startActivity(mainIntent);
                Main9Activity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}