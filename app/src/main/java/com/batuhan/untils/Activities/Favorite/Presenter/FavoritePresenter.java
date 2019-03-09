package com.batuhan.untils.Activities.Favorite.Presenter;

import android.content.Context;
import android.widget.ImageView;

import com.batuhan.untils.Helpers.Helper;
import com.batuhan.untils.Models.User;
import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoritePresenter {

    private Helper helper;
    private User user;
    private UserTrip userTrip;


    public FavoritePresenter(Helper helper, User user, UserTrip userTrip) {
        this.helper = helper;
        this.user = user;
        this.userTrip = userTrip;
    }

    public FavoritePresenter() {
    }


}
