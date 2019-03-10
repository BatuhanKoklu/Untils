package com.batuhan.untils.Activities.Map.Activity;

import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.batuhan.untils.Models.User;
import com.batuhan.untils.Activities.Map.MapPresenter;
import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends Fragment implements MapPresenter.MapView {

    MapView mMapView;
    private GoogleMap googleMap;
    private Marker marker;
    private MapPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); // Klayveyle açılmasını engelleme

        View view = inflater.inflate(R.layout.activity_maps, container, false);

        presenter = new MapPresenter(this);

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        final User user1 = new User(1,"Batuhan","btn@hotmail.com","12345","http://www.morningstarskitours.com/wp-content/uploads/2013/07/Dan-Ski-Man-Morning-star-skis2.jpg",null);
        final UserTrip user1Trip1 = new UserTrip(1,user1.getUserId(),"Bansko Tatilim","Istanbul to Bansko",40.9903,29.0205,"Kar Tatilimizin bir özeti...",null);
        List<UserTrip> user1TripList = new ArrayList<>();
        user1TripList.add(user1Trip1);
        user1.setUserTripList(user1TripList);



        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                final Marker m1 = presenter.addCustomMarker(user1,googleMap,getActivity(),getLayoutInflater());


                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public boolean onMarkerClick(Marker marker) {


                        if(marker.equals(m1)){
                            AlertDialog.Builder adb1 = presenter.createTripAlertDialog(getLayoutInflater(),getActivity(),user1);

                            adb1.setPositiveButton("Go In", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });


                            adb1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            adb1.create().show();
                        }
                        /*else if(marker.equals(m2)){
                            AlertDialog.Builder adb2 = createAlertDialog("Bansko",R.mipmap.ppdeneme,"Istanbul To Bansko","Bansko kayak tatilim",getLayoutInflater(),getActivity());

                            adb2.setPositiveButton("Go In", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            adb2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            adb2.create().show();

                        }*/


                        return false;
                    }
                });

                zoomToCustomMarker(googleMap,41.015137,28.979530,12);
            }
        });

        return view;
    }






    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void zoomToCustomMarker(GoogleMap googleMap, double lat, double lng , int zoomScale) {
        // For zooming automatically to the location of the marker
        LatLng position = new LatLng(lat, lng);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(position).zoom(zoomScale).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
