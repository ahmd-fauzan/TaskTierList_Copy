package com.example.tasktierlist;

import java.util.List;

public class Tier {
    private String title;
    private List<Task> taskList;

    Tier (String title, List<Task> taskList){
        this.title = title;
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
