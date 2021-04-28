package com.example.tasktierlist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    private List<Tier> tierList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Context context;

    public ItemAdapter(List<Tier> tierList)
    {
        this.tierList = tierList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTierTitle;
        RecyclerView rvTask;

        public MyViewHolder (View view){
            super(view);
            tvTierTitle = view.findViewById(R.id.tier);
            rvTask = view.findViewById(R.id.rv_sub_item);
            context = view.getContext();
        }
    }
    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        Tier tier = tierList.get(position);
        holder.tvTierTitle.setText(tier.getTitle());

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.rvTask.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        layoutManager.setInitialPrefetchItemCount(tier.getTaskList().size());

        SubItemAdapter subItemAdapter = new SubItemAdapter(tier.getTaskList(), context);
        holder.rvTask.setLayoutManager(layoutManager);
        holder.rvTask.setAdapter(subItemAdapter);
        holder.rvTask.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return tierList.size();
    }
}
