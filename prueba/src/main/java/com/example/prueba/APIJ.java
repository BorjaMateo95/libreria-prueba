package com.example.prueba;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIJ {
    @GET("users/{email}")
    Call<UserJ> login(@Path("email") String email);

}
