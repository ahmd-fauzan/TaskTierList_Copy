package com.example.tasktierlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder> {
    private List<Task> taskList;
    Context context;

    class SubItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvTaskList;
        TextView tvMatakuliah;

        SubItemViewHolder(View view){
            super(view);
            tvTaskList = view.findViewById(R.id.task);
            tvMatakuliah = view.findViewById(R.id.title);
        }
    }

    SubItemAdapter (List<Task> taskList, Context context){
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubItemAdapter.SubItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_items, parent, false);

        return new SubItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemAdapter.SubItemViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.tvTaskList.setText(task.getTaskTitle());
        holder.tvMatakuliah.setText(task.getMatakuliah());
        if(task.getDifficult() == 1)
            holder.tvMatakuliah.setBackgroundResource(R.drawable.green_icon);
        else if(task.getDifficult() == 2)
            holder.tvMatakuliah.setBackgroundResource(R.drawable.yellow_icon);
        else
            holder.tvMatakuliah.setBackgroundResource(R.drawable.red_icon);

        holder.tvMatakuliah.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(task != null){
                    Intent intent = new Intent(context, DetailTaskActivity.class);
                    intent.putExtra("Task", task);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
