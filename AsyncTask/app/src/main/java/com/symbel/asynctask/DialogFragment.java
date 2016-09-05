package com.symbel.asynctask;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by estefi on 12/07/2016.
 */
public class DialogFragment extends android.app.DialogFragment {


    public Dialog OnCreateDialog(Bundle savedInstanceState){

        Dialog dialog = null;
        Builder builder = new Builder(getActivity());
        builder.setMessage("Conéctese a una red WIFI para descargar los podcasts")
                .setTitle("Aviso Importante")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        dialog = builder.create();
        return dialog;
    }




}
