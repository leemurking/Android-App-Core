package com.leemurking.leemurkingstore;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends Activity  {
    LottieAnimationView btUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button main_join_now_btn = (Button) findViewById(R.id.main_join_now_btn);
        Button main_login_btn = (Button) findViewById(R.id.main_login_btn);

        btUp = findViewById(R.id.bt_up);



        main_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        main_join_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }

}
