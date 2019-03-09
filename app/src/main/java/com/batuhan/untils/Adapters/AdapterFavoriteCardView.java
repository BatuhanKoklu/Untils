package com.batuhan.untils.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.batuhan.untils.Helpers.Helper;
import com.batuhan.untils.Models.User;
import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;

import java.util.ArrayList;

public class AdapterFavoriteCardView extends  RecyclerView.Adapter<AdapterFavoriteCardView.CardTasarimTutucu> {

    private Context mContext;
    private ArrayList<UserTrip> userTripList;
    private Helper helper;

    public AdapterFavoriteCardView(Context mContext, ArrayList<UserTrip> userTripList) {
        this.mContext = mContext;
        this.userTripList = userTripList;
    }


    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_favorite,viewGroup,false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        helper = new Helper();

        UserTrip userTrip = userTripList.get(position);

        holder.txtTripName.setText(userTrip.getTripName());

        helper.urlToImage(userTrip.g);

        holder.imgProfile.setBackgroundResource(helper.urlToImage());
        //helper.urlToImage(user.getUserImage(),holder.imgProfile,mContext);
    }

    @Override
    public int getItemCount() {
        return userTripList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private ImageView imgProfile;
        private TextView txtTripName;
        private Button btnShowOnMap;

        public CardTasarimTutucu(View view){
            super(view);
            imgProfile = view.findViewById(R.id.imgProfile);
            txtTripName = view.findViewById(R.id.txtTripName);
            btnShowOnMap = view.findViewById(R.id.btnShowOnMap);
        }
    }


    /*extends RecyclerView.Adapter<AdapterFavoriteCardView.CardTasarimTutucu> {

    private Context mContext;
    private ArrayList<UserTrip> userTripList;
    private Helper helper;

    public AdapterFavoriteCardView(Context mContext, ArrayList<UserTrip> userTripList){
        this.mContext = mContext;
        this.userTripList = userTripList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_favorite,viewGroup,false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        UserTrip userTrip = new UserTrip();

        User user = new User();

        userTrip = userTripList.get(position);

        holder.txtTripName.setText(userTrip.getTripName());

        holder.imgProfile.setBackgroundResource(R.mipmap.ppdeneme);
        //helper.urlToImage(user.getUserImage(),holder.imgProfile,mContext);


    }

    @Override
    public int getItemCount() {
        return userTripList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private ImageView imgProfile;
        private TextView txtTripName;
        private Button btnShowOnMap;

        public CardTasarimTutucu(View view){
            super(view);
            imgProfile = view.findViewById(R.id.imgProfile);
            txtTripName = view.findViewById(R.id.txtTripName);
            btnShowOnMap = view.findViewById(R.id.btnShowOnMap);
        }
    }*/


}
