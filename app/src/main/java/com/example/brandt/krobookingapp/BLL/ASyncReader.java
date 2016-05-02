package com.example.brandt.krobookingapp.BLL;

import android.os.AsyncTask;
import android.util.Log;

import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.UI.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Brandt on 29-04-2016.
 */
public class ASyncReader extends AsyncTask<Void, Void, String>
{
    static final String API_URL = "http://bookingsystem-branddt.rhcloud.com/api/Rooms";

    MainActivity context;

    public ASyncReader(MainActivity c)
    {
        context = c;
    }







       private ArrayList<Rooms> parser(String response)
       {
           ArrayList<Rooms> all= new ArrayList<>();
           try {
               JSONArray rooms = new JSONArray(response);
               for (int i = 0; i < rooms.length(); i++) {
                   JSONObject room = rooms.getJSONObject(i);
                   String id = room.getString("_id");
                   int roomNumber = room.getInt("RoomNumber");
                   boolean rented = room.getBoolean("Rented");
                   boolean doubleRoom = room.getBoolean("Double");
                   boolean extraBed = room.getBoolean("ExtraBed");
                   boolean animal = room.getBoolean("Animal");

                   JSONObject customer = room.getJSONObject("Customer");
                   String customerName = customer.getString("Name");
                   String customerPhoneNumber = customer.getString("PhoneNumber");
                   boolean keybox = customer.getBoolean("Keybox");
                   String notes = customer.getString("Notes");

                   JSONObject company =customer.getJSONObject("Company");
                   String companyName = company.getString("Name");
                   String companyPhoneNumber = company.getString("PhoneNumber");



                   Rooms r = new Rooms();
                   all.add(r);
               }
           } catch (JSONException e)
           {
                Log.d("XYZ","jsonerror:" + e.getMessage());
           }
           return all;
       }

        public String doInBackground(Void... urls) {

            // Do some validation here

            try {
                URL url = new URL(API_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }

        }

        protected void onPostExecute (String response)
        {
            Log.d("XYZ", "readfromapi " + response);
            context.populateView(parser(response));
        }

    }
