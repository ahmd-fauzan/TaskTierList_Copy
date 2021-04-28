package com.example.tasktierlist;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class AddTaskFragment extends Fragment {

    Button btnAddTask;

    private EditText etMatakuliah;
    private EditText etTitle;
    private EditText etDesc;
    private TextView etDeadline;
    private EditText etReference;
    private EditText etSend;

    public AddTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        btnAddTask = view.findViewById(R.id.btnAddTask);

        etMatakuliah = view.findViewById(R.id.etMatakuliah);
        etTitle = view.findViewById(R.id.etTitle);
        etDesc = view.findViewById(R.id.etDesc);
        etDeadline = view.findViewById(R.id.etDeadline);
        etReference = view.findViewById(R.id.etReference);
        etSend = view.findViewById(R.id.etSend);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.tasktierlist.MyTaskActivity");
                intent.putExtra("Task", addTask());
                startActivity(intent);
            }
        });

        etDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TampilTanggal();
            }
        });
        return view;
    }

    private Task addTask(){
        Task task = new Task();
        task.setMatakuliah(etMatakuliah.getText().toString());
        task.setTaskTitle(etTitle.getText().toString());
        task.setDesc(etDesc.getText().toString());
        task.setDeadline(Integer.parseInt(etDeadline.getText().toString()));
        task.setReference(etReference.getText().toString());
        task.setLinkToSend(etSend.getText().toString());

        return task;
    }

    public void TampilTanggal(){
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getFragmentManager(), "data");
        datePickerFragment.setOnDateClickListener(new DatePickerFragment.onDateClickListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String tahun = ""+datePicker.getYear();
                String bulan = ""+(datePicker.getMonth()+1);
                String hari = ""+datePicker.getDayOfMonth();
            }
        });
    }
}