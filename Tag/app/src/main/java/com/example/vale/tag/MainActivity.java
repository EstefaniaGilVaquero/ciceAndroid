package com.example.vale.tag;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblEtiqueta;
    private ListView lstOpciones;

    private Titulo[] datos =
            new Titulo[]{
                    new Titulo("Título 1", "Subtítulo largo 1"),
                    new Titulo("Título 2", "Subtítulo largo 2"),
                    new Titulo("Título 3", "Subtítulo largo 3"),
                    new Titulo("Título 4", "Subtítulo largo 4"),
                    new Titulo("Título 5", "Subtítulo largo 5"),
                    new Titulo("Título 6", "Subtítulo largo 6"),
                    new Titulo("Título 7", "Subtítulo largo 7"),
                    new Titulo("Título 8", "Subtítulo largo 8"),
                    new Titulo("Título 9", "Subtítulo largo 9"),
                    new Titulo("Título 10", "Subtítulo largo 10"),
                    new Titulo("Título 11", "Subtítulo largo 11"),
                    new Titulo("Título 12", "Subtítulo largo 12"),
                    new Titulo("Título 13", "Subtítulo largo 13"),
                    new Titulo("Título 14", "Subtítulo largo 14"),
                    new Titulo("Título 15", "Subtítulo largo 15")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblEtiqueta = (TextView) findViewById(R.id.LblEtiqueta);
        lstOpciones = (ListView) findViewById(R.id.LstOpciones);

        //Cabecera
        //View header = getLayoutInflater().inflate(R.layout.list_header, null);
        //lstOpciones.addHeaderView(header);

        //Adaptador
        AdaptadorTitulares adaptador = new AdaptadorTitulares(this, datos);

        lstOpciones.setAdapter(adaptador);

        //Eventos
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((Titulo) a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();

                lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });
    }


    class AdaptadorTitulares extends ArrayAdapter<Titulo> {

        AdaptadorTitulares(Context context, Titulo[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.titulo = (TextView) item.findViewById(R.id.LblTitulo);
                holder.subtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.titulo.setText(datos[position].getTitulo());
            holder.subtitulo.setText(datos[position].getSubtitulo());

            return (item);
        }
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }
}