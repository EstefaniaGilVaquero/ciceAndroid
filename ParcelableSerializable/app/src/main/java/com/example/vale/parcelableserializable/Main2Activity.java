package com.example.vale.parcelableserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {

            Intent i = getIntent();

            PersonaParcelable p = (PersonaParcelable) i.getParcelableExtra("person");
            //PersonaSerializable p = (PersonaSerializable)i.getExtras().get("person");

            Log.d(getClass().getCanonicalName(), p.toString());
        }
        catch (Throwable t)
        {
            Log.e(getClass().getCanonicalName(), "Error", t);
        }

    }
}
