package com.cappacitate2015.cappacitate2015;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;


public class CitaActivity extends ActionBarActivity {

    TextView txtFecha;
    TextView txtHora;
    TextView txtNombre;

    private int mStartHour = 0;
    private int mStartMinute = 0;
    private String mNombre;
    private String fechaFormateada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);

        // Cambiar color Action Bar
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.defaultCitapps));
        actionBar.setBackgroundDrawable(colorDrawable);

        txtFecha = (TextView)findViewById(R.id.txtFecha);
        txtHora  = (TextView)findViewById(R.id.txtHora);
        txtNombre = (TextView)findViewById(R.id.txtNombre);

        Bundle bundle = this.getIntent().getExtras();
        //String fecha = bundle.getString("Fecha");
        Long dateLong = bundle.getLong("Fecha");
        mNombre = bundle.getString("Nombre");

        Date mFecha = new Date(dateLong);
        DateFormat formater = DateFormat.getDateInstance(DateFormat.LONG);
        fechaFormateada = formater.format(mFecha);

        txtFecha.setText(fechaFormateada);
        txtNombre.setText(mNombre);

        txtHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewClicked) {
                showDialog(1);


            }
        });

    }

    private TimePickerDialog.OnTimeSetListener mHoraSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtHora.setText(GetTimeString(hourOfDay, minute));
                }
            };

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case 1: {
                return new TimePickerDialog(this, mHoraSetListener, mStartHour, mStartMinute, false);
            }
        }
        return null;
    }

    private String GetTimeString(int pHours, int pMinutes)
    {
        String returnValue = "";
        String indicatorAmPm = "";
        String hour = "";
        String minute = "";

        if (pHours >= 12){
            indicatorAmPm = "PM";
        }
        else{
            indicatorAmPm = "AM";
        }

        if (pHours > 12) {
            pHours = pHours - 12;
        }
        if (pHours == 0) {
            pHours = 12;
        }

        if (pHours >= 10){
            hour= String.valueOf(pHours);
        }
        else{
            hour= "0" + String.valueOf(pHours);
        }

        if (pMinutes >= 10){
            minute= String.valueOf(pMinutes);
        }
        else{
            minute= "0" + String.valueOf(pMinutes);
        }

        returnValue = hour + ":" + minute + " " + indicatorAmPm;

        return returnValue;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cita, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnuAgendar) {
            String texto="";
            texto="Cita agendada para " + mNombre + " el día " + fechaFormateada + " a las " + txtHora.getText();
            Toast.makeText(CitaActivity.this, texto, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
