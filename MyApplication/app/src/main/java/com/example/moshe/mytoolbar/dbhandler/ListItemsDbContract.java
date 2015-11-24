package com.example.moshe.mytoolbar.dbhandler;

import android.provider.BaseColumns;

/**
 * Defines table and column names for the friends database.
 */

public class ListItemsDbContract {
    
    /* Inner class that defines the table contents of the friends */
    public static final class ListItemEntry implements BaseColumns {

        // Table name
        public static final String TABLE_NAME = "todolist";

        public static final String COLUMN_ITEM = "todo";

       // public static final String COLUMN_FRIEND_PHONE_NUMBER = "friend_phone_number";

    }
}
