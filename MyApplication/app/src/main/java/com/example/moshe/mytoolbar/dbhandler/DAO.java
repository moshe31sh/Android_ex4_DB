package com.example.moshe.mytoolbar.dbhandler;

import android.content.Context;

import com.example.moshe.mytoolbar.common.ListItems;

import java.util.List;

/**
 * Created by moshe on 24-11-15.
 */
public class DAO implements IdataAcces {
    private static DAO instance;
    private Context context;


    private DAO(Context context) {
        this.context = context;
   //     dbHelper = new FriendsDBHelper(this.context);
    }

    public static DAO getInstatnce(Context context) {
        if (instance == null)
            instance = new DAO(context);
        return instance;
    }

    @Override
    public List<ListItems> getAllItems() {
        return null;
    }

    @Override
    public void removeItem(ListItems friend) {

    }

    @Override
    public ListItems addItem(ListItems friend) {
        return null;
    }
}
