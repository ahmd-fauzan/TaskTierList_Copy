package com.example.tasktierlist;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DetailTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        DetailTaskFragment fragment = new DetailTaskFragment();

        Task task = getIntent().getParcelableExtra("Task");

        Bundle bundle = new Bundle();
        bundle.putParcelable("detailTask", task);


        fragment.setArguments(bundle);

        if(task != null){
            ft.replace(R.id.detailTaskActivity, fragment);
            ft.commit();
        }

    }
}
