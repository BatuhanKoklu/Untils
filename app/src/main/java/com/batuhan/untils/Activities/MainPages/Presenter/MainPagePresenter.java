package com.batuhan.untils.Activities.MainPages.Presenter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.batuhan.untils.Models.UserTrip;
import com.batuhan.untils.R;

public class MainPagePresenter {

    public MainPagePresenter() {
    }



    public void slideDown(ConstraintLayout constraintLayout) {
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                -100 - constraintLayout.getHeight(),                 // fromYDelta
                0); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        constraintLayout.startAnimation(animate);
    }

    public void slideUp(ConstraintLayout constraintLayout) {
        constraintLayout.setVisibility(ConstraintLayout.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,  // fromYDelta
                -100 - constraintLayout.getHeight());                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        constraintLayout.startAnimation(animate);
    }


}
