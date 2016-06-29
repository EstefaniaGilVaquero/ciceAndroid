package com.example.vale.recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

public class LibroViewHolder extends ViewHolder {

    private TextView caja_txt_titulo;
    private TextView caja_txt_autor;

   public LibroViewHolder (View itemView) {

        super(itemView);
        caja_txt_autor = (TextView)itemView.findViewById(R.id.LblAutor);
        caja_txt_titulo = (TextView)itemView.findViewById(R.id.LblTitulo);
    }


    public void cargarLibroEnHolder(Libro l) {
        caja_txt_titulo.setText(l.getTitulo());
        caja_txt_autor.setText(l.getAutor());
    }


}
