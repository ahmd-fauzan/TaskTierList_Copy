package com.example.tasktierlist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository taskRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private final LiveData<List<Task>> taskList;

    public TaskViewModel(Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
        taskList = taskRepository.getAllWords();
    }

    LiveData<List<Task>> getAllTasks() {
        return taskList;
    }

    void insert(Task task) {
        taskRepository.insert(task);
    }
}
