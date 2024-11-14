package com.example.mindrixa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "UserPrefs";
    private static final String USER_NAME_KEY = "UserName";

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
        ImageView btnAtras = findViewById(R.id.imageView12);

        // Obtener el nombre del usuario desde SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(USER_NAME_KEY, null);

        // Verificar si el nombre de usuario está presente
        if (userName != null && !userName.isEmpty()) {
            // Si el nombre está presente, mostrar saludo con el nombre del usuario
            String saludo = "¡Bien, " + userName + "!" + "\n¡ tenemos cosas que hacer!";
            userNameTextView.setText(saludo);  // Establecer el saludo en la TextView
        } else {
            // Si el nombre no está presente, mostrar un saludo genérico
            String saludo = "¡Trabajemos !" + "\n¡con lo que quedamos";
            userNameTextView.setText(saludo);  // Mostrar saludo genérico
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

        btnAtras.setOnClickListener(v -> pantallaAnterior());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recargar tareas cuando la actividad se reanuda
        taskList.clear();
        taskList.addAll(databaseHelper.getAllTasks());
        taskAdapter.notifyDataSetChanged();
    }
    private  void pantallaAnterior(){
        Intent intent= new Intent(TaskManagementWithUserActivity.this, MenuActivity.class);
        startActivity(intent);
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
