package com.example.prueba;

import android.database.Cursor;

import java.lang.reflect.Array;

public interface DatabaseStorageInterface {

    void initDatabase(String name, int version, DatabaseStorageCallback callback);
    boolean removeDatabase(String name);
    Cursor executeQuery(String query, String[] array);
    void executeSQL(String sql, String uno, String dos, String tres);
}
