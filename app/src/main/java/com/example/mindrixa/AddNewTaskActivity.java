package com.example.mindrixa;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AddNewTaskActivity extends AppCompatActivity {

    private TextView selectedDateTextView;
    private TextView selectedTimeTextView;
    private EditText commentEditText;
    private Button selectDateButton;
    private Button selectTimeButton;
    private Button saveButton;
    private DatabaseHelper databaseHelper;

    private String selectedDate = "";
    private String selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        selectedTimeTextView = findViewById(R.id.selectedTimeTextView);
        commentEditText = findViewById(R.id.commentEditText);
        selectDateButton = findViewById(R.id.selectDateButton);
        selectTimeButton = findViewById(R.id.selectTimeButton);
        saveButton = findViewById(R.id.saveButton);
        databaseHelper = new DatabaseHelper(this);

        // Seleccionar fecha
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddNewTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        selectedDateTextView.setText("Fecha: " + selectedDate);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Seleccionar hora
        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddNewTaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTime = hourOfDay + ":" + (minute < 10 ? "0" + minute : minute);
                        selectedTimeTextView.setText("Hora: " + selectedTime);
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        // Guardar tarea
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentEditText.getText().toString();
                Task newTask = new Task(selectedDate, selectedTime, comment);
                databaseHelper.addTask(newTask);

                Intent intent = new Intent(AddNewTaskActivity.this, TaskManagementWithUserActivity.class);
                startActivity(intent);
                finish(); // Cierra la actividad actual
            }
        });
    }
}
