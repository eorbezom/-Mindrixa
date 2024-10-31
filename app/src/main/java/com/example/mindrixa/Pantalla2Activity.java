package com.example.mindrixa; // Cambia esto por el nombre de tu paquete

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Pantalla2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2); // Carga el layout de la primera ventana

        // Referencias a los botones
        Button btnOpcion3 = findViewById(R.id.btnOpcion3);
        Button btnOpcion4 = findViewById(R.id.btnOpcion4);
        Button btnOpcion6 = findViewById(R.id.btnOpcion6);

        // Configura el intent para cada botón
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pantalla2Activity.this, ProximaActualizacionActivity.class);
                startActivity(intent);
            }
        };

        btnOpcion3.setOnClickListener(listener);
        btnOpcion4.setOnClickListener(listener);
        btnOpcion6.setOnClickListener(listener);
    }
}
