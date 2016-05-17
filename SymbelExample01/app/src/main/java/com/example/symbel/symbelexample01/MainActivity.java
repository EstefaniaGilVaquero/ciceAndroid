package com.example.symbel.symbelexample01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button)findViewById(R.id.button);

        EscuchaEventos escuchaEventos = new EscuchaEventos();
        boton.setOnClickListener(escuchaEventos);
    }

    //TODO Detectar el evento al pulsar boton


    //TODO Calcular longitud del texto introducido
    //TODO Mostrar resultado
}
