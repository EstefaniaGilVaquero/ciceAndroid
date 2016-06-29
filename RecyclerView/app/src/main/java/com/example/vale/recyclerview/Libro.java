package com.example.vale.recyclerview;

/**
 * Created by vale on 23/06/16.
 */
public class Libro {

    private String autor;
    private String titulo;

    public Libro (String titulo, String autor)
    {
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
