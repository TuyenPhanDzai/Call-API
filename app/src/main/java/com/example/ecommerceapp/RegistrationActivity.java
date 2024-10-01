package com.example.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegistrationActivity extends AppCompatActivity {

    EditText name, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void signup(View view) {
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if(TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Enter Name!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "Enter Email Address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPassword.length() < 6) {
            Toast.makeText(this, "Password too short, enter minium 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        startActivities(new Intent[]{new Intent(RegistrationActivity.this, MainActivity.class)});
    }

    public void signin(View view) {
        startActivities(new Intent[]{new Intent(RegistrationActivity.this, LoginActivity.class)});
    }


}