package com.example.mindrixa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> taskList;

    public TaskAdapter(ArrayList<Task> taskList) {
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
        Task task = taskList.get(position);
        holder.taskDateTextView.setText(task.getDate());
        holder.taskTimeTextView.setText(task.getTime());
        holder.taskCommentTextView.setText(task.getComment());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskDateTextView;
        TextView taskTimeTextView;
        TextView taskCommentTextView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskDateTextView = itemView.findViewById(R.id.taskDateTextView);
            taskTimeTextView = itemView.findViewById(R.id.taskTimeTextView);
            taskCommentTextView = itemView.findViewById(R.id.taskCommentTextView);
        }
    }
}
