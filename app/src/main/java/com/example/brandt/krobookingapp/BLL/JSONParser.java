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
public class JSONParser
{
    static final String API_URL = "http://bookingsystem-branddt.rhcloud.com/api/Rooms";



    public ArrayList<Rooms> all;

    MainActivity context;

    public JSONParser(MainActivity c)
    {
        context = c;
    }
    public ArrayList parser(String response)
    {
        try {
            JSONArray rooms = new JSONArray(response);
            for (int i = 0; i < rooms.length(); i++) {
                JSONObject x = rooms.getJSONObject(i);
                //String id = x.getString("_id");
                int roomNumber = x.getInt("RoomNumber");
                boolean rented = x.getBoolean("Rented");
                boolean doubleRoom = x.getBoolean("Double");
                boolean extraBed = x.getBoolean("ExtraBed");
                boolean animal = x.getBoolean("Animal");

                    JSONObject z = rooms.getJSONObject(i);
                    String customerName = z.getString("Name");
                    String customerPhoneNumber = z.getString("PhoneNumber");
                    boolean keybox = z.getBoolean("Keybox");
                    String notes = z.getString("Notes");

                        JSONObject c = rooms.getJSONObject(i);
                        String companyName = c.getString("Name");
                        String companyPhoneNumber = c.getString("PhoneNumber");



                Rooms r = new Rooms();
                all.add(r);
            }
        } catch (JSONException e)
        {

        }
        return all;
    }


    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;


        protected String doInBackground(Void... urls) {

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

        protected void onPostExecute (String response) {
            context.populateView(all);
        }

    }
}
