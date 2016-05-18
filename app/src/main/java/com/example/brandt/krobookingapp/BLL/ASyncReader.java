package com.example.brandt.krobookingapp.BLL;

import android.os.AsyncTask;
import android.util.Log;

import com.example.brandt.krobookingapp.BE.Booking;
import com.example.brandt.krobookingapp.BE.Company;
import com.example.brandt.krobookingapp.BE.Customer;
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
    JSONArray jsonArray;

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
                   int roomNumber = room.getInt("roomNumber");
                   boolean rented = room.getBoolean("rented");
                   boolean bathRoom = room.getBoolean("bathRoom");
                   int roomPrice = room.getInt("roomPrice");

                   if(room.getJSONArray("bookings").length() != 0){
                 //  JSONObject booking = room.getJSONArray("bookings").getJSONObject(i);
                   for (int n = 0; n < room.getJSONArray("bookings").length(); n++) {
                       JSONObject booking = room.getJSONArray("bookings").getJSONObject(n);
                       boolean doubleRoom = booking.getBoolean("double");
                       boolean extraBed = booking.getBoolean("extraBed");
                       boolean animal = booking.getBoolean("animal");

                       JSONObject customer = booking.getJSONObject("customer");
                       String customerName = customer.getString("customerName");
                       String customerPhoneNumber = customer.getString("customerPhoneNumber");
                       boolean keybox = customer.getBoolean("keybox");
                       String notes = customer.getString("notes");
                       String customerEmail = customer.getString("customerEmail");

                       JSONObject company = customer.getJSONObject("company");
                       String companyName = company.getString("companyName");
                       String companyPhoneNumber = company.getString("companyPhoneNumber");
                       String companyEmail = company.getString("companyEmail");


                   Company co = new Company(companyName,companyPhoneNumber,companyEmail);
                   Customer cu = new Customer(customerName,customerPhoneNumber,keybox,notes,customerEmail,co);
                   Booking[] bu = new Booking[]{new Booking(extraBed,animal,doubleRoom,cu)};
                   Rooms r = new Rooms(id,roomNumber,rented,bathRoom,roomPrice,bu);
                   all.add(r);
               } }
               else{
                       Rooms r = new Rooms(id,roomNumber,rented,bathRoom,roomPrice);
                       all.add(r);
                   }
               }

           } catch (JSONException e)
           {
                Log.d("XYZ","jsonerror: " + e.getMessage());
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
