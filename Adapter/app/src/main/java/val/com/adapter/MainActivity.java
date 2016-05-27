package val.com.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //EJEMPLO 1 ADAPTER
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array que asociaremos al adaptador
        String[] array = new String[] {
                "Elemento 1"
                ,"Elemento 2"
                ,"Elemento 3"
                ,"Elemento 4"
                ,"Elemento 5"
                ,"Elemento 6"
        };

        //Creación del adaptador, vamos a escoger el layout
        //simple_list_item_1, que los mostr
        ListAdapter adaptador = new ArrayAdapter<String>(this, R.layout.fila, array);

        //Asociamos el adaptador a la vista.
        ListView lv = (ListView) findViewById(R.id.listacadenas);
        lv.setAdapter(adaptador);*/

        //EJEMPLO 2 ADAPTER
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        GridView gridview = (GridView) findViewById(R.id.migridview);
        gridview.setAdapter(new ImagenAdapter(this));

        gridview.setOnItemClickListener (new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText (MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        }
        );

    }
}
