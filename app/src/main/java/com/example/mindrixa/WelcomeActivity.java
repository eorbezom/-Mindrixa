package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Asegúrate de que el nombre del layout sea correcto

        // Inicializa la imagen y la animación
        ImageView welcomeImageView = findViewById(R.id.welcomeImageView);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        welcomeImageView.startAnimation(fadeInAnimation);

        // Configura el botón y su listener
        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambia esto a la actividad que deseas iniciar
                Intent intent = new Intent(WelcomeActivity.this, InicioActivity.class);
                startActivity(intent);
            }
        });
    }
}
