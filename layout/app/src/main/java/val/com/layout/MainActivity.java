package val.com.layout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main_framelayout);
        //setContentView(R.layout.activity_main_linearlayout);
        //setContentView(R.layout.activity_main_linearlayout2);
        //setContentView(R.layout.gravitylayout);
        //setContentView(R.layout.activity_main_tablelayout);
        setContentView(R.layout.activity_main_gridlayout);
        //setContentView(R.layout.activity_main_relativelayout);

        String densidad = this.obtenerDensidad(this);
        Log.d(getClass().getCanonicalName(), "Densidad = " + densidad);
    }

    public String obtenerDensidad (Context context)
    { String densidad = "";
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW: densidad = "ldpi";
            case DisplayMetrics.DENSITY_MEDIUM: densidad = "mdpi";
            case DisplayMetrics.DENSITY_HIGH: densidad = "hdpi";
            case DisplayMetrics.DENSITY_XHIGH: densidad = "xhdpi";
            case DisplayMetrics.DENSITY_XXHIGH: densidad = "xxhdpi";
            case DisplayMetrics.DENSITY_XXXHIGH: densidad = "xxxhdpi";
            default: densidad = "defecto"; }
        return densidad;
    }
}
