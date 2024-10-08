package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView; // Agrega esto si no está presente
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Asegúrate de que el nombre del layout sea correcto

        // Inicializa la imagen si necesitas hacer algo con ella
        ImageView welcomeImageView = findViewById(R.id.welcomeImageView); // Asegúrate de que el ID sea correcto

        Button myButton = findViewById(R.id.myButton); // Asegúrate de que el ID sea correcto
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambia esto a la actividad que deseas iniciar
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
