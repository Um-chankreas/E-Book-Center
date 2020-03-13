package com.example.bookcenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Pattern;

public class sign_up extends AppCompatActivity {

    private ImageView imageViewpre;
    Button btn_sign_up_Tohome;

    EditText editText_Username,editText_Email,editText_Password;
    RequestQueue mRequestQueue;

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" +
            "(?=.*[a-zA-Z])" +
            "(?=\\S+$)" +
            ".{6,}" +
            "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mRequestQueue = Volley.newRequestQueue(this);
        editText_Username = findViewById(R.id.username);
        editText_Email = findViewById(R.id.email);
        editText_Password = findViewById(R.id.password);
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



                if (!validateEmail() | !validatePassword() | !validationName())
                {
                    return;
                }

                HashMap data = new HashMap();
                data.put("Username",editText_Username.getText().toString());
                data.put("Email",editText_Email.getText().toString());
                data.put("Password",editText_Password.getText().toString());
                String url = "http://192.168.43.238:8000/api/user/create";

                postData(url,data);

                String input ="Username:" + editText_Username.getText().toString();
                input += "\n";
                input ="Email:" + editText_Email.getText().toString();
                input += "\n";
                input += "Password: " + editText_Password.getText().toString();
                openToHome();



            }
        });
    }
    private boolean validateEmail()
    {
        String emailInput = editText_Email.getText().toString().trim();
        if (emailInput.isEmpty())
        {
            editText_Email.setError("Failed,can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            editText_Email.setError("Please enter valid Email!");
            return false;
        }
        else {
            editText_Email.setError(null);
            return true;
        }
    }
    private boolean validatePassword()
    {
        String passwordInput = editText_Password.getText().toString().trim();
        if (passwordInput.isEmpty())
        {
            editText_Password.setError("Field password can't be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches())
        {
            editText_Password.setError("Weak Password");
            return false;
        }
        else {
            editText_Password.setError(null);
            return true;
        }
    }
    private boolean validationName()
    {
        String nameInput = editText_Username.getText().toString().trim();
        if (nameInput.isEmpty())
        {
            editText_Username.setError("Field Username can't be empty");
            return false;
        }
        else {
            editText_Username.setError(null);
            return true;
        }
    }
//    public void signUp(View view)
//    {
//        if (!validateEmail() | !validatePassword())
//        {
//            return;
//        }
//        String input ="Email:" + editText_Email.getText().toString();
//        input += "\n";
//        input += "Password: " + editText_Password.getText().toString();
//
//    }

    public void postData(String url, HashMap data){
        final RequestQueue requstQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(data),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("SUCC_onResponse",response.toString());
                        // do your business logic here.....
                        clearEditTextView();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ERROR_onErrorResponse",error.toString());
                    }
                }
        ){

        };
        requstQueue.add(jsonobj);

    }

    private  void clearEditTextView()
    {
        editText_Username.setText("");
        editText_Email.setText("");
        editText_Password.setText("");
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
