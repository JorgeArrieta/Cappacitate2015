package com.cappacitate2015.cappacitate2015;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class EspecialistasActivity extends ActionBarActivity {
    private ListView lstEspecialistas;
    private TextView txtEspecialidad;
    private clsDatos datos = new clsDatos();
    private ArrayList<clsEspecialista> especialistas;
    int id;
    String mEspecialiad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialistas);

        // Cambiar color Action Bar
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.defaultCitapps));
        actionBar.setBackgroundDrawable(colorDrawable);

        txtEspecialidad = (TextView)findViewById(R.id.txtEspecialidad);

        Bundle bundle = this.getIntent().getExtras();
        id = bundle.getInt("Id");
        mEspecialiad = bundle.getString("Especialidad");

        txtEspecialidad.setText(mEspecialiad);

        especialistas = new ArrayList<clsEspecialista>();
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
                    ImageView imgLogo = (ImageView) view.findViewById(R.id.imgLogo);

                    txtNombre.setText(especialistaItem.Nombre);
                    txtDireccion.setText(especialistaItem.Direccion);
                    txtTelefono.setText(especialistaItem.Telefono);

                    //String image = "image_0" + String.valueOf(Position);
                    //imgLogo.setImageResource(R.drawable.image_00);
                    switch (id){
                        case 0:
                            switch (Position){
                                case 0:
                                    imgLogo.setImageResource(R.drawable.image_00);
                                    break;
                                case 1:
                                    imgLogo.setImageResource(R.drawable.image_01);
                                    break;
                                case 2:
                                    imgLogo.setImageResource(R.drawable.image_02);
                                    break;
                                case 3:
                                    imgLogo.setImageResource(R.drawable.image_03);
                                    break;
                                case 4:
                                    imgLogo.setImageResource(R.drawable.image_99);
                                    break;

                            }
                            break;
                        case 1:
                            switch (Position){
                                case 0:
                                    imgLogo.setImageResource(R.drawable.image_04);
                                    break;
                                case 1:
                                    imgLogo.setImageResource(R.drawable.image_05);
                                    break;
                                case 2:
                                    imgLogo.setImageResource(R.drawable.image_06);
                                    break;
                                case 3:
                                    imgLogo.setImageResource(R.drawable.image_07);
                                    break;
                                case 4:
                                    imgLogo.setImageResource(R.drawable.image_99);
                                    break;
                            }
                            break;
                    }

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
                b.putString("Nombre", especialistas.get(position).Nombre);
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
        if (id == R.id.mnuVerMapa) {
            Intent intent = new Intent(EspecialistasActivity.this, MapaActivity.class);
            Bundle b = new Bundle();
            b.putString("Nombre", mEspecialiad);
            intent.putExtras(b);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
