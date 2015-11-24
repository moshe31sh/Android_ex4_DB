package com.example.moshe.mytoolbar.dbhandler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by moshe on 24-11-15.
 */
public class ToDoListDBHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database
    // version.
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "todolist.db";

    public ToDoListDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a table to hold the friends;
        final String SQL_CREATE_LOCATION_TABLE = "CREATE TABLE "
                + ListItemsDbContract.ListItemEntry.TABLE_NAME + " (" + ListItemsDbContract.ListItemEntry._ID
                + " INTEGER PRIMARY KEY," + ListItemsDbContract.ListItemEntry.TABLE_NAME
                + " TEXT NOT NULL  UNIQUE ON CONFLICT REPLACE)";
        db.execSQL(SQL_CREATE_LOCATION_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ListItemsDbContract.ListItemEntry.TABLE_NAME);
        onCreate(db);
    }
}
