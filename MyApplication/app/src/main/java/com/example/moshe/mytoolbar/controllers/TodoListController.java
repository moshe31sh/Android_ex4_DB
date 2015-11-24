package com.example.moshe.mytoolbar.controllers;

import android.content.Context;
import android.util.Log;

import com.example.moshe.mytoolbar.common.ListItems;
import com.example.moshe.mytoolbar.dbhandler.DAO;
import com.example.moshe.mytoolbar.dbhandler.IdataAcces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moshe on 14-11-15.
 */
public class TodoListController implements ITodoListController {

    private List<ListItems> todoText;
    private IdataAcces dao;
    private Context context;
    public TodoListController(Context context) {

        this.todoText = new ArrayList<ListItems>();
        this.context = context;
        dao = DAO.getInstatnce(context.getApplicationContext());
    }

    /**
     *
     * @return list of items
     */
    @Override
    public List<ListItems> getTodoList() {
        try {
            return dao.getAllItems();
        }catch (Exception e){
            // in case of error, return empty list.
            return new ArrayList<ListItems>();
        }
    }

    /**
     * this method receive list item and set it on the recycle view
     *
     * @param item
     */
    @Override
    public void addItemToTodoList(ListItems item) {
        try {
            ListItems retItem =  dao.addItem(item);
            if(retItem == null) return;
            //update what ever it will be.
            invokeDataSourceChanged();
        } catch (Exception e) {
            Log.e("TodoListController", e.getMessage());
        }

    }

    public void removeItemToTodoList(ListItems item){
        try{
          dao.removeItem(item);
            invokeDataSourceChanged();
        }catch (Exception e){
            Log.e("TodoListController", e.getMessage());
        }
    }

    private void invokeDataSourceChanged() {

    }
}
