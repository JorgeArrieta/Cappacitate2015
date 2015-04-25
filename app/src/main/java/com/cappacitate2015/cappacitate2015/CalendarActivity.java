package com.cappacitate2015.cappacitate2015;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class CalendarActivity extends ActionBarActivity {
    private CaldroidFragment caldroidFragment = null;
    private String mNombre = "";

    TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Cambiar color Action Bar
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.defaultCitapps));
        actionBar.setBackgroundDrawable(colorDrawable);

        Bundle bundle = this.getIntent().getExtras();
        mNombre = bundle.getString("Nombre");

        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtNombre.setText(mNombre);

        caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);
        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();

        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                //Toast.makeText(MainContext, date.toString(), Toast.LENGTH_SHORT).show();
                //date
                Intent intent = new Intent(CalendarActivity.this, CitaActivity.class);
                Bundle b = new Bundle();
                //b.putString("Fecha", date.toString());
                b.putLong("Fecha", date.getTime());
                b.putString("Nombre", mNombre);
                intent.putExtras(b);
                startActivity(intent);
            }

        };

        caldroidFragment.setCaldroidListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
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
