package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HotelDesc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_desc);

        final TextView name = findViewById(R.id.name_desc);
        final TextView description = findViewById(R.id.desc_desc);
        final TextView price = findViewById(R.id.price_desc);
        final ImageView image = findViewById(R.id.image_desc);
        Button bsimpan = (Button) findViewById(R.id.button_pesan);

        Intent intent = getIntent();
        String nama1 = intent.getStringExtra("nama");
        String desc1 = intent.getStringExtra("desc");
        String harga1 = intent.getStringExtra("harga");
        int img1 = intent.getIntExtra("img", 0);

        name.setText(nama1);;
        description.setText(desc1);
        price.setText(harga1);
        image.setImageResource(img1);

        bsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent berhasil = new Intent(HotelDesc.this, HomePage.class);
                Toast.makeText(getApplicationContext(), "Hotel Berhasil Dipesan!",
                        Toast.LENGTH_SHORT).show();

                startActivity(berhasil);
            }
        });
    }
}