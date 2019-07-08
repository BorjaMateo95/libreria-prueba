package com.example.prueba;


public interface UserResponse {
    void onSuccess(UserJ ob);
    void onFailure(String msg);
}
