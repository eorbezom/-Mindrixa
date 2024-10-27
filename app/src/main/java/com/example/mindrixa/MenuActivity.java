package com.example.mindrixa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private TextView userNameTextView;
    private Button timeManagementButton;
    private Button emotionalControlButton;
    private Button communityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        userNameTextView = findViewById(R.id.user_name); // Cambia a user_name
        timeManagementButton = findViewById(R.id.option_1_button); // Cambia a option_1_button
        emotionalControlButton = findViewById(R.id.option_2_button); // Cambia a option_2_button
        communityButton = findViewById(R.id.option_3_button); // Cambia a option_3_button

        // Obtener el nombre de usuario desde las preferencias o de otra fuente
        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName != null && !userName.isEmpty()) {
            userNameTextView.setText("¡Hola, " + userName + "!");
        }

        // Configurar el botón de gestión del tiempo
        timeManagementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes iniciar la actividad de gestión de tiempo cuando esté lista
                Toast.makeText(MenuActivity.this, "Estamos en mantenimiento, nos vemos pronto.", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el botón de control emocional
        emotionalControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de mantenimiento
                Toast.makeText(MenuActivity.this, "Estamos en mantenimiento, nos vemos pronto.", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el botón de comunidad
        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de mantenimiento
                Toast.makeText(MenuActivity.this, "Estamos en mantenimiento, nos vemos pronto.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
