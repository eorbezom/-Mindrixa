package com.example.mindrixa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PasswordRecoveryActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText emailEditText, newPasswordEditText, confirmNewPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);

        emailEditText = findViewById(R.id.emailEditText);
        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        confirmNewPasswordEditText = findViewById(R.id.confirmNewPasswordEditText);
        Button resetPasswordButton = findViewById(R.id.resetPasswordButton);

        dbHelper = new DatabaseHelper(this);

        resetPasswordButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String newPassword = newPasswordEditText.getText().toString();
            String confirmNewPassword = confirmNewPasswordEditText.getText().toString();

            if (newPassword.equals(confirmNewPassword)) {
                boolean isUpdated = dbHelper.updatePassword(email, newPassword);
                if (isUpdated) {
                    Toast.makeText(this, "Contraseña actualizada", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Correo no encontrado", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
