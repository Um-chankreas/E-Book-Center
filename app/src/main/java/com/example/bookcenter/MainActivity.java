package com.example.bookcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_Login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentSignup();
            }
        });
    }
    public void opentSignup()
    {
        Intent intent = new Intent(this,sign_up.class);
        startActivity(intent);
    }
}
