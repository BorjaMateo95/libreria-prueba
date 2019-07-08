package com.example.prueba;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryJ {

    private static UserRepositoryJ usersRepository;
    private APIJ api;

    public static UserRepositoryJ getInstance(String url){
        if (usersRepository == null){
            usersRepository = new UserRepositoryJ(url);
        }
        return usersRepository;
    }


    public UserRepositoryJ(String url){
        api = RetrofitServiceJ.createService(APIJ.class, url);
    }

    public void login(String email, String pass, final UserResponse usersResponse) {
        api.login(email).enqueue(new Callback<UserJ>() {
            @Override
            public void onResponse(Call<UserJ> call, Response<UserJ> response) {
                if (response.isSuccessful()){
                    usersResponse.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserJ> call, Throwable t) {
                usersResponse.onFailure(t.getMessage());
            }
        });
    }


}
