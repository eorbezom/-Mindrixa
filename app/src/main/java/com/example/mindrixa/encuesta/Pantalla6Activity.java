package com.example.mindrixa.encuesta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mindrixa.AddTaskActivity;
import com.example.mindrixa.R;

public class Pantalla6Activity extends AddTaskActivity {
    @Override
    protected void onCreate(Bundle guardarInstacia){
        super.onCreate(guardarInstacia);
        setContentView(R.layout.activity_pantalla6);

        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        ImageButton btnRetroceso=findViewById(R.id.btnRetroceder6);

        button15.setOnClickListener(v -> siguientePantalla());
        button16.setOnClickListener(v -> siguientePantalla());
        button17.setOnClickListener(v -> siguientePantalla());

        btnRetroceso.setOnClickListener(v -> {
            Intent intent= new Intent(Pantalla6Activity.this, Pantalla5Activity.class);
            startActivity(intent);
            finish();
        });

    }
    private void siguientePantalla(){
        Intent intent=new Intent(Pantalla6Activity.this, Pantalla7Activity.class);
        startActivity(intent);

    }
}
