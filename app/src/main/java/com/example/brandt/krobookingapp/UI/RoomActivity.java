package com.example.brandt.krobookingapp.UI;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.brandt.krobookingapp.BE.Booking;
import com.example.brandt.krobookingapp.BE.Company;
import com.example.brandt.krobookingapp.BE.Customer;
import com.example.brandt.krobookingapp.BE.Rooms;
import com.example.brandt.krobookingapp.R;

/**
 * Created by Frederik on 16-05-2016.
 */
public class RoomActivity extends Activity {

    TextView isRoomNumber;
    TextView isRented;
    TextView isDoubleRoom;
    TextView isBathroom;
    TextView isPrice;
    TextView isExtraBed;
    TextView isAnimal;
    TextView isCustomerName;
    TextView isCustomerPhoneNumber;
    TextView isKeybox;
    TextView isNotes;
    TextView isCustomerEmail;
    TextView isCompanyName;
    TextView isCompanyPhoneNumber;
    TextView isCompanyEmail;

    Rooms rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_room);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("NEW", "Table row " + R.id.tableRoom);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableRoom);

        TableRow tableRow1 = new TableRow(this);
        TableRow tableRow2 = new TableRow(this);
        TableRow tableRow3 = new TableRow(this);
        TableRow tableRow4 = new TableRow(this);
        TableRow tableRow5 = new TableRow(this);
        TableRow tableRow6 = new TableRow(this);
        TableRow tableRow7 = new TableRow(this);
        TableRow tableRow8 = new TableRow(this);
        TableRow tableRow9 = new TableRow(this);
        TableRow tableRow10 = new TableRow(this);
        TableRow tableRow11 = new TableRow(this);
        TableRow tableRow12 = new TableRow(this);
        TableRow tableRow13 = new TableRow(this);
        TableRow tableRow14 = new TableRow(this);
        TableRow tableRow15 = new TableRow(this);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow1.setLayoutParams(layoutParams);
        tableRow2.setLayoutParams(layoutParams);
        tableRow3.setLayoutParams(layoutParams);
        tableRow4.setLayoutParams(layoutParams);
        tableRow5.setLayoutParams(layoutParams);
        tableRow6.setLayoutParams(layoutParams);
        tableRow7.setLayoutParams(layoutParams);
        tableRow8.setLayoutParams(layoutParams);
        tableRow9.setLayoutParams(layoutParams);
        tableRow10.setLayoutParams(layoutParams);
        tableRow11.setLayoutParams(layoutParams);
        tableRow12.setLayoutParams(layoutParams);
        tableRow13.setLayoutParams(layoutParams);
        tableRow14.setLayoutParams(layoutParams);
        tableRow15.setLayoutParams(layoutParams);

        rooms = (Rooms) getIntent().getSerializableExtra("room");
        int roomNumber = rooms.getRoomNumber();
        boolean rented = rooms.isRented();
        boolean bathroom = rooms.isBathRoom();
        int price = rooms.getRoomPrice();

        Booking[] bookings = rooms.getBooking();

        if (bookings != null) {
            for (Booking booking : bookings) {
                boolean extrabed = booking.isExtraBed();
                boolean animal = booking.isAnimal();
                boolean doubleRoom = booking.isDoubleRoom();

                Customer customer = booking.getCustemor();
                String customerName = customer.getCustomerName();
                String customerPhoneNumber = customer.getCustomerPhoneNumber();
                boolean keybox = customer.isKeybox();
                String notes = customer.getNotes();
                String customerEmail = customer.getCustemorEmail();

                Company company = customer.getCompany();
                String companyName = company.getCompanyName();
                String companyPhoneNumber = company.getCompanyPhoneNumber();
                String companyEmail = company.getCompanyEmail();


                isRoomNumber = new TextView(this);
                isRented = new TextView(this);
                isBathroom = new TextView(this);
                isPrice = new TextView(this);
                isExtraBed = new TextView(this);
                isAnimal = new TextView(this);
                isDoubleRoom = new TextView(this);
                isCustomerName = new TextView(this);
                isCustomerPhoneNumber = new TextView(this);
                isKeybox = new TextView(this);
                isNotes = new TextView(this);
                isCustomerEmail = new TextView(this);
                isCompanyName = new TextView(this);
                isCompanyPhoneNumber = new TextView(this);
                isCompanyEmail = new TextView(this);

                isRoomNumber.setText("\n Værelses nummer: " + roomNumber);

                if (rented) {
                    isRented.setText("\n Dette rum er booket ");
                }

                if (bathroom) {
                    isBathroom.setText("\n Bad på værelset ");
                } else {
                    isBathroom.setText("\n Bad på gangen ");
                }

                isPrice.setText("\n Pris: " + price);

                if (extrabed){
                    isExtraBed.setText("\n Opredning ");
                } else {
                    isExtraBed.setText("\n Uden opredning ");
                }

                if (animal) {
                    isAnimal.setText("\n Kunden medbringer dyr ");
                }

                if (doubleRoom) {
                    isDoubleRoom.setText("\n Dobbeltværelse ");
                } else {
                    isDoubleRoom.setText("\n Enkeltværelse ");
                }

                isCustomerName.setText("\n Kundes navn: " + customerName);

                isCustomerPhoneNumber.setText("\n Kundes telefonnummer: " + customerPhoneNumber);

                if (keybox) {
                    isKeybox.setText("\n Nøgle i nøgleboks ");
                }

                if(notes != null) {
                    isNotes.setText("\n Noter: " + notes);
                }

                isCustomerEmail.setText("\n Kundes email: " + customerEmail);

                if(company != null) {
                    isCompanyName.setText("\n Firma navn: " + companyName);

                    isCompanyPhoneNumber.setText("\n Firma telefonnummer: " + companyPhoneNumber);

                    isCompanyEmail.setText("\n Firma email: " + companyEmail);
                }

                tableRow1.addView(isRoomNumber);
                tableRow2.addView(isRented);
                tableRow3.addView(isBathroom);
                tableRow4.addView(isPrice);
                tableRow5.addView(isExtraBed);
                tableRow6.addView(isAnimal);
                tableRow7.addView(isDoubleRoom);
                tableRow8.addView(isCustomerName);
                tableRow9.addView(isCustomerPhoneNumber);
                tableRow10.addView(isKeybox);
                tableRow11.addView(isNotes);
                tableRow12.addView(isCustomerEmail);
                tableRow13.addView(isCompanyName);
                tableRow14.addView(isCompanyPhoneNumber);
                tableRow15.addView(isCompanyEmail);

                tableLayout.addView(tableRow1);
                tableLayout.addView(tableRow2);
                tableLayout.addView(tableRow3);
                tableLayout.addView(tableRow4);
                tableLayout.addView(tableRow5);
                tableLayout.addView(tableRow6);
                tableLayout.addView(tableRow7);
                tableLayout.addView(tableRow8);
                tableLayout.addView(tableRow9);
                tableLayout.addView(tableRow10);
                tableLayout.addView(tableRow11);
                tableLayout.addView(tableRow12);
                tableLayout.addView(tableRow13);
                tableLayout.addView(tableRow14);
                tableLayout.addView(tableRow15);
            }
        }
    }
}
