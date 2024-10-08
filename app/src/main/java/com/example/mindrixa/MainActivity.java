package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Redirige al usuario a la pantalla de bienvenida (WelcomeActivity)
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        startActivity(intent);
        finish(); // Cierra MainActivity para que el usuario no pueda volver con el botón de atrás
    }
}
