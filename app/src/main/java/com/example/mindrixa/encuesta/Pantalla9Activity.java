package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.MenuActivity;
import com.example.mindrixa.R;

public class Pantalla9Activity extends AppCompatActivity {

    @Override

    protected  void onCreate(Bundle guardarInstancia){
        super.onCreate(guardarInstancia);
        setContentView(R.layout.activity_pantalla9);

        Button button26 = findViewById(R.id.button26);
        Button button27 = findViewById(R.id.button27);

        button26.setOnClickListener(v -> siguientePantalla());
        button27.setOnClickListener(v -> volverMenu());



    }
    private void siguientePantalla(){
        Intent intent=new Intent(Pantalla9Activity.this, Pantalla10Activity.class);
        startActivity(intent);
    }

    private void volverMenu(){
        Intent intent = new Intent(Pantalla9Activity.this, MenuActivity.class);
        startActivity(intent);
    }
}
