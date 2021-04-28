package com.example.tasktierlist;

import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyTaskFragment extends Fragment {

    TaskViewModel taskViewModel;
    Application application;

    public MyTaskFragment(Application application) {
        // Required empty public constructor
        this.application = application;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_my_task, container, false);

        taskViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(application)).get(TaskViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        taskViewModel.getAllTasks().observe(this, tasks -> {
            // Update the cached copy of the words in the adapter
            RecyclerView rvItem = view.findViewById(R.id.rv_item);
            ItemAdapter itemAdapter = new ItemAdapter(buildItemList(tasks));
            rvItem.setAdapter(itemAdapter);
            rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        });

        return view;
    }

    private List<Tier> buildItemList(List<Task> taskList) {
        List<Tier> tierList = new ArrayList<>();

        List<Task> sTier = new ArrayList<>();
        List<Task> aTier = new ArrayList<>();
        List<Task> bTier = new ArrayList<>();

        for (Task t : taskList) {
            if(t.getDeadline() <= 1){
                sTier.add(t);
            }

            else if(t.getDeadline() <= 3){
                aTier.add(t);
            }

            else
                bTier.add(t);
        }
        tierList.add(new Tier("S", sTier));
        tierList.add(new Tier("A", aTier));
        tierList.add(new Tier("B", bTier));

        return tierList;
    }
}