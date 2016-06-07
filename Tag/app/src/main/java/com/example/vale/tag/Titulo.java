package com.example.vale.tag;

/**
 * Created by vale on 30/05/16.
 */
public class Titulo {

    private String titulo;
    private String subtitulo;

    public Titulo(String tit, String sub){
        titulo = tit;
        subtitulo = sub;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
}
