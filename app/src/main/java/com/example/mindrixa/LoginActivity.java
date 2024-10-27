package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        TextView forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        TextView registerTextView = findViewById(R.id.registerTextView);

        dbHelper = new DatabaseHelper(this);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (dbHelper.checkUser(email, password)) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                // Obtenemos el nombre del usuario desde la base de datos (modificar según tu método checkUser)
                String userName = dbHelper.getUserName(email);  // Suponiendo que tienes este método

                // Creamos un Intent para abrir MenuActivity y enviamos el nombre del usuario
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                intent.putExtra("USER_NAME", userName);  // Enviamos el nombre del usuario
                startActivity(intent);
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }

        });

        forgotPasswordTextView.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, PasswordRecoveryActivity.class));
        });

        registerTextView.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
