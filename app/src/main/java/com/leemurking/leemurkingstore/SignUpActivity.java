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

public class SignUpActivity extends AppCompatActivity {
    Button signupbutton;

    EditText signupeditusername,signupeditpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupeditusername = findViewById(R.id.signupeditusername);
        signupeditpassword = findViewById(R.id.signupeditpassword);

        signupbutton = findViewById(R.id.signupbutton);

        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.signupeditusername, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this, R.id.signupeditpassword,
                ".{6}", R.string.invalid_password);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext() ,
                            "Form Valodate Successfully...",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext()
                            ,"Validation Failed,",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });


    }
}