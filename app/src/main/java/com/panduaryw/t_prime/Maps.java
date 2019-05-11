package com.panduaryw.t_prime;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private GoogleMap mMap;
    String[] pool = new String[] {
            "Primajasa Pool Caringin",
            "Primajasa Pool Cawang"};
    String [] alamat= new String[]{
            "Jalan Soekarano Hatta No.181, Babakan Ciparay, Kota Bandung, Jawa Barat 40223",
            "Jalan Mayjen Sutoyo, Kramatjati, Kota Jakarta Timur"};
    //private AppLocationService appLocationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //listviewc
        customList customlist = new customList(this, pool, alamat);

        mainListView = (ListView) findViewById(R.id.mainListView);
        mainListView.setAdapter(customlist);

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

        LatLng cawang = new LatLng(-6.257558, 106.869233);
        LatLng caringin = new LatLng(-6.940132, 107.581972);
        mMap.addMarker(new MarkerOptions().position(cawang).title("Primajasa Pool Cawang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cawang));
        mMap.addMarker(new MarkerOptions().position(caringin).title("Primajasa Pool Caringin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caringin));

    }
}
