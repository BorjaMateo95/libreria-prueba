package com.example.prueba;

public interface UserInterfaceSQL {
    void login(int id, String pass, QuerySQLCallback callback);
    void registry(String name, String email, String pass, QuerySQLCallback callback);
}
