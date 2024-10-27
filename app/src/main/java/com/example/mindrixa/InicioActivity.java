package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // Botón para continuar sin iniciar sesión
        Button continueButton = findViewById(R.id.continue_button);

        // Redirige al menú principal
        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(InicioActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        // Botón para ingresar con cuenta (puedes añadir la lógica de autenticación aquí)
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> {
            // Aquí iría la lógica de login
        });
    }
}
