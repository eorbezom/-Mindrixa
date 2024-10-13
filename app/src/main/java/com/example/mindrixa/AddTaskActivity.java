package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText taskNameEditText;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Conectar vistas
        taskNameEditText = findViewById(R.id.taskNameEditText);
        datePicker = findViewById(R.id.datePicker);

        // Botón de seleccionar hora
        Button selectTimeButton = findViewById(R.id.selectTimeButton);
        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a la actividad de seleccionar hora
                Intent intent = new Intent(AddTaskActivity.this, SelectTimeActivity.class);
                startActivity(intent);
            }
        });

        // Botón de guardar
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardar datos o realizar las acciones correspondientes
                // Puedes obtener la fecha seleccionada con datePicker
                // y el nombre de la tarea con taskNameEditText.getText().toString()

                // Volver a la actividad anterior
                finish();
            }
        });

        // Botón de atrás
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a la actividad anterior
                finish();
            }
        });
    }
}
