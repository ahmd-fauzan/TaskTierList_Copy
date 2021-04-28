package com.example.tasktierlist;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AddTaskActivity extends AppCompatActivity {
    TextView tvLabelTitle;

    androidx.appcompat.app.ActionBar actionBar;

    @SuppressLint("WrongConstant")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);

        //actionBar = getSupportActionBar();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvLabelTitle = findViewById(R.id.tvLabelTitle);
        tvLabelTitle.setText("Add Task");

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        AddTaskFragment fragment = new AddTaskFragment();

        ft.replace(R.id.activityAddTask, fragment);
        ft.commit();
    }
}
