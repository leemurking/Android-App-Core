package com.leemurking.leemurkingstore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leemurking.leemurkingstore.Model.Users;

public class LoginActivity extends AppCompatActivity {
    private EditText login_phone_number_input, login_password_input;
    private Button login_btn;
    private ProgressDialog loadingBar;
    private TextView not_admin_panel_link, admin_panel_link;
    private String parentDbName = "Users";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = (Button) findViewById(R.id.login_btn);
        login_password_input = (EditText) findViewById(R.id.login_password_input);
        login_phone_number_input = (EditText) findViewById(R.id.login_phone_number_input);
        admin_panel_link = (TextView) findViewById(R.id.admin_panel_link);
        not_admin_panel_link = (TextView) findViewById(R.id.not_admin_panel_link);
        loadingBar = new ProgressDialog(this);
//        Paper.init(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

        admin_panel_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                login_btn.setText("Login Admin");
                admin_panel_link.setVisibility(View.INVISIBLE);
                not_admin_panel_link.setVisibility(View.VISIBLE);
                parentDbName = "Admin";
            }
        });
        not_admin_panel_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                login_btn.setText("Login");
                admin_panel_link.setVisibility(View.VISIBLE);
                not_admin_panel_link.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }

    private void LoginUser()
    {
        String phone = login_phone_number_input.getText().toString();
        String password = login_password_input.getText().toString();

        if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            AllowAccessToAccount(phone, password);
        }
    }
    private void AllowAccessToAccount(final String phone, final String password)
    {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentDbName).child(phone).exists()){

                    Users usersData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);
                    if (usersData.getPhone().equals(phone))
                    {
                        if (usersData.getPassword().equals(password))
                        {
                            if(parentDbName.equals("Admin"))
                            {
                                Toast.makeText(LoginActivity.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(LoginActivity.this, AdminCategoryActivity.class);
                                startActivity(intent);
                            }
                            else if (parentDbName.equals("Users")){
                                Toast.makeText(LoginActivity.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(LoginActivity.this, Home.class);
//                                com.leemurking.leemurkingstore.Prevalent.currentOnlineUser = usersData;
                                startActivity(intent);
                            }

                        }
                        else {
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this,"Password is incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, "Account with this " + phone + " number do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

