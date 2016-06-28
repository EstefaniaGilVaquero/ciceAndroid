package com.example.vale.textinputlayout;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by vale on 6/06/16.
 */
public class FocusListener implements View.OnFocusChangeListener {

    private Activity actividad;

    public FocusListener (Activity activity)
    {
        this.actividad = activity;
    }

    /**
     * Idealmente, este método debería ir en un clase Util Validar o algo parecido
     */
    private boolean emailValido (String email)
    {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private boolean telefonoValido (String telefono)
    {
        return Patterns.PHONE.matcher(telefono).matches();
    }

    public boolean validarDivisible(String telefono){
        int largo=telefono.length(), sum=0;
        boolean valido = false;

        for(int i=0; i<largo; i++){
            Character character = telefono.charAt(i);
            if (Character.isDigit(character)){
                sum += Integer.parseInt(String.valueOf(character));
            }
        }

        if ((sum % 2) == 0){
            valido = true;
        }

        System.out.println(" Cadena es: " +  telefono);
        System.out.println(" suma es: " +  sum);
        return valido;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {

            switch (v.getId()) {
                case R.id.cajamail:
                    EditText cajatextomail = (EditText) v;
                    String mailintroducido = cajatextomail.getText().toString();
                    if (!emailValido(mailintroducido)) {
                        TextInputLayout wrapmail = (TextInputLayout) actividad.findViewById(R.id.tilcajamail);
                        wrapmail.setError("Mail Incorrecto");
                    }
                    break;
                case R.id.cajatelf:
                    EditText cajatextotelefono = (EditText) v;
                    String telefonoIntroducido = cajatextotelefono.getText().toString();
                    if (!telefonoValido(telefonoIntroducido)) {
                        TextInputLayout wrapmail = (TextInputLayout) actividad.findViewById(R.id.tilcajatelf);
                        wrapmail.setError("Suma no multiplo de 2");
                    }

                    if (!validarDivisible(telefonoIntroducido)) {
                        TextInputLayout wrapmail = (TextInputLayout) actividad.findViewById(R.id.tilcajatelf);
                        wrapmail.setError("Telefono no Valido");
                    }
                    break;
            }
        }
    }




}
