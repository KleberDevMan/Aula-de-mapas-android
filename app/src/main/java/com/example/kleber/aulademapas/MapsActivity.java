package com.example.kleber.aulademapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // busca a variavel de referencia para o mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;

        // ADD UM LOCAL ESPECIFICO
//        LatLng sydney = new LatLng(-10.272364763367074,-48.33098575316467);
//        mapa.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mapa.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // ADD UMA REGIAO
        LatLngBounds sydney = new LatLngBounds(new LatLng(-10.268319, -48.341222),new LatLng(-10.268286, -48.327133));
        mapa.addMarker(new MarkerOptions().position(new LatLng(-10.270616, -48.332431)).title("Marker in Sydney"));
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney.getCenter(), 15));

        mapa.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.i("mapa","teste");
        return false;
    }
}
