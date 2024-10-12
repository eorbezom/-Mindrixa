package com.example.mindrixa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = taskList.get(position);
        holder.taskNameTextView.setText(currentTask.getTaskName());
        holder.taskDateTextView.setText(currentTask.getDay() + "/" + (currentTask.getMonth() + 1) + "/" + currentTask.getYear());
        holder.taskTimeTextView.setText(currentTask.getHour() + ":" + String.format("%02d", currentTask.getMinute()));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView taskNameTextView;
        public TextView taskDateTextView;
        public TextView taskTimeTextView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskNameTextView = itemView.findViewById(R.id.taskNameTextView);
            taskDateTextView = itemView.findViewById(R.id.taskDateTextView);
            taskTimeTextView = itemView.findViewById(R.id.taskTimeTextView);
        }
    }
}
