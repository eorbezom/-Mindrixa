package com.example.mindrixa;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
public class DatabaseHelper {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public DatabaseHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("task_db", Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void addTask(Task task) {
        ArrayList<Task> taskList = getAllTasks();
        taskList.add(task);
        saveTasks(taskList);
    }

    public ArrayList<Task> getAllTasks() {
        String json = sharedPreferences.getString("tasks", null);
        Type type = new TypeToken<ArrayList<Task>>() {}.getType();
        ArrayList<Task> taskList = gson.fromJson(json, type);
        return taskList == null ? new ArrayList<>() : taskList;
    }

    private void saveTasks(ArrayList<Task> taskList) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = gson.toJson(taskList);
        editor.putString("tasks", json);
        editor.apply();
    }

}
