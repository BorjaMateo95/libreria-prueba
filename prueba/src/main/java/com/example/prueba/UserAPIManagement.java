package com.example.prueba;

public class UserAPIManagement implements UserInterfaceAPI {

    private UserRepositoryJ ur;

    public UserAPIManagement(String url) {
        ur = UserRepositoryJ.getInstance(url);
    }

    @Override
    public void login(String id, String pass, UserResponse userResponse) {
        ur.login(id, pass, userResponse);
    }

    @Override
    public void registry(String name, String email, String pass, UserResponse userResponse) {

    }
}
