package com.example.vale.arkaifsconacentoenlaa;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by vale on 1/06/16.
 */
public class ListenerFicheros implements View.OnClickListener {


    private Context context;

    public ListenerFicheros (Context context) {

        this.context = context;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.BtnEscribirFichero:
                try
                {
                    OutputStreamWriter fout =
                            new OutputStreamWriter(this.context.openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));

                    fout.write("Texto de prueba.");
                    fout.close();

                    Log.d(getClass().getCanonicalName(), "Fichero creado!");
                }
                catch (Exception ex)
                {
                    Log.e(getClass().getCanonicalName(), "Error al escribir fichero a memoria interna");
                }
                break;
            case R.id.BtnLeerFichero:
                try
                {
                    BufferedReader fin = new BufferedReader(new InputStreamReader(this.context.openFileInput("prueba_int.txt")));

                    String texto = fin.readLine();
                    fin.close();

                    Log.d(getClass().getCanonicalName(), "Fichero leido!");
                    Log.d(getClass().getCanonicalName(), "Texto: " + texto);
                }
                catch (Exception ex)
                {
                    Log.e(getClass().getCanonicalName(), "Error al leer fichero desde memoria interna");
                }
                break;
            case R.id.BtnLeerRaw:
                try
                {
                    InputStream fraw = this.context.getResources().openRawResource(R.raw.ficherito);

                    BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

                    String linea = brin.readLine();
                    fraw.close();

                    Log.d(getClass().getCanonicalName(), "Fichero RAW leido!");
                    Log.d(getClass().getCanonicalName(), "Texto: " + linea);
                }
                catch (Exception ex)
                {
                    Log.e(getClass().getCanonicalName(), "Error al leer fichero desde recurso raw");;
                }
            break;

            default:
                Log.d(getClass().getCanonicalName(), "Ninguno de los botones esperados");
        }

    }
}
