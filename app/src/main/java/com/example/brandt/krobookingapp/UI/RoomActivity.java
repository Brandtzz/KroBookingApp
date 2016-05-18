package com.example.brandt.krobookingapp.UI;

import android.app.Activity;
import android.os.Bundle;
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
    ToggleButton isRented;
    ToggleButton isDoubleRoom;
    TextView isBathroom;
    EditText isPrice;
    ToggleButton isExtraBed;
    ToggleButton isAnimal;
    EditText isCustomerName;
    EditText isCustomerPhoneNumber;
    ToggleButton isKeybox;
    EditText isNotes;
    EditText isCustomerEmail;
    EditText isCompanyName;
    EditText isCompanyPhoneNumber;
    EditText isCompanyEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_room);


    }

    public void roomStatus(Rooms rooms) {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableRoom);
        TableRow tableRow = new TableRow(this);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(layoutParams);

        int roomNumber = rooms.getRoomNumber();
        boolean rented = rooms.isRented(); //må ændres
        boolean bathroom = rooms.isBathRoom();
        int price = rooms.getRoomPrice(); //må ændres

        Booking[] bookings = rooms.getBooking();

        for (Booking booking : bookings) {
            boolean extrabed = booking.isExtraBed(); //må ændres
            boolean animal = booking.isAnimal(); //må ændres
            boolean doubleRoom = booking.isDoubleRoom();

            Customer customer = booking.getCustemor();
            String customerName = customer.getCustomerName(); //må ændres
            String customerPhoneNumber = customer.getCustomerPhoneNumber(); //må ændres
            boolean keybox = customer.isKeybox(); //må ændres
            String notes = customer.getNotes(); //må ændres
            String customerEmail = customer.getCustemorEmail(); //må ændres

            Company company = customer.getCompany();
            String companyName = company.getCompanyName(); //må ændres
            String companyPhoneNumber = company.getCompanyPhoneNumber(); //må ændres
            String companyEmail = company.getCompanyEmail(); //må ændres

        }

        isRoomNumber = new TextView(this);
        isRented = new ToggleButton(this);
        isBathroom = new TextView(this);
        isPrice = new EditText(this);
        isExtraBed = new ToggleButton(this);
        isAnimal = new ToggleButton(this);
        isDoubleRoom = new ToggleButton(this);
        isCustomerName = new EditText(this);
        isCustomerPhoneNumber = new EditText(this);
        isKeybox = new ToggleButton(this);
        isNotes = new EditText(this);
        isCustomerEmail = new EditText(this);
        isCompanyName = new EditText(this);
        isCompanyPhoneNumber = new EditText(this);
        isCompanyEmail = new EditText(this);

        isRoomNumber.setText("You are now looking at room" + roomNumber);

        if(rented == true) {
            isRented.setChecked(true);
        }

        if (bathroom == true) {
            isBathroom.setText("There is a bathroom in this room");
        }
        else {
            isBathroom.setText("There is no bathroom in this room");
        }

        isPrice.setText("The price for this room is: " + price);

        tableRow.addView(isRoomNumber);
        tableRow.addView(isRented);
        tableRow.addView(isBathroom);
        tableRow.addView(isPrice);
        tableLayout.addView(tableRow);
    }
}
