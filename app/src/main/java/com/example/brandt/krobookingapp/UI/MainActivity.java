package com.example.brandt.krobookingapp.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.BLL.ASyncReader;
import com.example.brandt.krobookingapp.R;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ASyncReader(this).execute();

    }

    TextView isRoomNumber;
    TextView isAvailable;

    public void populateView(ArrayList<Rooms> all) {
        Log.d("XYZ", "GUI viser " + all.size() + " rum");
        TableLayout table = (TableLayout) findViewById(R.id.rentedTodayColloun);

        for (int i = 0; i < all.size(); i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);

            Rooms test = all.get(i);
            int roomNumber = test.getRoomNumber();
            boolean available = test.isRented();

            isRoomNumber = new TextView(this);
            isAvailable = new TextView(this);


            isAvailable.setText("is room available? " + available);
            isRoomNumber.setText("" + roomNumber);
            row.addView(isRoomNumber);
            row.addView(isAvailable);
            table.addView(row,i);
        }
    }
}
