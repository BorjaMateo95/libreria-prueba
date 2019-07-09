package com.example.prueba;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseManager {

    private String TEXT_TYPE = " TEXT";
    private String INT_TYPE = " INTEGER";
    private String PRIMARY_KEY = " PRIMARY KEY AUTOINCREMENT ";
    private String USER_TABLE = "user_table";
    private String NOT_NULL_TYPE = " NOT NULL";
    private String  COMMA_SEP = ",";

    private DatabaseStorageInterface databaseStorageInterface;
    private String dbName;
    private int version;

    private String SQL_CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + USER_TABLE + " ("
            + "_id " + INT_TYPE + PRIMARY_KEY + COMMA_SEP
            + "name" + TEXT_TYPE + NOT_NULL_TYPE + COMMA_SEP
            + "email" + TEXT_TYPE + NOT_NULL_TYPE + COMMA_SEP
            + "password" + TEXT_TYPE + NOT_NULL_TYPE + ");";

    private String  SQL_DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + USER_TABLE;

    public DatabaseManager(DatabaseStorageInterface databaseStorageInterface,
            String dbName, int version) {
        this.databaseStorageInterface = databaseStorageInterface;
        this.dbName = dbName;
        this.version = version;

    }

    private DatabaseStorageCallback callback = new DatabaseStorageCallback() {
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            createAllTables(sqLiteDatabase);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            updateDB(sqLiteDatabase, oldVersion, newVersion);
        }

        private void createAllTables(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        }

        private void deleteAllTables(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(SQL_DELETE_USER_TABLE);
        }

        private void updateDB(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            if (newVersion > oldVersion) {
                deleteAllTables(sqLiteDatabase);
                createAllTables(sqLiteDatabase);
            }else{
                Log.e(DatabaseManager.class.getCanonicalName(), "Error updating DB");
            }
        }
    };

    public void initDB() {
        databaseStorageInterface.initDatabase(dbName, version, callback);
    }

    public void putDatabase(UserJ userJ, QuerySQLCallback callback) {
        PutDatabaseAsync putDatabaseAsync = new PutDatabaseAsync(callback, databaseStorageInterface, userJ);
        putDatabaseAsync.execute();
    }

    public void getDatabase(UserJ userJ, QuerySQLCallback callback) {
        GetDatabaseAsync getDatabaseAsync = new GetDatabaseAsync(callback, databaseStorageInterface, userJ);
        getDatabaseAsync.execute();
    }


}
