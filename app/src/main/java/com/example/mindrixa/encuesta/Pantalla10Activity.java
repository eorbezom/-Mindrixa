package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.R;

public class Pantalla10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle guardasInstancia){
        super.onCreate(guardasInstancia);
        setContentView(R.layout.activity_pantalla10);

        Button button28 = findViewById(R.id.button28);

        button28.setOnClickListener(v -> siguientePantalla());
    }
    private void siguientePantalla(){
        Intent intent = new Intent(Pantalla10Activity.this, Pantalla11Activity.class);
        startActivity(intent);
    }
}
