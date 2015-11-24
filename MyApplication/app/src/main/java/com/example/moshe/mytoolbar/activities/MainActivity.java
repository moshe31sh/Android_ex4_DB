package com.example.moshe.mytoolbar.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.moshe.mytoolbar.controllers.ITodoListController;
import com.example.moshe.mytoolbar.common.ListItems;
import com.example.moshe.mytoolbar.R;
import com.example.moshe.mytoolbar.controllers.TodoListAdapter;
import com.example.moshe.mytoolbar.controllers.TodoListController;

import com.example.moshe.mytoolbar.common.DefineVars;

public class MainActivity extends AppCompatActivity {
    //define vars
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ITodoListController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * find my toolbar id
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //By default, the action bar contains just the name of the app and an overflow menu
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        //create the controller.

        controller = new TodoListController(this);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        showList();
    }

    public void showList(){
//        for (int i = 0 ; i < 10 ; i++){
//            controller.addItemToTodoList(new ListItems("todo" + i));
//        }
      //  mAdapter = new TodoListAdapter(controller.getTodoList());
      //  mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Active specific item on tool bar
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_setting:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(this,"Setting.",Toast.LENGTH_SHORT).show();

                return true;
            case R.id.action_search:
                Toast.makeText(this,"Search.",Toast.LENGTH_SHORT).show();

                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
       // MenuItem favorite = menu.findItem(R.id.action_favorite);
        Toast.makeText(this, "onPrepareOptionsMenu", Toast.LENGTH_SHORT).show();
        return true;
    }



    public void changeMenuClick(View view) {
        Toast.makeText(this,"changeMenuClick",Toast.LENGTH_SHORT).show();
        //call invalidateOptionsMenu() to request that the system call onPrepareOptionsMenu()
        invalidateOptionsMenu();
    }

    /**
     * OnClickaddTaskButton. on click Add task button open new task activity to add more tasks
     */
    public void OnClickAddTaskButton(View view){
        Intent addTaskActivity = new Intent(view.getContext() , AddTaskTodoListActivity.class);
        startActivityForResult(addTaskActivity, DefineVars.PICK_CONTACT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == DefineVars.PICK_CONTACT_REQUEST){
            String descriptionMsg = data.getStringExtra("Description").toString();
            controller.addItemToTodoList(new ListItems(descriptionMsg));
            mAdapter.notifyDataSetChanged();

        }
    }

}
