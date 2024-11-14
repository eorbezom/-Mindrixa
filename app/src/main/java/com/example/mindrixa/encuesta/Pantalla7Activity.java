package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.ProximaActualizacionActivity;
import com.example.mindrixa.R;

public class Pantalla7Activity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle guardarIntancia){
        super.onCreate(guardarIntancia);
        setContentView(R.layout.activity_pantalla7);

        Button button18 = findViewById(R.id.button18);
        Button button19 = findViewById(R.id.button19);
        Button button20 = findViewById(R.id.button20);

        ImageButton tbnRetroceso7 =findViewById(R.id.btnRetroceder7);

        button18.setOnClickListener(v -> siguientePantalla());
        button19.setOnClickListener(v -> siguientePantalla());
        button20.setOnClickListener(v -> siguientePantalla());

        tbnRetroceso7.setOnClickListener(v -> {
            Intent intent= new Intent(Pantalla7Activity.this, Pantalla6Activity.class);
            startActivity(intent);
            finish();
        });



    }
    private void siguientePantalla(){
        Intent intent=new Intent(Pantalla7Activity.this, Pantalla8Activity.class);
        startActivity(intent);
    }
}
