package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mindrixa.AddTaskActivity;
import com.example.mindrixa.R;

public class Pantalla5Activity extends AddTaskActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantalla5);

        Button btnOpcion = findViewById(R.id.button);
        Button btnOpcion14 = findViewById(R.id.button14);
        Button btnOpcion9 = findViewById(R.id.button9);
        Button btnOpcion7 = findViewById(R.id.button7);
        ImageButton btnRetroceso = findViewById(R.id.btnRetroceder5);


        btnOpcion.setOnClickListener(v -> abriSiguientePantalla());
        btnOpcion7.setOnClickListener(v -> abriSiguientePantalla());
        btnOpcion9.setOnClickListener(v -> abriSiguientePantalla());
        btnOpcion14.setOnClickListener(v -> abriSiguientePantalla());


        btnRetroceso.setOnClickListener(v -> {
            Intent intent = new Intent(Pantalla5Activity.this, Pantalla4Activity.class);
            startActivity(intent);
            finish();
        });





    }
    //FUNCION PARA ABRIR EL SIGUIENTE PANTALLA
    private void abriSiguientePantalla(){
        Intent intent=new Intent(Pantalla5Activity.this, Pantalla6Activity.class);
        startActivity(intent);

    }
}
