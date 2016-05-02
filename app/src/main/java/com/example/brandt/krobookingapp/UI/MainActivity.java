package com.example.brandt.krobookingapp.UI;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.BLL.JSONParser;
import com.example.brandt.krobookingapp.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView responseView;
    JSONParser jsonParser;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseView = (TextView) findViewById(R.id.responseView);


        jsonParser = new JSONParser(this);


    }

    public void populateView(ArrayList<Rooms> all)
    {
        Log.d("XYZ", "GUI viser " + all.size() + " rum");
        
    }
















>>>>>>> ac5b12fce3876fdb5f457c262cac59250b6ff49f

}
