package com.example.prueba;

public class UserJ {
    private int id;
    private String login;
    private String pass;
    private String email;

    public UserJ(int id, String name, String pass, String email) {
        this.id = id;
        this.login = name;
        this.pass = pass;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
