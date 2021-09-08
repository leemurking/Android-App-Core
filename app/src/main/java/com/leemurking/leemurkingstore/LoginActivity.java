package com.leemurking.leemurkingstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button newloginbutton;
    Button signupbutton1;
    TextView welcome, signuptext;
    FirebaseAuth fAuth;
    EditText editemail,editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newloginbutton = (Button) findViewById(R.id.newloginbutton);
        signupbutton1 = (Button) findViewById(R.id.signupbutton1);
        welcome = findViewById(R.id.welcome);
        signuptext = findViewById(R.id.signuptext);
        editemail = findViewById(R.id.editemail);
        editpassword = findViewById(R.id.editpassword);
        fAuth = FirebaseAuth.getInstance();

        newloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editemail.getText().toString().trim();
                String password = editpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    editemail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    editpassword.setError("Password is required");
                    return;
                }

                if(password.length() < 6) {
                    editpassword.setError("Password must be >= 6 characters");
                    return;
                }


                // Authenticate the user in Firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,"Logged in successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Error ! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
        signupbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}