package com.symbel.contadortiempodescarga;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    private String URL;


    public void download (View view){
        Calculo calculo = new Calculo(this);
        EditText editText = (EditText) findViewById(R.id.editText);
        calculo.execute(editText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void pintarResultado(Bitmap imagen, long tiempo){
        TextView textoTiempo = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        textoTiempo.setText(Long.toString(tiempo));
        imageView.setImageBitmap(imagen);
    }
}
