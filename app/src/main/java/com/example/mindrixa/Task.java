package com.example.mindrixa;

public class Task {
    private String date;
    private String time;
    private String comment;

    public Task(String date, String time, String comment) {
        this.date = date;
        this.time = time;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getComment() {
        return comment;
    }
}
