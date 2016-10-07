package com.symbel.appsubactivitystartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start_activity_for_result);

        Intent intent = new Intent(this, SubActivity.class);

        startActivityForResult(intent, 237);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        String strdev =  data.getStringExtra("ALUMNOS");
        Log.d(getClass().getCanonicalName(), "String dev = " + strdev);
        Log.d(getClass().getCanonicalName(), "Result code = " + resultCode);
        Log.d(getClass().getCanonicalName(), "Request code = " + requestCode);

    }
}
