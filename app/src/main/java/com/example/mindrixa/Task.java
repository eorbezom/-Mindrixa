package com.example.mindrixa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id; // Agregar ID para identificar la tarea
    private String comment;
    private String date; // Formato: "YYYY-MM-DD"
    private String time; // Formato: "HH:MM"

    // Constructor sin ID (para crear nuevas tareas sin especificar ID)
    public Task(String comment, String date, String time) {
        this.comment = comment;
        this.date = date;
        this.time = time;
    }

    // Constructor con ID (para tareas recuperadas de la base de datos)
    public Task(int id, String comment, String date, String time) {
        this.id = id;
        this.comment = comment;
        this.date = date;
        this.time = time;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // Método para obtener la fecha y hora como un objeto LocalDateTime
    public LocalDateTime getDateTime() {
        String dateTimeString = date + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
