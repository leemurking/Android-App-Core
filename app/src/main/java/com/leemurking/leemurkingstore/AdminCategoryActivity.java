package com.leemurking.leemurkingstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView jones, jfours, nike720s, nike270s;
    private ImageView vans, airforceone, cactus, dior;
    private ImageView clanks, dripoffice, snake, gucci;
    private Button check_orders_btn, admin_logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        admin_logout_btn = (Button) findViewById(R.id.admin_logout_btn);
        admin_logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdminCategoryActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        check_orders_btn = (Button) findViewById(R.id.check_orders_btn);


        check_orders_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });



        jones = (ImageView) findViewById(R.id.jones);
        jfours = (ImageView) findViewById(R.id.jfours);
        nike720s = (ImageView) findViewById(R.id.nike720s);
        nike270s = (ImageView) findViewById(R.id.nike270s);

        vans = (ImageView) findViewById(R.id.vans);
        airforceone = (ImageView) findViewById(R.id.airforceone);
        cactus = (ImageView) findViewById(R.id.cactus);
        dior = (ImageView) findViewById(R.id.dior);

        clanks = (ImageView) findViewById(R.id.clanks);
        dripoffice = (ImageView) findViewById(R.id.dripoffice);
        snake = (ImageView) findViewById(R.id.snake);
        gucci = (ImageView) findViewById(R.id.gucci);


        jones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "jordan ones");
                startActivity(intent);
            }
        });
        jfours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "Jordan fours");
                startActivity(intent);
            }
        });


        nike720s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "nike 270s");
                startActivity(intent);
            }
        });


        nike270s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });


        vans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "vans");
                startActivity(intent);
            }
        });


        airforceone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "Air force ones");
                startActivity(intent);
            }
        });



        cactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "cactus jack");
                startActivity(intent);
            }
        });


        dior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "dior");
                startActivity(intent);
            }
        });



        clanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "clanks");
                startActivity(intent);
            }
        });


        dripoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "Officaial look");
                startActivity(intent);
            }
        });


        snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "leather");
                startActivity(intent);
            }
        });


        gucci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProduct.class);
                intent.putExtra("category", "Gucci");
                startActivity(intent);
            }
        });

    }
}