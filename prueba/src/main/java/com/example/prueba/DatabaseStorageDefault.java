package com.example.prueba;

import android.content.Context;
import android.database.Cursor;

public class DatabaseStorageDefault implements DatabaseStorageInterface {

    private DatabaseHelper databaseHelper;
    private Context context;


    public DatabaseStorageDefault(Context context) {
        this.context = context;
    }

    @Override
    public void initDatabase(String name, int version, DatabaseStorageCallback callback) {
        databaseHelper = new DatabaseHelper(context, name, version, callback);
    }

    @Override
    public boolean removeDatabase(String name) {
        return true;
    }

    @Override
    public Cursor executeQuery(String query, String[] array) {
        return databaseHelper.getReadableDatabase().rawQuery(query, array);
    }

    @Override
    public void executeSQL(String sql, String uno, String dos, String tres) {
        databaseHelper.getWritableDatabase().execSQL(sql);
        databaseHelper.close();
    }
}
