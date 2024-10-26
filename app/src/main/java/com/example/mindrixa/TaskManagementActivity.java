package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskManagementActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private TextView selectedTaskDate;
    private TextView selectedTaskTime;
    private TextView selectedTaskComment;
    private Task selectedTask; // Tarea seleccionada para eliminar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_management);

        // Inicializar vistas
        selectedTaskDate = findViewById(R.id.selectedTaskDate);
        selectedTaskTime = findViewById(R.id.selectedTaskTime);
        selectedTaskComment = findViewById(R.id.selectedTaskComment);

        // Inicializar base de datos y cargar tareas
        databaseHelper = new DatabaseHelper(this);
        taskList = databaseHelper.getAllTasks();

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.taskRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configurar el adaptador con el listener de clics
        taskAdapter = new TaskAdapter(taskList, new TaskAdapter.OnTaskClickListener() {
            @Override
            public void onTaskClick(Task task) {
                selectedTask = task; // Guardar la tarea seleccionada
                displayTaskDetails(task);
            }
        });
        recyclerView.setAdapter(taskAdapter);

        // Botón para añadir una nueva tarea
        Button addMoreTasksButton = findViewById(R.id.addMoreTasksButton);
        addMoreTasksButton.setOnClickListener(v -> {
            Intent intent = new Intent(TaskManagementActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        // Funcionalidad del botón de eliminar
        ImageButton deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(v -> {
            if (selectedTask != null) {
                databaseHelper.deleteTask(selectedTask.getId()); // Elimina de la base de datos
                taskList.remove(selectedTask); // Elimina de la lista
                taskAdapter.notifyDataSetChanged(); // Actualiza la vista
                selectedTask = null; // Reinicia la tarea seleccionada
                clearTaskDetails(); // Limpia los detalles mostrados
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recargar tareas cuando la actividad se reanuda
        taskList.clear();
        taskList.addAll(databaseHelper.getAllTasks());
        taskAdapter.notifyDataSetChanged();
    }

    private void displayTaskDetails(Task task) {
        selectedTaskDate.setText(task.getDate());
        selectedTaskTime.setText(task.getTime());
        selectedTaskComment.setText(task.getComment());
    }

    private void clearTaskDetails() {
        selectedTaskDate.setText("");
        selectedTaskTime.setText("");
        selectedTaskComment.setText("");
    }
}
