package com.leemurking.leemurkingstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class LoginActivity extends AppCompatActivity {
    Button newloginbutton;
    Button signupbutton;

    EditText editusername,editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editusername = findViewById(R.id.editusername);
        editpassword = findViewById(R.id.editpassword);

        newloginbutton = (Button) findViewById(R.id.newloginbutton);

        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.editusername, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this, R.id.editpassword,
                ".{6}", R.string.invalid_password);




        newloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext() ,
                            "Form Valodate Successfully...",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext()
                    ,"Validation Failed,",Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        signupbutton = (Button) findViewById(R.id.signupbutton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }
}