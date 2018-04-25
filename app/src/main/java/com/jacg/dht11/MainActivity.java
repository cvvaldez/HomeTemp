package com.jacg.dht11;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Typeface typeface;
    private TextView textTitle;
    private TextView textCalor;
    private TextView textFrio;
    private TextView textButton;
    private TextView textButton2;
    private TextView textTemp;
    private TextView textHum;

    private TextView textSenseTemp;
    private LinearLayout actuadorFrio;
    private LinearLayout actuadorCalor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        typeface = Typeface.createFromAsset(getAssets(), "fonts/BrodoThinGrunge.ttf");
        textTitle = (TextView) findViewById(R.id.textTitle);
        textCalor = (TextView) findViewById(R.id.textCalor);
        textFrio = (TextView) findViewById(R.id.textFrio);
        textButton = (TextView) findViewById(R.id.textButton);
        textButton2 = (TextView) findViewById(R.id.textButton2);
        textTemp = (TextView) findViewById(R.id.textTemp);
        textHum = (TextView) findViewById(R.id.textHum);

        textSenseTemp = (TextView) findViewById(R.id.sensetemp);
        actuadorFrio = (LinearLayout) findViewById(R.id.actuadorfrio);
        actuadorCalor = (LinearLayout) findViewById(R.id.actuadorcalor);

        textTitle.setTypeface(typeface);
        textCalor.setTypeface(typeface);
        textFrio.setTypeface(typeface);
        textButton.setTypeface(typeface);
        textButton2.setTypeface(typeface);
        textTemp.setTypeface(typeface);
        textHum.setTypeface(typeface);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new Timer().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    private class Timer extends AsyncTask<Void, Integer, Long> {

        @Override
        protected Long doInBackground(Void... values) {
            //int count = 0;
            Integer[] temps = {26, 26, 27, 30, 27, 26, 23, 21, 19, 24};
            long totalSize = 0;

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(5000); //Segundos
                } catch (InterruptedException e) {

                }
                publishProgress(temps[i]);
            }
            return totalSize;
        }

        @Override
        protected void onProgressUpdate(Integer... newTemp) {
            Integer tempValue = newTemp[0];
            textSenseTemp.setText(tempValue.toString());
            if (tempValue >= 28) {
                actuadorCalor.setVisibility(View.VISIBLE);
            } else if (tempValue <= 20) {
                actuadorFrio.setVisibility(View.VISIBLE);
            } else {
                actuadorFrio.setVisibility(View.GONE);
                actuadorCalor.setVisibility(View.GONE);
            }
        }

            @Override
            protected void onPostExecute(Long result){
                //showDialog("Downloaded " + result + " bytes");
            }
        }
    }



