package com.example.tasktierlist;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class DetailTaskFragment extends Fragment {

    private TextView tvMatakuliah;
    private TextView tvTitle;
    private TextView tvDesc;
    private TextView tvDeadline;
    private TextView tvReference;
    private TextView tvSend;

    public DetailTaskFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detail_task, container, false);

        tvMatakuliah = view.findViewById(R.id.tvMatakuliah);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvDesc = view.findViewById(R.id.tvDesc);
        tvDeadline = view.findViewById(R.id.tvDeadline);
        tvReference = view.findViewById(R.id.tvRef);
        tvSend = view.findViewById(R.id.tvSend);

        Bundle bundle = getArguments();
        Task task = bundle.getParcelable("detailTask");

        setDetailInfo(task);

        return view;
    }

    public void setDetailInfo(Task task){
        tvMatakuliah.setText(task.getMatakuliah());
        tvTitle.setText(task.getTaskTitle());
        tvDesc.setText(task.getDesc());
        tvDeadline.setText(String.valueOf(task.getDeadline()));
        tvReference.setText(task.getReference());
        tvSend.setText(task.getLinkToSend());
    }
}
