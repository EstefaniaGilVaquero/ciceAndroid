package com.val.intentando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recupero el texto que me han pasado por el intent

        String cadenaBusqueda = getIntent().getStringExtra("NOMBRE");
        Log.d(getClass().getCanonicalName(), "Nos han pasado = " + cadenaBusqueda);

        View v = findViewById(R.id.cajaDestino);
        EditText cajatexto = (EditText)v;
        cajatexto.setText(cadenaBusqueda);


    }
}
