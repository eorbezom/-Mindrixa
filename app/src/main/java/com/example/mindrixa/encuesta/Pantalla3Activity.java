package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.R;

public class Pantalla3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);


        //referencias de los botones
        Button btnOpcion1 = findViewById(R.id.button8);
        Button btnOpcion2 = findViewById(R.id.button10);
        Button btnOpcion3 = findViewById(R.id.button11);
        Button btnOpcion4 = findViewById(R.id.button12);
        Button btnOpcion5 = findViewById(R.id.button13);
        ImageButton btnRetroceder = findViewById(R.id.btnRetroceder3);

        // funcion de los botones
        btnOpcion1.setOnClickListener(v -> abrirSiguientePantalla());
        btnOpcion2.setOnClickListener(v -> abrirSiguientePantalla());
        btnOpcion3.setOnClickListener(v -> abrirSiguientePantalla());
        btnOpcion4.setOnClickListener(v -> abrirSiguientePantalla());
        btnOpcion5.setOnClickListener(v -> abrirSiguientePantalla());

        btnRetroceder.setOnClickListener(v -> {
            Intent intent = new Intent(Pantalla3Activity.this, Pantalla2Activity.class);
            startActivity(intent);
            finish();
        });

    }


    private void abrirSiguientePantalla(){
        Intent intent= new Intent(this, Pantalla4Activity.class);
        startActivity(intent);
    }
}
