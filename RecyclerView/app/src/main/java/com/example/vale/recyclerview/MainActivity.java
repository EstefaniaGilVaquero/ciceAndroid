package com.example.vale.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recView;

    private ArrayList<Libro> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<Libro>();
        Libro libro_aux = null;

        for(int i=0; i<20; i++)
        {
            libro_aux = new Libro("Libro "+ i , " Autor " + i);
            datos.add(libro_aux);
        }

        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        AdapterLibros adaptador = new AdapterLibros(datos);


        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));

    }


}