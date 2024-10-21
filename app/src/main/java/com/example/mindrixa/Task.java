package com.example.mindrixa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String comment;
    private String date; // Formato: "YYYY-MM-DD"
    private String time; // Formato: "HH:MM"

    // Constructor
    public Task(String comment, String date, String time) {
        this.comment = comment;
        this.date = date;
        this.time = time;
    }

    // Getters
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
        // Combinar fecha y hora en un solo String
        String dateTimeString = date + " " + time;

        // Definir el formato de la fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Convertir el String a LocalDateTime
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
