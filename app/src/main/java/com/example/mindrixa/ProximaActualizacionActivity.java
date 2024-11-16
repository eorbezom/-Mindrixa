package com.example.mindrixa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindrixa.control.MenuActivitySegundo;

public class ProximaActualizacionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxima_actualizacion);

        ImageView imageView= findViewById(R.id.atrasActualizacion);

        imageView.setOnClickListener(v -> pantallaMenu());
    }
    private void pantallaMenu(){
        Intent intent= new Intent(ProximaActualizacionActivity.this, MenuActivitySegundo.class);
        startActivity(intent);
        finish();
    }
}
