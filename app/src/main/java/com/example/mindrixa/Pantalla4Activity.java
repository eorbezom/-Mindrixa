package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla4Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle guardaInstanciaState){

        super.onCreate(guardaInstanciaState);
        setContentView(R.layout.activity_pantalla4);


        //REFERENCIA DE BOTONES

        Button boton2 = findViewById(R.id.button2);
        Button boton3 = findViewById(R.id.button3);
        Button boton4 = findViewById(R.id.button4);
        Button boton5 = findViewById(R.id.button5);
        Button boton6 = findViewById(R.id.button6);
        ImageButton botoRetroceso =findViewById(R.id.btnRetroceder4);

        //FUNCIONE DE LOS BOTONES
        boton2.setOnClickListener(v -> abrirSigientePantalla());
        boton3.setOnClickListener(v -> abrirSigientePantalla());
        boton4.setOnClickListener(v -> abrirSigientePantalla());
        boton5.setOnClickListener(v -> abrirSigientePantalla());
        boton6.setOnClickListener(v -> abrirSigientePantalla());

        //boton retroceder
        botoRetroceso.setOnClickListener(v -> {
            Intent intent = new Intent(Pantalla4Activity.this, Pantalla3Activity.class);
            startActivity(intent);
            finish();
        });



    }
    //metodo para ir a la siguiente pantalla
    private  void abrirSigientePantalla(){
        Intent intent = new Intent(this, Pantalla5Activity.class);
        startActivity(intent);

    }
}
