package com.example.vale.basededatos.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;

import com.example.vale.basededatos.R;
import com.example.vale.basededatos.dao.BaseDatosCochesPersona;
import com.example.vale.basededatos.dto.Coche;
import com.example.vale.basededatos.dto.Persona;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo el objeto de la base de datos
        BaseDatosCochesPersona baseDatosCochesPersona = new BaseDatosCochesPersona(this, "MiDB", null, 1);

        Persona persona1 = new Persona(1, "Juan");
        Persona persona2 = new Persona(2, "Conchi");
        Persona persona3 = new Persona(3, "Manolo");

        //inserto las personas
        baseDatosCochesPersona.insertarPersona(persona1);
        baseDatosCochesPersona.insertarPersona(persona2);
        baseDatosCochesPersona.insertarPersona(persona3);

        Coche coche1 = new Coche("Ferrari", persona2);
        Coche coche2 = new Coche("Renault", persona2);
        Coche coche3 = new Coche("Fiat", persona1);

        //inserto los coches
        baseDatosCochesPersona.insertarCoche(coche1);
        baseDatosCochesPersona.insertarCoche(coche2);
        baseDatosCochesPersona.insertarCoche(coche3);

        //consulto los coches de la persona
        List<Coche> listacoches = baseDatosCochesPersona.buscarCochesPersona(persona2);

        Log.d(getClass().getCanonicalName(), "Los coches de " + persona2.getNombre() + " son :");
        for (Coche coche: listacoches)
        {
            Log.d(getClass().getCanonicalName(), coche.getModelo());
        }
    }
}
