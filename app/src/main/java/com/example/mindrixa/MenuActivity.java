package com.example.mindrixa;

import android.content.Intent;  // Asegúrate de agregar esta importación
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Opción 1: Gestión de tiempo
        Button option1 = findViewById(R.id.option_1_button);
        option1.setOnClickListener(v -> {
            // Redirigir a la actividad de gestión de tareas
            Intent intent = new Intent(MenuActivity.this, TaskManagementActivity.class);
            startActivity(intent);
        });

        // Opción 2: Control emocional
        Button option2 = findViewById(R.id.option_2_button);
        option2.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            // Aquí puedes agregar la lógica para el control emocional
        });

        // Opción 3: Configuración
        Button option3 = findViewById(R.id.option_3_button);
        option3.setOnClickListener(v -> {
            Toast.makeText(MenuActivity.this, "Comunidad", Toast.LENGTH_SHORT).show();
            // Aquí puedes agregar la lógica de configuración
        });
    }
}
