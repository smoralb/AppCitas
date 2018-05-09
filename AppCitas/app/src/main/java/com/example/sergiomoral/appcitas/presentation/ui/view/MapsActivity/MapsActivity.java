package com.example.sergiomoral.appcitas.presentation.ui.view.MapsActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Office;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by sergiomoral on 2/5/18.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Office commerce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_location_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        commerce = getIntent().getParcelableExtra(BuildData.LOCATION);

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
        LatLng position = new LatLng(commerce.getLatitud(), commerce.getLongitud());
        mMap.addMarker(new MarkerOptions().position(position).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));

    }
}
