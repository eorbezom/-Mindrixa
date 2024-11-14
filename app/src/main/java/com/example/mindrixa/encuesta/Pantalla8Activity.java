package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.R;

public class Pantalla8Activity extends AppCompatActivity {

    @Override

    protected  void onCreate(Bundle guardarInstancia){
        super.onCreate(guardarInstancia);
        setContentView(R.layout.activity_pantalla8);

        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);
        Button button23 = findViewById(R.id.button23);
        Button button24 = findViewById(R.id.button24);
        Button button25 = findViewById(R.id.button25);

        ImageButton btnRetroceso8 = findViewById(R.id.btnRetroceder8);

        button21.setOnClickListener(v -> siguientePantalla());
        button22.setOnClickListener(v -> siguientePantalla());
        button23.setOnClickListener(v -> siguientePantalla());
        button24.setOnClickListener(v -> siguientePantalla());
        button25.setOnClickListener(v -> siguientePantalla());

        btnRetroceso8.setOnClickListener(v -> {
            Intent intent = new Intent(Pantalla8Activity.this, Pantalla7Activity.class);
            startActivity(intent);
            finish();
        });





    }
    private void siguientePantalla(){
        Intent intent = new Intent(Pantalla8Activity.this, Pantalla9Activity.class);
        startActivity(intent);
    }
}
