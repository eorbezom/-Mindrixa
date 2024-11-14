package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.ProximaActualizacionActivity;
import com.example.mindrixa.R;

public class Pantalla11Activity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle guardarIntancia){
        super.onCreate(guardarIntancia);
        setContentView(R.layout.activity_pantalla11);

        Button button29 = findViewById(R.id.button29);

        button29.setOnClickListener(v -> pantallaDashbord());



    }
    private void pantallaDashbord(){
        Intent intent=new Intent(Pantalla11Activity.this, ProximaActualizacionActivity.class);
        startActivity(intent);
    }
}
