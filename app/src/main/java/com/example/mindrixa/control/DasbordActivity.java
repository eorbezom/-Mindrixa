package com.example.mindrixa.control;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mindrixa.MenuActivity;
import com.example.mindrixa.ProximaActualizacionActivity;
import com.example.mindrixa.R;
import com.example.mindrixa.SaludoHelper;
import androidx.appcompat.app.AppCompatActivity;

public class DasbordActivity extends AppCompatActivity {

    private TextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasbord);

        userNameTextView = findViewById(R.id.user_name);

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

        // Inicializar los botones
        ImageView btnLeccion = findViewById(R.id.btnLeccion);
        ImageView btnCitas = findViewById(R.id.btnCitas);
        ImageView btnRespiracion = findViewById(R.id.btnRespiracion);
        ImageView btnDiario = findViewById(R.id.btnDiario);
        ImageView btnConsejos = findViewById(R.id.btnConsejos);
        ImageView btnMelodias = findViewById(R.id.btnMelodias);
        ImageView btnAlerta = findViewById(R.id.btnAlerta);

        ImageView btnHome = findViewById(R.id.iconHome);
        ImageView btnMeta = findViewById(R.id.iconMetas);

        // Configurar botones para redirigir a la pantalla de actualización
        btnLeccion.setOnClickListener(v -> pantallaDeActualizacion());
        btnCitas.setOnClickListener(v -> pantallaDeActualizacion());
        btnRespiracion.setOnClickListener(v -> pantallaRespirar());
        btnDiario.setOnClickListener(v -> pantallaDeActualizacion());
        btnConsejos.setOnClickListener(v -> pantallaDeActualizacion());
        btnMelodias.setOnClickListener(v -> pantallaDeActualizacion());
        btnAlerta.setOnClickListener(v -> pantallaDeActualizacion());



        // Navegación al Home y Metas
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(DasbordActivity.this, MenuActivitySegundo.class);
            startActivity(intent);
        });

        btnMeta.setOnClickListener(v -> {
            Intent intent = new Intent(DasbordActivity.this, ProximaActualizacionActivity.class);
            startActivity(intent);
        });
    }
    private void pantallaRespirar(){
        Intent intent=new Intent(DasbordActivity.this, RespirarActivity.class);
        startActivity(intent);

    }

    private void pantallaDeActualizacion() {
        Intent intent = new Intent(DasbordActivity.this, ProximaActualizacionActivity.class);
        startActivity(intent);
    }
}
