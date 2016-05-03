package com.example.brandt.krobookingapp.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.BLL.ASyncReader;
import com.example.brandt.krobookingapp.R;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView responseView;
    TextView helloWorld;
    ASyncReader aSyncReader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ASyncReader(this).execute();

    }

    public void populateView(ArrayList<Rooms> all)
    {
        Log.d("XYZ", "GUI viser " + all.size() + " rum");

    }

   /** private void seedTables() {
        TableLayout table = (TableLayout) findViewById(R.id.rentedTodayColloun);
        for (int i = 0; i < ; i++) {

            TableRow tableRow1 = new TableRow(VideoDatabase1.this);
            localchannel1 = channel_arraylist.get(i);

            TextView tvid = new TextView(VideoDatabase1.this);
            tvid.setText("" + Integer.toString(localchannel1.getID()));
            tableRow2.addView(tvid);

            table.addView(tableRow2);
        }
    } */
}
