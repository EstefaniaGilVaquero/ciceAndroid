package com.example.vale.parcelableserializable;

import java.io.Serializable;

/**
 * Created by vale on 12/07/16.
 */
public class PersonaSerializable implements Serializable {


    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public PersonaSerializable(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public PersonaSerializable () {}

    @Override
    public String toString() {
        return nombre+edad;
    }
}
