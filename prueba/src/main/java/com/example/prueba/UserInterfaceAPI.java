package com.example.prueba;

public interface UserInterfaceAPI {
    void login(String id, String pass, UserResponse userResponse);
    void registry(String name, String email, String pass, UserResponse userResponse);
}
