package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskManagementWithUserActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private TextView selectedTaskDate;
    private TextView selectedTaskTime;
    private TextView selectedTaskComment;
    private Task selectedTask; // Tarea seleccionada para eliminar
    private TextView userNameTextView; // Texto de saludo personalizado
    private ImageView userIcon; // Icono de usuario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_management_with_user);

        // Inicializar vistas
        selectedTaskDate = findViewById(R.id.selectedTaskDate);
        selectedTaskTime = findViewById(R.id.selectedTaskTime);
        selectedTaskComment = findViewById(R.id.selectedTaskComment);
        userNameTextView = findViewById(R.id.greetingText); // Cambiar a greetingText para el saludo
        userIcon = findViewById(R.id.userIcon);

        // Obtener el nombre de usuario desde el Intent
        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName != null && !userName.isEmpty()) {
            userNameTextView.setText("¿Qué haces hoy, " + userName + "?");
        }else {
            userNameTextView.setText("Bien seguimos con las agentas");
        }

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
            Intent intent = new Intent(TaskManagementWithUserActivity.this, AddNewTaskActivity.class);
            startActivity(intent);
        });

        // Botón para reprogramar tarea
        Button reprogramButton = findViewById(R.id.reprogramButton);
        reprogramButton.setOnClickListener(v -> {
            Intent intent = new Intent(TaskManagementWithUserActivity.this, AddNewTaskActivity.class);
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

        // Botón "Estoy listo" para iniciar actividad de temporizador
        Button readyButton = findViewById(R.id.readyButton);
        readyButton.setOnClickListener(v -> {
            Intent intent = new Intent(TaskManagementWithUserActivity.this, TimerActivity.class);
            startActivity(intent);
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
