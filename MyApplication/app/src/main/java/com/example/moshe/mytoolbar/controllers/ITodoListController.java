package com.example.moshe.mytoolbar.controllers;

import com.example.moshe.mytoolbar.common.ListItems;

import java.util.List;

/**
 * Created by moshe on 14-11-15.
 */
public interface ITodoListController {

    List<ListItems> getTodoList();

    /**
     * this method receive list item and set it on the recycle view
     * @param item
     */
    void addItemToTodoList(ListItems item);
}
