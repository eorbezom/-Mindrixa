package com.example.mindrixa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> tasks;
    private OnTaskClickListener listener;

    public interface OnTaskClickListener {
        void onTaskClick(Task task);
    }

    public TaskAdapter(ArrayList<Task> tasks, OnTaskClickListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.bind(task, listener);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskCommentTextView;
        TextView taskDateTextView;
        TextView taskTimeTextView;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskCommentTextView = itemView.findViewById(R.id.taskCommentTextView);
            taskDateTextView = itemView.findViewById(R.id.taskDateTextView);
            taskTimeTextView = itemView.findViewById(R.id.taskTimeTextView);
        }

        public void bind(final Task task, final OnTaskClickListener listener) {
            taskCommentTextView.setText(task.getComment());
            taskDateTextView.setText(task.getDate());
            taskTimeTextView.setText(task.getTime());

            itemView.setOnClickListener(v -> listener.onTaskClick(task));
        }
    }
}
