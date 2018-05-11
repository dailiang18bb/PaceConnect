package com.example.android.paceconnect;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.map_page);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     * <p>
     * 41.1286° N, 73.8078° W
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Pace Pleasantville
        // and move the map's camera to the same location.

        LatLng PacePLV = new LatLng(41.1286, -73.8078);
        googleMap.addMarker(new MarkerOptions().position(PacePLV)
                .title("Pace Pleasantville"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(PacePLV));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));

        // enable my location button
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Log.v("MapActivity", "goooooooooooood");
            googleMap.setMyLocationEnabled(true);
        } else {
            Log.v("MapActivity", "faiiiiiiiil");

        }
    }
}
