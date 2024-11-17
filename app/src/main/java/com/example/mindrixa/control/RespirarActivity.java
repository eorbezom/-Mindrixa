package com.example.mindrixa.control;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.R;

import java.util.Locale;

public class RespirarActivity extends AppCompatActivity {

    private Spinner spinnerMinutos, spinnerSegundos;
    private Button btnComenzar;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respiracion);

        // Inicializar vistas
        spinnerMinutos = findViewById(R.id.etMinutos);
        spinnerSegundos = findViewById(R.id.etSegundos);
        btnComenzar = findViewById(R.id.btnComenzar);

        // Configurar adaptadores para los Spinners
        configurarSpinner(spinnerMinutos, 99); // Minutos de 0 a 99
        configurarSpinner(spinnerSegundos, 59); // Segundos de 0 a 59

        // Configurar TextToSpeech
        textToSpeech = new TextToSpeech(this, new OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    // Configurar idioma español latino
                    int result = textToSpeech.setLanguage(new Locale("es", "ES")); // Español de México como ejemplo
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(RespirarActivity.this, "Idioma no soportado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Botón para comenzar
        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minutosSeleccionados = Integer.parseInt(spinnerMinutos.getSelectedItem().toString());
                int segundosSeleccionados = Integer.parseInt(spinnerSegundos.getSelectedItem().toString());

                if (minutosSeleccionados == 0 && segundosSeleccionados == 0) {
                    Toast.makeText(RespirarActivity.this, "Configura un tiempo válido antes de continuar", Toast.LENGTH_SHORT).show();
                } else {
                    // Hablar el mensaje con idioma configurado
                    textToSpeech.speak("Muy bien empecemos a respirar, pero ahora solo escucharas la musica que le gusta a Desarrollador jr Ermenigildo orbezo, con cariño para su equipo 3 de modelo de negocios, dale play el boton por favo ", TextToSpeech.QUEUE_FLUSH, null, null);

                    // Ir a la siguiente actividad con el tiempo configurado
                    Intent intent = new Intent(RespirarActivity.this, CronometroActivity.class);
                    intent.putExtra("MINUTOS", minutosSeleccionados);
                    intent.putExtra("SEGUNDOS", segundosSeleccionados);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * Configura un Spinner con valores del 0 hasta el máximo especificado.
     *
     * @param spinner El Spinner a configurar
     * @param max     El valor máximo (inclusive)
     */
    private void configurarSpinner(Spinner spinner, int max) {
        String[] valores = new String[max + 1];
        for (int i = 0; i <= max; i++) {
            valores[i] = String.format("%02d", i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, valores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
