package com.example.vale.arkaifsconacentoenlaa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button btnEscribirFichero;
    Button btnLeerFichero;
    Button btnLeerRaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final Gson gson = new Gson();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnEscribirFichero = (Button)findViewById(R.id.BtnEscribirFichero);
        btnLeerFichero = (Button)findViewById(R.id.BtnLeerFichero);
        btnLeerRaw = (Button)findViewById(R.id.BtnLeerRaw);

        ListenerFicheros listenerFicheros = new ListenerFicheros(getApplicationContext());

        btnEscribirFichero.setOnClickListener(listenerFicheros);
        btnLeerFichero.setOnClickListener(listenerFicheros);
        btnLeerRaw.setOnClickListener(listenerFicheros);
    }
}
