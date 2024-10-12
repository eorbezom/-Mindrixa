package com.example.mindrixa;

public class Task {
    private String taskName;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public Task(String taskName, int day, int month, int year, int hour, int minute) {
        this.taskName = taskName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    // Getters y Setters
    public String getTaskName() {
        return taskName;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
