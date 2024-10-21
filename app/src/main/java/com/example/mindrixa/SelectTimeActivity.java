package com.example.mindrixa;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class SelectTimeActivity extends AppCompatActivity {

    private TextView timeTextView;
    private Button saveButton, cancelButton;
    private String selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        timeTextView = findViewById(R.id.timeTextView);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        // Selección de hora
        timeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        // Guardar la hora seleccionada
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTime();
            }
        });

        // Cancelar la selección
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad
            }
        });
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, selectedHour, selectedMinute) -> {
                    selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                    timeTextView.setText(selectedTime);
                }, hour, minute, true);
        timePickerDialog.show();
    }

    private void saveTime() {
        // Retornar la hora seleccionada a la actividad anterior
        Intent intent = new Intent();
        intent.putExtra("time", selectedTime);
        setResult(RESULT_OK, intent);
        finish();
    }
}
