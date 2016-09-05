package com.symbel.contadortiempodescarga;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recibimos los datos del intent
        Intent i=getIntent();

        Bitmap imagen = i.getExtras().getParcelable("BITMAP");
        Long time = i.getLongExtra("TIME",0);

        //Referencias a los objetos
        TextView tiempoLBL = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        //Asignamos valor a los objetos
        tiempoLBL.setText(time.toString());
        imageView.setImageBitmap(imagen);
    }
}
