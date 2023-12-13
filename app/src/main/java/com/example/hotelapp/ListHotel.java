package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListHotel extends AppCompatActivity  implements RecyclerViewInterface{
    RecyclerView recyclerView;
    HotelAdapter adapter;

    List<Hotel> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        final TextView cin = (TextView) findViewById(R.id.text_checkin);
        final TextView cout = (TextView) findViewById(R.id.text_checkout);
        final TextView kam = (TextView) findViewById(R.id.kamar);

        Intent intent = getIntent();
        String output1 = intent.getStringExtra("checkin");
        String output2 = intent.getStringExtra("checkout");
        String output3 = intent.getStringExtra("kamar");

        cin.setText("Tanggal Check - In = " + output1);
        cout.setText("Tanggal Check - Out = " + output2);
        kam.setText("Jumlah Kamar yang Dipesan = " + output3);

        hotelList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hotelList.add(
                new Hotel(
                        1, "Grand Mercure Yogyakarta",
                        "Jl. Laksda Adisucipto No.80, Demangan Baru, Caturtunggal",
                        "Rp. 600.000 - Rp. 1.200.000 / malam",
                        R.drawable.mercure)
                );
        hotelList.add(
                new Hotel(
                        1, "Artotel Suites Bianti Yogyakarta",
                        "Jl. Urip Sumoharjo No.37, Klitren, Kec. Gondokusuman",
                        "Rp. 750.000 - Rp. 1.000.000 / malam",
                        R.drawable.artotel)
        );
        hotelList.add(
                new Hotel(
                        1, "Hyatt Regency Yogyakarta",
                        "Jl. Palagan Tentara Pelajar, Panggung Sari, Sariharjo, Kec. Ngaglik",
                        "Rp. 1.800.000 - Rp. 2.500.000 / malam",
                        R.drawable.hyatt)
        );
        hotelList.add(
                new Hotel(
                        1, "Royal Ambarrukmo Yogyakarta",
                        "Jl. Laksda Adisucipto No.81, Ambarukmo, Caturtunggal, Kec. Depok",
                        "Rp. 1.300.000 - Rp. 2.000.000 / malam",
                        R.drawable.royal)
        );
        hotelList.add(
                new Hotel(
                        1, "Hotel Tentrem Yogyakarta",
                        "Jl. P. Mangkubumi No.72A, Cokrodiningratan, Kec. Jetis",
                        "Rp. 1.600.000 - Rp. 2.800.000 / malam",
                        R.drawable.tentrem)
        );
        hotelList.add(
                new Hotel(
                        1, "The Phoenix Hotel Yogyakarta",
                        "Jl. Jend. Sudirman No.9, Cokrodiningratan, Kec. Jetis",
                        "Rp. 800.000 - Rp. 1.100.000 / malam",
                        R.drawable.phoenix)
        );
        hotelList.add(
                new Hotel(
                        1, "Hotel Melia Purosani Yogyakarta",
                        "Jl. Mayor Suryotomo No.31, Ngupasan, Kec. Gondomanan",
                        "Rp. 1.100.000 - Rp. 4.000.000 / malam",
                        R.drawable.melia)
        );
        hotelList.add(
                new Hotel(
                        1, "Lafayette Boutique Hotel Yogyakarta",
                        "Manggung, Caturtunggal, Kec. Depok",
                        "Rp. 800.000 - Rp. 9.000.000 / malam",
                        R.drawable.lafayette)
        );
        adapter = new HotelAdapter(this, hotelList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, HotelDesc.class);

        intent.putExtra("nama", hotelList.get(position).getName());
        intent.putExtra("desc", hotelList.get(position).getShortDesc());
        intent.putExtra("harga", hotelList.get(position).getPrice());
        intent.putExtra("img", hotelList.get(position).getImage());

        startActivity(intent);
    }
}