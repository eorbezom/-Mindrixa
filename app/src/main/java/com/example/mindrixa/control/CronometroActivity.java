package com.example.mindrixa.control;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.R;

public class CronometroActivity extends AppCompatActivity {

    private TextView tvTiempo;
    private ImageButton btnIniciar;
    private int minutos, segundos;
    private CountDownTimer countDownTimer;
    private boolean cronometroCorriendo = false;
    private boolean audioReproduciendo = false; // Variable para controlar el estado del audio
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        tvTiempo = findViewById(R.id.tvTiempo);
        btnIniciar = findViewById(R.id.btnIniciar);

        // Obtener tiempo de la Intent
        minutos = getIntent().getIntExtra("MINUTOS", 0);
        segundos = getIntent().getIntExtra("SEGUNDOS", 0);

        // Inicializar el MediaPlayer para el audio
        mediaPlayer = MediaPlayer.create(this, R.raw.musica); // Asegúrate de que el archivo esté en res/raw
        actualizarTiempo();

        // Configurar el botón de iniciar/pausar
        btnIniciar.setOnClickListener(v -> {
            if (cronometroCorriendo) {
                pausarCronometro();
            } else {
                iniciarCronometro();
            }
        });
    }

    private void iniciarCronometro() {
        long tiempoTotal = (minutos * 60 + segundos) * 1000;

        // Iniciar el cronómetro
        countDownTimer = new CountDownTimer(tiempoTotal, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                minutos = (int) (millisUntilFinished / 60000);
                segundos = (int) (millisUntilFinished % 60000 / 1000);
                actualizarTiempo();
            }

            @Override
            public void onFinish() {
                tvTiempo.setText("¡Tiempo finalizado!");
                // Detener el cronómetro y el audio al terminar
                mediaPlayer.stop();
                finish(); // Regresar a la actividad anterior
            }
        }.start();

        // Cambiar el estado de cronómetro y audio
        cronometroCorriendo = true;
        audioReproduciendo = true;

        // Reproducir el audio
        mediaPlayer.start();

        // Cambiar el ícono del botón a "pausa"
        btnIniciar.setImageResource(R.drawable.play);
    }

    private void pausarCronometro() {
        // Pausar el cronómetro
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Pausar el audio
        if (audioReproduciendo) {
            mediaPlayer.pause();
        }

        // Cambiar el estado de cronómetro y audio
        cronometroCorriendo = false;
        audioReproduciendo = false;

        // Cambiar el ícono del botón a "play"
        btnIniciar.setImageResource(R.drawable.play);
    }

    private void actualizarTiempo() {
        String tiempoFormateado = String.format("%02d:%02d", minutos, segundos);
        tvTiempo.setText(tiempoFormateado);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Detener y liberar el recurso del audio al salir de la actividad
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
