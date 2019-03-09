package com.batuhan.untils.Activities.Welcome.View;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.batuhan.untils.Activities.MainPages.View.GirisActivity;
import com.batuhan.untils.Activities.FirstPages.View.MainPagesActivity;
import com.batuhan.untils.R;

public class MainActivity extends Fragment {

    private Button buttonMainSignIn , buttonMainSignUp , buttonMainQuestionMark;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_main,container,false);

        buttonMainSignIn = view.findViewById(R.id.buttonMainSignIn);
        buttonMainSignUp = view.findViewById(R.id.buttonMainSignUp);
        buttonMainQuestionMark = view.findViewById(R.id.buttonMainQuestionMark);
        tabLayout = view.findViewById(R.id.tabLayout);


        //Button ile kaydır
        buttonMainSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(),GirisActivity.class);
                startActivity(i);
                //MainPagesActivity.viewPager.setCurrentItem(0,true);

            }
        });
        //Button ile kaydır
        buttonMainSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainPagesActivity.viewPager.setCurrentItem(2,true);

            }
        });




        return view;


    }

    //Short Toast Olusturma
    public void makeShortToast(String text){
        Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
    }




}
