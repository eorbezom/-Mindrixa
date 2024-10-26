// Ubicación: TimerActivity.java
package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private TextView timerTextView;
    private Button startButton;
    private Button cancelButton;
    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS = 720000; // 12 minutos en milisegundos
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);
        cancelButton = findViewById(R.id.cancelButton);

        startButton.setOnClickListener(v -> startTimer());

        cancelButton.setOnClickListener(v -> {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            finish();
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(START_TIME_IN_MILLIS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                String timeLeft = String.format("%02d:%02d", minutes, seconds);
                timerTextView.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                isRunning = false;
                timerTextView.setText("00:00");
            }
        };
        countDownTimer.start();
        isRunning = true;
    }
}
