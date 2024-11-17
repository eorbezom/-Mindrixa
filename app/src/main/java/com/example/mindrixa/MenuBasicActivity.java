package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.control.RespirarActivity;

public class MenuBasicActivity extends AppCompatActivity {

    private Button timeManagementButton;
    private Button emotionalControlButton;
    private Button communityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basic);

        timeManagementButton = findViewById(R.id.option_1_button);
        emotionalControlButton = findViewById(R.id.option_2_button);
        communityButton = findViewById(R.id.option_3_button);

        // Configurar el botón de gestión del tiempo
        timeManagementButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuBasicActivity.this, TaskManagementActivity.class);
            startActivity(intent);
        });

        // Configurar el botón de control emocional
        emotionalControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de mantenimiento
                Intent intent = new Intent(MenuBasicActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Configurar el botón de comunidad
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuBasicActivity.this, ProximaActualizacionActivity.class);
                startActivity(intent);
            }
        });
    }
}
