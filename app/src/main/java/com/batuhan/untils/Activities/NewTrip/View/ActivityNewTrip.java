package com.batuhan.untils.Activities.NewTrip.View;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;

import com.batuhan.untils.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityNewTrip extends Fragment {

    private  PlaceAutocompleteFragment placeAutocompleteFragment;
    private GoogleMap mMap;
    Marker marker;
    private EditText etxtTripName , etxtFrom , etxtTo , etxtContent;
    private Button btnShare;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_new_trip, container, false);

        etxtTripName = view.findViewById(R.id.etxtTripName);
        etxtFrom = view.findViewById(R.id.etxtFrom);
        etxtTo = view.findViewById(R.id.etxtTo);
        etxtContent = view.findViewById(R.id.etxtContent);
        btnShare = view.findViewById(R.id.btnShare);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation animate = new ScaleAnimation(1, 1, 1, 8, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                animate.setDuration(700);
                animate.setFillAfter(true);
                etxtContent.startAnimation(animate);

                ScaleAnimation animate2 = new ScaleAnimation(1, 1, 8, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                animate2.setStartOffset(900);
                animate2.setDuration(700);
                animate2.setFillAfter(true);
                etxtContent.startAnimation(animate2);

                etxtContent.setHint("Write Your Experiences");
            }
        });





        return view;
    }


}
