package com.aya.mqsimpleandroidmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapquest.mapping.maps.MapView;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;
    private MapboxMap map;
    private final LatLng SAN_FRAN = new LatLng(37.7749, -122.4194);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.mapquestMapView);
//        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;

                // create and add marker
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(SAN_FRAN);
                markerOptions.title("San Francisco");
                markerOptions.snippet("Welcome to Frisco!");
                map.addMarker(markerOptions);

                // set map center and zoom
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(SAN_FRAN, 14));

            }
        });
    }
}