package com.example.brandt.krobookingapp.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.brandt.krobookingapp.BE.Customer;
import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.BLL.ASyncReader;
import com.example.brandt.krobookingapp.R;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    TextView test;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        test = (TextView) findViewById(R.id.test);



        new ASyncReader(this).execute();



    }

    public void populateView(ArrayList<Rooms> all)
    {

        Log.d("XYZ", "GUI viser " + all.size() + " rum");

        Rooms room1 = all.get(0);
        String roomnumber =room1.getCustomer().getCompany().getCompanyName();

        test.setText("RoomNumber: " + roomnumber);





    }


}
