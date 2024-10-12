package com.example.mindrixa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.DatePicker;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText taskNameEditText;
    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Inicializar DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Conectar las vistas con el layout XML
        taskNameEditText = findViewById(R.id.taskNameEditText);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        // Configurar el TimePicker para el formato de 24 horas
        timePicker.setIs24HourView(true);

        // Botón de guardar
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados
                String taskName = taskNameEditText.getText().toString();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                // Cambiar los métodos según la API de Android
                int hour = timePicker.getHour();   // Para versiones recientes de Android
                int minute = timePicker.getMinute();  // Para versiones recientes de Android

                // Crear nueva tarea y guardarla en la base de datos
                Task newTask = new Task(taskName, day, month, year, hour, minute);
                databaseHelper.addTask(newTask);

                // Regresar a la pantalla de gestión de tareas
                finish();
            }
        });
    }
}
