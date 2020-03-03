package com.example.bookcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class sign_up extends AppCompatActivity {

    private ImageView imageViewpre;
    Button btn_sign_up_Tohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageViewpre = findViewById(R.id.icon_pre);
        btn_sign_up_Tohome = findViewById(R.id.btn_signup);
        imageViewpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
        btn_sign_up_Tohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToHome();
            }
        });
    }
    public void openLogin()
    {
        Intent i = new Intent(this,login.class);
        startActivity(i);
    }
    public void openToHome()
    {
        Intent sing_up_to_home = new Intent(this,MainActivity.class);
        startActivity(sing_up_to_home);
    }
}
