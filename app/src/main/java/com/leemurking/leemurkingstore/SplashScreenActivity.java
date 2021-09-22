package com.leemurking.leemurkingstore;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {


    Animation topAnim, bottomAnim;
    ImageView splashimg;
    TextView splashtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        splashimg = findViewById(R.id.splashimg);
        splashtext = findViewById(R.id.splashtext);

        splashimg.setAnimation(topAnim);
        splashtext.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,
                        MainActivity.class);

                startActivity(intent);

                finish();
            }
        }, 4000);


    }
}