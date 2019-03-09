package com.batuhan.untils.Activities.Map.Presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapPresenter {

    private UserTrip userTrip;
    private UserTripView view;

    public MapPresenter(UserTripView view) {
        this.view = view;
        this.userTrip = new UserTrip();
    }

    public Bitmap getMarkerBitmapFromView(int tripImg , Context context) {
        View customMarkerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
        ImageView markerImageView = (ImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(tripImg);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }

    public Marker createMarker(double lat, double lng, String title, String snipptet, int photo , GoogleMap googleMap, Context context) {
        LatLng position = new LatLng(lat, lng);

        return googleMap.addMarker(new MarkerOptions().position(position).title(title)
                .snippet(snipptet)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(photo,context))));

    }

    public AlertDialog.Builder createAlertDialog(String message, int photo, String whereTo, String title , LayoutInflater layoutInflater , Context context) {
        View aoTasarim = layoutInflater.inflate(R.layout.alert_tasarim,null);

        ImageView imgAlert = aoTasarim.findViewById(R.id.imgAlert);
        imgAlert.setImageResource(photo);

        TextView txtWhereTo = aoTasarim.findViewById(R.id.txtWhereTo);
        TextView txtTitle = aoTasarim.findViewById(R.id.txtTitle);

        txtWhereTo.setText(whereTo);
        txtTitle.setText(title);

        AlertDialog.Builder ao = new AlertDialog.Builder(context);

        ao.setView(aoTasarim);


        return ao;
    }

    public void setCameraPosition(double lat, double lng, int zoom, GoogleMap googleMap) {

        LatLng latLng = new LatLng(lat,lng);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(zoom).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public interface UserTripView {

        Bitmap getMarkerBitmapFromView(@DrawableRes int resId , Context context);

        Marker createMarker(double lat, double lng, String title, String snipptet, int photo , GoogleMap googleMap , Context context);

        AlertDialog.Builder createAlertDialog(String message , int photo, String whereTo , String title , LayoutInflater layoutInflater , Context context);

        void setCameraPosition(double lat,double lng, int zoom , GoogleMap googleMap);

    }
}
