package com.leemurking.leemurkingstore;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  {
    Handler handler;
    Runnable runnable;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        image = findViewById(R.id.image);
//        image.animate().alpha(0).setDuration(0);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent dsp = new Intent(MainActivity.this,LoginActivity.class);
               startActivity(dsp);
               finish();
            }
        }, 4000 );

    }

}
