package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Pantalla1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        Button btnOpcion1 = findViewById(R.id.btnOpcion1);
        Button btnOpcion2 = findViewById(R.id.btnOpcion2);
        ImageButton btnRetroceder = findViewById(R.id.btnRetroceder);

        btnOpcion1.setOnClickListener(v -> abrirSiguientePantalla());
        btnOpcion2.setOnClickListener(v -> abrirSiguientePantalla());

        btnRetroceder.setOnClickListener(v -> finish());
    }

    private void abrirSiguientePantalla() {
        Intent intent = new Intent(this, Pantalla2Activity.class);
        startActivity(intent);
    }
}