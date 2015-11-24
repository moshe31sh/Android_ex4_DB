package com.example.moshe.mytoolbar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.moshe.mytoolbar.R;
import com.example.moshe.mytoolbar.common.DefineVars;

public class AddTaskTodoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_task_todo_list);

    }


    public  void OnClickCreateTaskButton(View view){
        String descriptionMsg = ((EditText) AddTaskTodoListActivity.this.findViewById(R.id.text_add_task)).getText().toString();
        Intent intent = new Intent();
        intent.putExtra("Description", descriptionMsg);
        setResult(DefineVars.PICK_CONTACT_REQUEST, intent);
        finish();

    }
}
