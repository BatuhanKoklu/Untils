package com.batuhan.untils.Activities.Favorite.View;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.batuhan.untils.Adapters.AdapterFavoriteCardView;
import com.batuhan.untils.Models.User;
import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityFavorite extends Fragment {

    private RecyclerView favoriteRv;
    private AdapterFavoriteCardView adapter;
    private ArrayList<UserTrip> userTripArrayList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_favorite,container,false);

        favoriteRv = view.findViewById(R.id.favoriteRv);

        favoriteRv.setHasFixedSize(true);
        favoriteRv.setLayoutManager(new LinearLayoutManager(getActivity()));

        userTripArrayList = new ArrayList<UserTrip>();

        final User user1 = new User(1,"Batuhan","btn@hotmail.com","12345","http://www.morningstarskitours.com/wp-content/uploads/2013/07/Dan-Ski-Man-Morning-star-skis2.jpg",null);
        final UserTrip user1Trip1 = new UserTrip(1,user1.getUserId(),"Bansko Tatilim","Istanbul to Bansko",40.9903,29.0205,"Kar Tatilimizin bir özeti...");
        List<UserTrip> user1TripList = new ArrayList<>();
        user1TripList.add(user1Trip1);
        user1.setUserTripList(user1TripList);

        User u1 = new User(1,"Barış","bar@htm.com","123123","https://coresites-cdn.factorymedia.com/mpora_new/wp-content/uploads/2016/02/Josie-Millard2.jpg",null);
        UserTrip userTrip = new UserTrip();

        userTripArrayList.add(userTrip);

        adapter  = new AdapterFavoriteCardView(getActivity(),userTripArrayList);
        favoriteRv.setAdapter(adapter);





        return view;
    }

    }
