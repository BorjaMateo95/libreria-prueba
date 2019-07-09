package com.example.prueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class DatabaseHelper extends SQLiteOpenHelper {

    private DatabaseStorageCallback databaseStorageCallback;

    public DatabaseHelper(Context context, String name,
            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name,
             int version, DatabaseStorageCallback databaseStorageCallback) {
        super(context, name, null, version);
        this.databaseStorageCallback = databaseStorageCallback;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        databaseStorageCallback.onCreate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        databaseStorageCallback.onUpgrade(sqLiteDatabase, oldVersion, oldVersion);
    }
}
