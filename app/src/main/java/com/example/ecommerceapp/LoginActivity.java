package com.example.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void signup(View view) {
        startActivities(new Intent[]{new Intent(LoginActivity.this, RegistrationActivity.class)});
    }

    public void signin(View view) {
        startActivities(new Intent[]{new Intent(LoginActivity.this, MainActivity.class)});
    }
}