package com.example.prueba;

import android.content.Context;

public class UserSQLiteManagement implements UserInterfaceSQL {

    private DatabaseManager databaseManager;
    private DatabaseStorageInterface databaseStorageInterface;

    public UserSQLiteManagement(Context context, String name, int version) {
        this.databaseStorageInterface = new DatabaseStorageDefault(context);
        databaseManager = new DatabaseManager(databaseStorageInterface, name, version);
        databaseManager.initDB();
    }

    @Override
    public void login(int id, String pass, QuerySQLCallback callback) {
        databaseManager.getDatabase(new UserJ(id, pass, "", ""), callback);
    }

    @Override
    public void registry(String name, String email, String pass, QuerySQLCallback callback) {
        databaseManager.putDatabase(new UserJ(name, email, pass), callback);
    }
}
