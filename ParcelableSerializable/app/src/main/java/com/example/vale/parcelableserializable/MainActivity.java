package com.example.vale.parcelableserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //POJOS|BEANS

        /*PersonaSerializable ps = new PersonaSerializable("Vale", 32);
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("person", ps);
        startActivity(i);*/


        PersonaParcelable pp = new PersonaParcelable ("Vale", 32);
        Intent i2 = new Intent(this, Main2Activity.class);
        i2.putExtra("person", pp);
        startActivity(i2);
    }
}
