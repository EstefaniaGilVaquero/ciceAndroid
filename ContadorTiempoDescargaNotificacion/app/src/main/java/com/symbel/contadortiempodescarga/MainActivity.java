package com.symbel.contadortiempodescarga;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //public static String mURL = null;
    public static String mURL = "http://www.hrsanroque.com/galeria/slider/18.jpg";
    public static TextView textoTiempo;
    public static ImageView imageView;

    public void programarAvisoFinServicio()
    {
        //TODO: Asociar al broadcastReciever un IntentFilter
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("SERVICIO_TERMINADO");

        MyReceiver br = new MyReceiver(this);
        registerReceiver(br, intentFilter);

    }

    public void download (View view){

        Intent intentService = null;

        programarAvisoFinServicio();

        intentService = new Intent(this,MyService.class);
        startService(intentService);

    }

    private void inicializarContador(){
        SharedPreferences prefs = this.getSharedPreferences("contador", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("nVeces",0);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoTiempo = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        inicializarContador();
    }

//    public static void pintarResultado(Bitmap imagen, long tiempo){
//
//        textoTiempo.setText(Long.toString(tiempo));
//        imageView.setImageBitmap(imagen);
//    }
}
