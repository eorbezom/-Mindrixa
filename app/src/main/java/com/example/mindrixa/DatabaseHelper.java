package com.example.mindrixa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasks.db";
    private static final String TASKS_TABLE = "tasks";
    private static final String USERS_TABLE = "users";

    // Columnas de la tabla "tasks"
    private static final String TASK_COL_1 = "id";
    private static final String TASK_COL_2 = "date";
    private static final String TASK_COL_3 = "time";
    private static final String TASK_COL_4 = "comment";

    // Columnas de la tabla "users"
    private static final String USER_COL_1 = "id";
    private static final String USER_COL_2 = "name";
    private static final String USER_COL_3 = "email";
    private static final String USER_COL_4 = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear tabla "tasks"
        db.execSQL("CREATE TABLE " + TASKS_TABLE + " (" +
                TASK_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TASK_COL_2 + " TEXT, " +
                TASK_COL_3 + " TEXT, " +
                TASK_COL_4 + " TEXT)");

        // Crear tabla "users"
        db.execSQL("CREATE TABLE " + USERS_TABLE + " (" +
                USER_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_COL_2 + " TEXT, " +
                USER_COL_3 + " TEXT UNIQUE, " +  // `email` debe ser único
                USER_COL_4 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TASKS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);
    }

    // Métodos para gestionar tareas
    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TASK_COL_2, task.getDate());
        contentValues.put(TASK_COL_3, task.getTime());
        contentValues.put(TASK_COL_4, task.getComment());
        db.insert(TASKS_TABLE, null, contentValues);
        db.close();
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TASKS_TABLE, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String time = cursor.getString(2);
            String comment = cursor.getString(3);
            taskList.add(new Task(id, comment, date, time));
        }
        cursor.close();
        db.close();
        return taskList;
    }

    public boolean deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TASKS_TABLE, "id = ?", new String[]{String.valueOf(id)});
        db.close();
        return result > 0;
    }

    // Métodos para gestionar usuarios
    public boolean isEmailRegistered(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USERS_TABLE + " WHERE " + USER_COL_3 + " = ?", new String[]{email});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }

    public boolean registerUser(String name, String email, String password) {
        // Primero, verificar si el correo ya está registrado
        if (isEmailRegistered(email)) {
            Log.d("DatabaseHelper", "registerUser - Email ya registrado.");
            return false;  // El correo ya está en uso
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_COL_2, name);
        contentValues.put(USER_COL_3, email);
        contentValues.put(USER_COL_4, password);

        long result = db.insert(USERS_TABLE, null, contentValues);
        db.close();
        return result != -1;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USERS_TABLE + " WHERE email = ? AND password = ?",
                new String[]{email, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }

    public boolean updatePassword(String email, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_COL_4, newPassword);

        int result = db.update(USERS_TABLE, contentValues, "email = ?", new String[]{email});
        db.close();
        return result > 0;
    }

    // Método para obtener el nombre del usuario
    public String getUserName(String email) {
        String userName = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + USER_COL_2 + " FROM " + USERS_TABLE + " WHERE " + USER_COL_3 + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email});

        if (cursor.moveToFirst()) {
            userName = cursor.getString(0); // Suponiendo que el nombre está en la primera columna
        }
        cursor.close();
        db.close();
        return userName;
    }
}
