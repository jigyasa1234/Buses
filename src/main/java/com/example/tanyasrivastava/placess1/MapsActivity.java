package com.example.tanyasrivastava.placess1;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button mButton;
    float lat   = (float)28.6295406;
    float lng   = (float)77.3725048371457;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mButton = (Button)findViewById(R.id.find);

    }


    public  void findbus(View view)
    {

      StringBuilder stringBuilder= new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
      stringBuilder.append("location="+lat+","+lng);
      stringBuilder.append("&radius="+1500);
        stringBuilder.append("&type="+"transit_station");
      //stringBuilder.append("&keyword="+"bus_station");
      stringBuilder.append("&key="+"AIzaSyAnbNZrnr0cfOB0ba15vcIjCxfn8-3Dt3s");


      String url=stringBuilder.toString();
        Log.i("blah",url);
      Object dataTransfer[]=new Object[2];
      dataTransfer[0]=mMap;
      dataTransfer[1]=url;


      nearby nrby=new nearby();
        nrby.execute(dataTransfer);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}

