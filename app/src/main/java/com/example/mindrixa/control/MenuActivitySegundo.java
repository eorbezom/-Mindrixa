package com.example.mindrixa.control;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.ProximaActualizacionActivity;
import com.example.mindrixa.R;
import com.example.mindrixa.SaludoHelper;
import com.example.mindrixa.TaskManagementWithUserActivity;
import com.example.mindrixa.encuesta.Pantalla1Activity;

public class MenuActivitySegundo extends AppCompatActivity {

    private TextView userNameTextView;
    private Button timeManagementButton;
    private Button emotionalControlButton;
    private Button communityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inicializar el TextView y los botones
        userNameTextView = findViewById(R.id.user_name); // Cambia a user_name
        timeManagementButton = findViewById(R.id.option_1_button); // Cambia a option_1_button
        emotionalControlButton = findViewById(R.id.option_2_button); // Cambia a option_2_button
        communityButton = findViewById(R.id.option_3_button); // Cambia a option_3_button

        // Obtener el nombre del usuario desde SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MindrixaPrefs", MODE_PRIVATE);
        String userName = sharedPreferences.getString("USER_NAME", "");

        // Verificar si el nombre de usuario es válido
        if (userName != null && !userName.isEmpty()) {
            // Obtener el saludo dinámico con el nombre del usuario
            String saludo = SaludoHelper.obtenerSaludoPersonalizado(userName, this);
            userNameTextView.setText(saludo);  // Establecer el saludo en el TextView
        } else {
            // Si el nombre de usuario no es válido, mostrar un mensaje de error
            userNameTextView.setText("El nombre de usuario no se recibió correctamente");
        }

        // Configurar el botón de gestión del tiempo
        timeManagementButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivitySegundo.this, TaskManagementWithUserActivity.class);
            startActivity(intent);
        });

        // DASHBOARD
        emotionalControlButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivitySegundo.this, DasbordActivity.class);
            startActivity(intent);
        });

        // Configurar el botón de comunidad
        communityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivitySegundo.this, ProximaActualizacionActivity.class);
            startActivity(intent);
            // Mostrar mensaje de mantenimiento
            Toast.makeText(MenuActivitySegundo.this, "Estamos en mantenimiento, nos vemos pronto.", Toast.LENGTH_SHORT).show();
        });
    }
}
