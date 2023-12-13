package com.example.hotelapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.hotelapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng mercure = new LatLng(-7.783428879029003, 110.39235518292475);
        mMap.addMarker(new MarkerOptions().position(mercure).title("Grand Mercure Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mercure));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mercure, 13));

        LatLng artotel = new LatLng(-7.782676788431046, 110.3819054699041);
        mMap.addMarker(new MarkerOptions().position(artotel).title("Artotel Suites Bianti Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(artotel));

        LatLng hyatt = new LatLng(-7.740211973456186, 110.37359251412012);
        mMap.addMarker(new MarkerOptions().position(hyatt).title("Hyatt Regency Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hyatt));

        LatLng royal = new LatLng(-7.782228368201624, 110.40307245684818);
        mMap.addMarker(new MarkerOptions().position(royal).title("Royal Ambarrukmo Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(royal));

        LatLng tentrem = new LatLng(-7.773549532595066, 110.36846676964076);
        mMap.addMarker(new MarkerOptions().position(tentrem).title("Hotel Tentrem Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tentrem));

        LatLng phoenix = new LatLng(-7.782399458329066, 110.36848514098196);
        mMap.addMarker(new MarkerOptions().position(phoenix).title("The Phoenix Hotel Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(phoenix));

        LatLng melia = new LatLng(-7.797151825466489,  110.36896834107333);
        mMap.addMarker(new MarkerOptions().position(melia).title("Hotel Melia Purosani Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(melia));

        LatLng lafayette = new LatLng(-7.759257345824472, 110.3873571564713);
        mMap.addMarker(new MarkerOptions().position(lafayette).title("Lafayette Boutique Hotel  Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lafayette));

    }
}