package com.example.ecommerceapp.retrofit;

import com.example.ecommerceapp.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {

    @GET("users/{id}")
    Call<User> getUserById(@Path("id") String id);

    @POST("users/create")
    Call<User> createUser(User user);

}
