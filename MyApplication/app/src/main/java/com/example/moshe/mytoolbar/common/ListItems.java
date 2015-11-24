package com.example.moshe.mytoolbar.common;

/**
 * Created by moshe on 14-11-15.
 */
public class ListItems {
    //define var
    private String text_task;

    /**
     * constructor
     * @param text_task
     */
    public ListItems(String text_task) {
        this.text_task = text_task;
    }

    /**
     * ListItems getter
     * @return - task string
     */
    public String getText_task() {
        return text_task;
    }

    /**
     * ListItems setter
     * @param text_task
     */
    public void setText_task(String text_task) {
        this.text_task = text_task;
    }
}
