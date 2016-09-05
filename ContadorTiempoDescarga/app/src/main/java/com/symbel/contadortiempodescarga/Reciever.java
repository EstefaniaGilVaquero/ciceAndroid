package com.symbel.contadortiempodescarga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by estefi on 02/09/2016.
 */
public class Reciever extends BroadcastReceiver {

    private Context context;

    public Reciever(Context context) {

        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(getClass().getCanonicalName(), "Me han llamado desde un service!");

        //Obtenemos los extras del intent
        Bitmap bitmap = intent.getExtras().getParcelable("BITMAP");
        Long time = intent.getLongExtra("TIME",0);

        //Intent de llamada a la actividad detalle
        Intent intent2 = new Intent(context,Main2Activity.class);

        //Metemos datos en el intent
        intent2.putExtra("TIME", time);
        intent2.putExtra("BITMAP", bitmap);

        //Lanzamos nueva actividad
        context.startActivity(intent2);

    }

}
