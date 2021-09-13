package com.leemurking.leemurkingstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {
    private DatabaseReference ProductsRef;
    DrawerLayout drawer_layout;
    NavigationView nav_view;
    Toolbar toolbar;
    TextView textView;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");
//
//        drawer_layout=findViewById(R.id.drawer_layout);
//        nav_view=findViewById(R.id.nav_view);
//        toolbar=findViewById(R.id.toolbar);
//        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Home");
//        setSupportActionBar(toolbar);
//
//        nav_view.bringToFront();
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawer_layout.addDrawerListener(toggle);
//        toggle.syncState();
//        nav_view.setNavigationItemSelectedListener(this);
//
//
//        View headerView = nav_view.getHeaderView(0);
//        TextView userNameTextView = headerView.findViewById(R.id.user_profile_name);
//        ImageView profileImageView = headerView.findViewById(R.id.user_profile_image);
////        userNameTextView.setText(Prevalent.currentOnlineUser.getName());
////        Picasso.get().load(Prevalent.currentOnlineUser.getImage()).placeholder(R.drawable.profile).into(profileImageView);
//        recyclerView = findViewById(R.id.recycler_menu);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this,CartActivity.class);
//                startActivity(intent);
//            }
//        });
    }

}