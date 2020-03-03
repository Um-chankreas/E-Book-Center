package com.example.bookcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    Button btn_sign_up,btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                onpenhome();
            }
        });
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
