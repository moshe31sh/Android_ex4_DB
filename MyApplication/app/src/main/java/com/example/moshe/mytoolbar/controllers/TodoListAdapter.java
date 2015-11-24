package com.example.moshe.mytoolbar.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moshe.mytoolbar.common.ListItems;
import com.example.moshe.mytoolbar.R;

import java.util.List;


/**
 * Created by moshe on 14-11-15.
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

//define vars
    private List<ListItems> listItems;

    public TodoListAdapter(List<ListItems> listItems) {
        this.listItems = listItems;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list,parent,false);
        ViewHolder viewHolder = new  ViewHolder(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItems item  = listItems.get(position);
        holder.mTodo_list.setText(item.getText_task());
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTodo_list;
        Button mdDne_button;

        public ViewHolder(final View itemView) {
            super(itemView);

            mTodo_list = (TextView)  itemView.findViewById(R.id.text_task);
            mdDne_button = (Button) itemView.findViewById(R.id.done_task_button);
            /**
             *  I will need to develop it on next ex
             */
            mdDne_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "click", Toast.LENGTH_LONG).show();

                }
            });
        }
    }
}
