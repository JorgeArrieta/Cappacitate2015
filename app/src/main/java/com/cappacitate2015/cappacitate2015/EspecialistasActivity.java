package com.cappacitate2015.cappacitate2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class EspecialistasActivity extends ActionBarActivity {
    private ListView lstEspecialistas;
    private clsDatos datos = new clsDatos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialistas);

        Bundle bundle = this.getIntent().getExtras();
        int id = bundle.getInt("Id");

        ArrayList<clsEspecialista> especialistas = new ArrayList<clsEspecialista>();

        especialistas = datos.GetEspecialistas(id);

        lstEspecialistas = (ListView)findViewById(R.id.lstEspecialistas);
        ListAdapter listAdapter;
        listAdapter = (new ListAdapter(getBaseContext(), R.layout.view_especialista, especialistas) {
            @Override
            public void onEntrada(Object entrada, View view, Boolean viewIsNull, int Position) {
                if (entrada != null) {
                    clsEspecialista especialistaItem = (clsEspecialista) entrada;

                    TextView txtNombre = (TextView) view.findViewById(R.id.txtNombre);
                    TextView txtDireccion = (TextView) view.findViewById(R.id.txtDireccion);
                    TextView txtTelefono = (TextView) view.findViewById(R.id.txtTelefono);

                    txtNombre.setText(especialistaItem.Nombre);
                    txtDireccion.setText(especialistaItem.Direccion);
                    txtTelefono.setText(especialistaItem.Telefono);
                }
            }
        });

        lstEspecialistas.setAdapter(listAdapter);

        lstEspecialistas.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EspecialistasActivity.this, CalendarActivity.class);
                Bundle b = new Bundle();
                b.putInt("Id", position);
                intent.putExtras(b);
                startActivity(intent);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_especialistas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
