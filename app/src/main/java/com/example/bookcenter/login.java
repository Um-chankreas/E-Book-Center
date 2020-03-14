package com.example.bookcenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    EditText input_email,input_password;

    private static final Pattern Password_PATTERN = Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-zA-Z])" +
                    "(?=\\S+$)" +
                    ".{6,}" +
                    "$");

    Button btn_sign_up,btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = findViewById(R.id.edit_text_login_email);
        input_password=findViewById(R.id.edit_text_login_password);



        btn_sign_up = findViewById(R.id.btn_con_eamil);
        btn_login =findViewById(R.id.btn_login);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentSignup();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validationEmail() | !validationPassword())
                {
                    return;
                }
                else {
                    onpenhome();
                }

            }
        });
    }
    public boolean validationEmail()
    {
        String emailInput = input_email.getText().toString().trim();
        if (emailInput.isEmpty())
        {
            input_email.setError("Email can't be empty!");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            input_email.setError("Please input valid email!");
            return false;
        }
        else
        {
            input_email.setError(null);
            return true;
        }
    }
    public boolean validationPassword()
    {
        String passwordInput = input_password.getText().toString().trim();
        if (passwordInput.isEmpty())
        {
            input_password.setError("Password can't be empty!");
            return false;
        }
        else if (!Password_PATTERN.matcher(passwordInput).matches())
        {
            input_password.setError("Please input valid Password!");
            return false;
        }
        else {
            input_password.setError(null);
            return true;
        }
    }
    public void opentSignup()
    {
        Intent intent_sign_up = new Intent(this,sign_up.class);
        startActivity(intent_sign_up);

    }
    public void onpenhome()
    {
        Intent intent_login = new Intent(this,MainActivity.class);
        startActivity(intent_login);
    }
}
