package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final String TAG = HomePage.class.getSimpleName();
    private String mSpinnerLabel = "";
    private String dateMessage1 = "";
    private String dateMessage2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Create the Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_kamar);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    //Date Picker Dialog
    public void showDatePickerDialog1(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    public void showDatePickerDialog2(View v) {
        DialogFragment newFragment = new DatePickerFragment2();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    public void processDatePickerResultCheckin(int year1, int month1, int day1) {
        String month_string1 = Integer.toString(month1+1);
        String day_string1 = Integer.toString(day1);
        String year_string1 = Integer.toString(year1);
        this.dateMessage1 = (day_string1 + "/" + month_string1 + "/" + year_string1);
        TextView checkinDate = (TextView) findViewById(R.id.checkin_confirm);
        checkinDate.setText("Tanggal Check - In: " + dateMessage1);
    }

    public void processDatePickerResultCheckout(int year2, int month2, int day2) {
        String month_string2 = Integer.toString(month2+1);
        String day_string2 = Integer.toString(day2);
        String year_string2 = Integer.toString(year2);
        this.dateMessage2 = (day_string2 + "/" + month_string2 + "/" + year_string2);
        TextView checkoutDate = (TextView) findViewById(R.id.checkout_confirm);
        checkoutDate.setText("Tanggal Check - Out: " + dateMessage2);
    }

    //Spinner Item Selected
    public void showText(View view) {
        String showString = (mSpinnerLabel);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }

    public void cariHotel(View view) {
        Intent messageIntent1 = new Intent(this, ListHotel.class);
        messageIntent1.putExtra("checkin", dateMessage1);
        messageIntent1.putExtra("checkout", dateMessage2);
        messageIntent1.putExtra("kamar", mSpinnerLabel);
        startActivity(messageIntent1);
    }

    public void logout(View view) {
        Intent messageIntent2 = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Berhasil Keluar",
                Toast.LENGTH_SHORT).show();

        startActivity(messageIntent2);
    }

    public void cekLokasi(View view) {
        Intent lokasi = new Intent(this, MapsActivity.class);
        Toast.makeText(getApplicationContext(), "Cek Lokasi Hotel",
                Toast.LENGTH_SHORT).show();
        startActivity(lokasi);
    }
}