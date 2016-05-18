package com.example.brandt.krobookingapp.UI;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.BLL.ASyncReader;
import com.example.brandt.krobookingapp.R;


import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView isBooked;
    TextView isRoomNumber;
    int SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ASyncReader(this).execute();
    }

    public void populateView(ArrayList<Rooms> all) {
        Log.d("XYZ", "GUI viser " + all.size() + " rum");
        TableLayout table = (TableLayout) findViewById(R.id.tableToday);
        for (int i = 0; i < all.size(); i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);

            Rooms rooms = all.get(i);
            int roomNumber = rooms.getRoomNumber();
            boolean booked = rooms.isRented();

            isRoomNumber = new TextView(this);
            isBooked = new TextView(this);

            if (booked == false) {
                isBooked.setText(" \n This room is available!");
                isBooked.setTextColor(Color.rgb(0, 200, 0));
            } else if (booked == true) {
                isBooked.setText(" \n This room i currently booked");
                isBooked.setTextColor(Color.rgb(200, 0, 0));
            }
            isRoomNumber.setText(" \n Room number: " + roomNumber);

            row.addView(isRoomNumber);

            row.addView(isBooked);

            table.addView(row, i);
        }
    }
}
