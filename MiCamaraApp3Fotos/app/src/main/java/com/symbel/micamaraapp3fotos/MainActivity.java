package com.symbel.micamaraapp3fotos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_ACTIVIDAD = 100;
    private String ruta_captura_foto;
    private static final String SUFIJO_FOTO = ".jpg";
    private static final String PREFIJO_FOTO = "VALE_PIC_";
    private static int contador = 0;
    private List<String> lista_rutas = new ArrayList<String>();

    private String obtenerRutaFichero(){
        String ruta = null;
        String nombreFoto = null;
        String momento_actual = null;

        momento_actual = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); //así nos garantizamos emplear un sufijo aleatorio: el nombre del archivo de la imagen incluirá el momento exacto
        nombreFoto = PREFIJO_FOTO + momento_actual + SUFIJO_FOTO;
        ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath()+"/"+ruta;

        Log.d(getClass().getCanonicalName(), "RUTA FOTO = " + ruta);

       return ruta;
    }

    private Uri obtenerUriFromRuta(String ruta){
        Uri uri_dev = null;
        File f = null;

        f = new File(ruta);

        try
        {
            if (f.createNewFile())
                Log.d(getClass().getCanonicalName(), "Fichero creado");
            else
                Log.d(getClass().getCanonicalName(), "Fichero NO creado (ya existía)");
        }
        catch (IOException e)
        {
            Log.e(getClass().getCanonicalName(), "Error creando el fichero", e);
        }

        uri_dev = Uri.fromFile(f);

        Log.d(getClass().getCanonicalName(), "URI FOTO = " + uri_dev.toString());

        return uri_dev;
    }

    private void mostrarFotos(){



    }


    private void tomarFoto(){
        String str_dev = null;
        Intent intent_foto = null;
        Uri uriFoto = null;

        intent_foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        str_dev = obtenerRutaFichero();
        uriFoto = obtenerUriFromRuta(str_dev);

        intent_foto.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto); //He aquí la parte opcional del código: de emplearse este parámetro, la foto tomada se almacena en una localización concreta y de omitirse, se alamcena en una localización aleatoria
        startActivityForResult(intent_foto, CODIGO_ACTIVIDAD);//el segundo parámetro es una forma de identificar la petición, para poder ser recibida posteriormente, además de indicarle a Android que será una Actividad HIJA


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> lista_rutas = new ArrayList<String>(2);
        String rutaFoto_aux;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        for (int i = 0; i <= 2; i++) {

            tomarFoto();
        }

        do{
            mostrarFotos();
        }while (lista_rutas.size() < 2);

        mostrarFotos();
//        this.listView = (ListView) findViewById(R.id.listView);
//        this.listView.setAdapter(new ListaImagenes(this, lista));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d(getClass().getCanonicalName(), "VUELVE DE hacer la FOTO"); //requestCode == CODIGO_ACTIVIDAD

        switch (resultCode)
        {
            case RESULT_OK:

                Log.d(getClass().getCanonicalName(), "La cosa fue bien Código " + resultCode);
                Bitmap bitmap = null; //la foto que se mostrará en la actividad

                if (data == null)//el fichero ha sido guarado en una ruta => se ha usado el putExtra MediaStore.EXTRA_OUTPUT
                {
                    Log.d(getClass().getCanonicalName(), "Se empleó el parámetro MediaStore.EXTRA_OUTPUT");

                    try
                    {
                        lista_rutas.add(ruta_captura_foto);

                    } catch (Exception e)
                    {
                        Log.e(getClass().getCanonicalName(), "ERRORAZO recuperadno la foto tomada" , e);
                    }
                }
                else
                { //la foto ha sido capturada y devuelta en un intent = NO se ha usado el putExtra MediaStore.EXTRA_OUTPUT

                    Log.d(getClass().getCanonicalName(), "NO Se empleó el parámetro MediaStore.EXTRA_OUTPUT : se devolvió el bitmap");
                    bitmap = (Bitmap) data.getExtras().get("data");
                }

                break;

            case RESULT_CANCELED:
                Log.d(getClass().getCanonicalName(), "La cosa se canceló " + resultCode);
                break;

            default:
                Log.d(getClass().getCanonicalName(), "FIN CON CÓDIGO " + resultCode);

        }
    }
}
