package com.example.mindrixa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicialización de vistas
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        Button registerButton = findViewById(R.id.registerButton);

        // Inicialización del helper de base de datos
        dbHelper = new DatabaseHelper(this);

        // Acción para el botón de registro
        registerButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            // Validación de formato de correo
            if (!email.contains("@") || !email.endsWith(".com")) {
                Toast.makeText(this, "Correo no válido. Debe contener '@' y terminar en '.com'", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validación de coincidencia de contraseñas
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                return;
            }

            // Registro en la base de datos
            boolean isRegistered = dbHelper.registerUser(name, email, password);
            if (isRegistered) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error en el registro, email ya registrado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
