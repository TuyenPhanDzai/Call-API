package com.example.ecommerceapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.retrofit.RetrofitService;
import com.example.ecommerceapp.retrofit.UserApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    EditText edittextName, edittextEmail, edittextPassword;
    Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();

    }

    private void initializeComponents() {

        edittextName = findViewById(R.id.name);
        edittextEmail = findViewById(R.id.email);
        edittextPassword = findViewById(R.id.password);
        buttonSignup = findViewById(R.id.buttonSignup);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        buttonSignup.setOnClickListener(view -> {
            String name = String.valueOf(edittextName.getText());
            String email = String.valueOf(edittextEmail.getText());
            String password = String.valueOf(edittextPassword.getText());

            User user = new User(name, email, password);

            userApi.createUser(user)
                    .enqueue(new Callback<User>() {
                        @Override

                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                                Log.e("API_ERROR", "Response code: " + response.code() + ", Error body: " + response.errorBody().toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });

        });

    }


}