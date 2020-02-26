package com.example.bookcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class sign_up extends AppCompatActivity {

    private ImageView imageViewpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageViewpre = findViewById(R.id.icon_pre);
        imageViewpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }
    public void openLogin()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
