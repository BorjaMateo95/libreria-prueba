package com.example.prueba;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseStorageCallback {

    void onCreate(SQLiteDatabase sqLiteDatabase);
    void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion);
}
