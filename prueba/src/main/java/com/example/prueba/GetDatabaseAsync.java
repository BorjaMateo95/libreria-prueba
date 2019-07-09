package com.example.prueba;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;

public class GetDatabaseAsync extends AsyncTask<Void, Void, UserJ> {

    private QuerySQLCallback callback;
    private DatabaseStorageInterface databaseStorageInterface;
    private UserJ userJ;

    private String USER_TABLE = "user_table";

    public GetDatabaseAsync(QuerySQLCallback callback, DatabaseStorageInterface databaseStorageInterface,
            UserJ userJ) {
        this.callback = callback;
        this.databaseStorageInterface = databaseStorageInterface;
        this.userJ = userJ;
    }


    @Override
    protected UserJ doInBackground(Void... voids) {
        try {
            Cursor cursor = databaseStorageInterface.executeQuery(
                    "SELECT * FROM " + USER_TABLE + " WHERE email='" + userJ.getLogin() + "' " +
                            "AND password='" + userJ.getId() + "'", null);
            if (cursor.moveToFirst()) {
                return new UserJ(Integer.parseInt(cursor.getString(0)), cursor.getString(2), cursor.getString(3),
                        cursor.getString(3));
            }

        } catch (SQLiteException e) {
            return null;
        }

        return null;
    }

    @Override
    protected void onPostExecute(UserJ userJ) {
        super.onPostExecute(userJ);
        if (userJ != null) {
            callback.onSuccess(userJ);
        }else{
            callback.onFailure("Usuario o contraseña incorrecto");
        }
    }
}

