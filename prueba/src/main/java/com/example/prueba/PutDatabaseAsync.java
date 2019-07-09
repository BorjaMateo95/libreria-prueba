package com.example.prueba;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;

public class PutDatabaseAsync extends AsyncTask<Void, Void, Boolean> {

    private QuerySQLCallback callback;
    private DatabaseStorageInterface databaseStorageInterface;
    private UserJ userJ;

    private String USER_TABLE = "user_table";

    public PutDatabaseAsync(QuerySQLCallback callback, DatabaseStorageInterface databaseStorageInterface,
            UserJ userJ) {
        this.callback = callback;
        this.databaseStorageInterface = databaseStorageInterface;
        this.userJ = userJ;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            databaseStorageInterface.executeSQL("INSERT INTO " + USER_TABLE + " " +
                    "(name, email, password) " +
                            "VALUES (?,?,?)", userJ.getLogin(), userJ.getId()+"", userJ.getLogin());
        }catch (SQLiteException e) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        if (aBoolean) {
           callback.onSuccess(userJ);
        }else {
            callback.onFailure("Error en el registro");
        }
    }
}
