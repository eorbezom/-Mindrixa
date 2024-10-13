package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

public class SelectTimeActivity extends AppCompatActivity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        // Conectar TimePicker
        timePicker = findViewById(R.id.timePicker);

        // Configurar el formato de 24 horas en TimePicker programáticamente
        timePicker.setIs24HourView(true);

        // Botón de confirmar
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la hora seleccionada
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                // Enviar los datos de vuelta a la actividad anterior
                Intent intent = new Intent();
                intent.putExtra("selectedHour", hour);
                intent.putExtra("selectedMinute", minute);
                setResult(RESULT_OK, intent);
                finish();  // Cerrar la actividad
            }
        });

        // Botón de cancelar
        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la actividad sin devolver nada
                finish();
            }
        });
    }
}
