package com.batuhan.untils.Activities.Profile.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.batuhan.untils.Helpers.Helper;
import com.batuhan.untils.R;

public class ActivityProfile extends Fragment {

    private Button  btnHelp , btnUpdate;
    private ImageButton btnChooseImage;
    private EditText etxtUsername , etxtEmail , etxtPassword;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_profile, container, false);

        Bitmap resultBmp = Helper.BlurBuilder.blur(getActivity(), BitmapFactory.decodeResource(getResources(), R.mipmap.background_white));
        Drawable d = new BitmapDrawable(getResources(), resultBmp);
        //view.setBackground(d);
        view.getBackground().setAlpha(175);

        btnChooseImage = view.findViewById(R.id.btnChooseImage);
        btnHelp = view.findViewById(R.id.btnHelp);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        etxtUsername = view.findViewById(R.id.etxtUsername);
        etxtEmail = view.findViewById(R.id.etxtEmail);
        etxtPassword = view.findViewById(R.id.etxtPassword);








        return view;
    }
}
