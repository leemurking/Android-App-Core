package com.leemurking.leemurkingstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    Button signupbutton;
    EditText signupeditusername;
    FirebaseAuth fAuth;
    EditText signupeditemail;
    EditText signupeditphonenumber;
    EditText signupeditpassword;
    ProgressBar progressBar;

    private FirebaseDatabase db = com.google.firebase.database.FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupbutton = findViewById(R.id.signupbutton);
        signupeditusername = findViewById(R.id.signupeditusername);
        signupeditemail = findViewById(R.id.signupeditemail);
        signupeditphonenumber = findViewById(R.id.signupeditphonenumber);
        signupeditpassword = findViewById(R.id.signupeditpassword);
        signupbutton = findViewById(R.id.signupbutton);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
            finish();
        }


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = signupeditusername.getText().toString().trim();
                String email = signupeditemail.getText().toString().trim();
                String phone = signupeditphonenumber.getText().toString().trim();
                String password = signupeditpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    signupeditemail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    signupeditpassword.setError("Password is required");
                    return;
                }

                if(password.length() < 6) {
                    signupeditpassword.setError("Password must be >= 6 characters");
                    return;
                }

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put( "username", username);
                userMap.put( "email", email);
                userMap.put( "phone number", phone);
                userMap.put( "password", password);

                root.push().setValue(userMap);


                // Register the user in Firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()) {
                           Toast.makeText(SignUpActivity.this,"User Created",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(), HomePageActivity.class));

                       } else {
                           Toast.makeText(SignUpActivity.this, "Error ! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                       }
                    }
                });

            }
        });
    }
}