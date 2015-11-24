package com.example.moshe.mytoolbar.dbhandler;

import com.example.moshe.mytoolbar.common.ListItems;

import java.util.List;

/**
 * Created by moshe on 24-11-15.
 */
public interface IdataAcces {

   // User getUser(String userName, String password);

    List<ListItems> getAllItems();

    void removeItem(ListItems friend);

    ListItems addItem(ListItems friend);
}
