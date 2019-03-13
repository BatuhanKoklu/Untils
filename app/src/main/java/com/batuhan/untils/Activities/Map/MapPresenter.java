package com.batuhan.untils.Activities.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.batuhan.untils.Models.User;
import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MapPresenter {

    private UserTrip userTrip;
    private MapView mapView;

    public MapPresenter(MapView mapView) {
        this.userTrip = new UserTrip();
        this.mapView = mapView;
    }





    public void urlToImage(String url , final ImageView imageView , final Context context){

         Picasso.get()
                .load(url)
                .placeholder(R.drawable.icon_person)
                .error(R.drawable.icon_error)
                .into(imageView);

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public AlertDialog.Builder createTripAlertDialog(LayoutInflater layoutInflater, Context context, UserTrip userTrip) {

        View aoTasarim = layoutInflater.inflate(R.layout.alert_tasarim,null);

        ImageView imgAlert = aoTasarim.findViewById(R.id.imgAlert);

        TextView txtWhereTo = aoTasarim.findViewById(R.id.txtWhereTo);

        TextView txtTitle = aoTasarim.findViewById(R.id.txtTitle);

        urlToImage(userTrip.getTripImage(),imgAlert,context);//imgAlerte resim yükleme
        txtWhereTo.setText(userTrip.getWhereTo());
        txtTitle.setText(userTrip.getTripName());

        AlertDialog.Builder ao = new AlertDialog.Builder(context);

        ao.setView(aoTasarim);

        return ao;
    }

    public Marker addCustomMarker(UserTrip userTrip, GoogleMap googleMap, Context context , LayoutInflater layoutInflater){

        LatLng position = new LatLng(userTrip.getLat(), userTrip.getLng());

        Bitmap bitmap = Bitmap.createScaledBitmap(getMarkerBitmapFromView(layoutInflater,context,userTrip),240,280,false);

        Marker marker = googleMap.addMarker(new MarkerOptions()
                .position(position)
                .icon(BitmapDescriptorFactory.fromBitmap(bitmap)));


        return marker;
    }







    private Bitmap getMarkerBitmapFromView(LayoutInflater layoutInflater , Context context , UserTrip userTrip) {

        View customMarkerView = layoutInflater.inflate(R.layout.view_custom_marker,null);
        //View customMarkerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
        ImageView markerImageView = (ImageView) customMarkerView.findViewById(R.id.profile_image);
        urlToImage(userTrip.getTripImage(),markerImageView,context);
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

    public interface MapView{
        void zoomToCustomMarker(GoogleMap googleMap,double lat, double lng , int zoomScale);
    }
}
