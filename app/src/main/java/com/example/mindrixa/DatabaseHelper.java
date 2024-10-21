package com.example.mindrixa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tasks.db";
    private static final String TABLE_NAME = "tasks";
    private static final String COL_1 = "id";
    private static final String COL_2 = "date";
    private static final String COL_3 = "time";
    private static final String COL_4 = "comment";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, time TEXT, comment TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, task.getDate());
        contentValues.put(COL_3, task.getTime());
        contentValues.put(COL_4, task.getComment());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        while (cursor.moveToNext()) {
            String date = cursor.getString(1);
            String time = cursor.getString(2);
            String comment = cursor.getString(3);
            taskList.add(new Task(date, time, comment));
        }
        cursor.close();
        db.close();
        return taskList;
    }
}
