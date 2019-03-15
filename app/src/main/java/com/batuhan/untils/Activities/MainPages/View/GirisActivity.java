package com.batuhan.untils.Activities.MainPages.View;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.batuhan.untils.Activities.Favorite.View.ActivityFavorite;
import com.batuhan.untils.Activities.MainPages.Presenter.MainPagePresenter;
import com.batuhan.untils.Activities.Map.Activity.MapsActivity;
import com.batuhan.untils.Activities.NewTrip.View.ActivityNewTrip;
import com.batuhan.untils.Adapters.MyAdapter;
import com.batuhan.untils.Activities.Profile.View.ActivityProfile;
import com.batuhan.untils.R;

public class GirisActivity extends AppCompatActivity  {

    public static TabLayout tabLayout;
    public static ViewPager viewPagerGiris;
    private ImageButton btnHome,btnMap,btnNew,btnFavorite,btnProfile,btnSearch;
    private EditText etxtWhereNow;
    private ConstraintLayout ustTab;
    boolean isUp;
    private MainPagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        btnProfile = findViewById(R.id.btnProfile);
        btnHome = findViewById(R.id.btnHome);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnMap = findViewById(R.id.btnMap);
        btnNew = findViewById(R.id.btnNew);

        etxtWhereNow = findViewById(R.id.etxtWhereNow);

        ustTab = findViewById(R.id.ustTab);

        tabLayout = findViewById(R.id.tablayoutGiris);
        viewPagerGiris = findViewById(R.id.viewpagerGiris);

        presenter = new MainPagePresenter();

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        //Tablara Fragment Ekleme
        adapter.fragmentEkle(new MapsActivity(),"Map");// 0
        adapter.fragmentEkle(new ActivityFavorite(),"Favorite");//1
        adapter.fragmentEkle(new ActivityProfile(), "Profile");//2

        viewPagerGiris.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPagerGiris);

        TabLayout.Tab tab = tabLayout.getTabAt(0); //Başlangıç sayfası seçmek için
        tab.select();




        isUp = false;

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Eget Sayfa Home ise
                if(GirisActivity.viewPagerGiris.getCurrentItem() == 0){

                    //Sayfa Favori ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 1){
                    etxtWhereNow.setText("Where To?");
                    GirisActivity.viewPagerGiris.setCurrentItem(0,true);

                    //Sayfa Profil ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 2){
                    GirisActivity.viewPagerGiris.setCurrentItem(0,true);
                    etxtWhereNow.setText("Where To?");
                    presenter.slideDown(ustTab);
                    isUp = !isUp;
                }

            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View aoTasarim = getLayoutInflater().inflate(R.layout.alert_filter_tasarim,null);

                Button btnAoSearch = aoTasarim.findViewById(R.id.btnAlertSearch);

                EditText etxtAlertFrom = aoTasarim.findViewById(R.id.etxtAlertFrom);
                EditText etxtAlertTo = aoTasarim.findViewById(R.id.etxtAlertTo);

                AlertDialog.Builder ao = new AlertDialog.Builder(GirisActivity.this);

                ao.setView(aoTasarim);


                //Eget Sayfa Home ise
                if(GirisActivity.viewPagerGiris.getCurrentItem() == 0){
                    ao.create().show();
                    //Sayfa Favori ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 1){
                    etxtWhereNow.setText("Where To?");
                    GirisActivity.viewPagerGiris.setCurrentItem(0,true);
                    ao.create().show();

                    //Sayfa Profil ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 2){
                    GirisActivity.viewPagerGiris.setCurrentItem(0,true);
                    etxtWhereNow.setText("Where To?");
                    presenter.slideDown(ustTab);
                    isUp = !isUp;
                    ao.create().show();
                }






            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Eget Sayfa Home ise favoriye aktar texti değiştir.
                if(GirisActivity.viewPagerGiris.getCurrentItem() == 0){
                    GirisActivity.viewPagerGiris.setCurrentItem(1,true);

                    etxtWhereNow.setText("Find Your Favorite");

                    //Sayfa Favori ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 1){

                    //Sayfa Profil ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 2){
                    GirisActivity.viewPagerGiris.setCurrentItem(1,true);
                    etxtWhereNow.setText("Find Your Favorite");
                    presenter.slideDown(ustTab);
                    isUp = !isUp;
                }


            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Eget Sayfa Home ise
                if(GirisActivity.viewPagerGiris.getCurrentItem() == 0){
                    GirisActivity.viewPagerGiris.setCurrentItem(2,true);
                    presenter.slideUp(ustTab);
                    isUp = !isUp;

                    //Sayfa Favori ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 1){
                    GirisActivity.viewPagerGiris.setCurrentItem(2,true);
                    presenter.slideUp(ustTab);
                    isUp = !isUp;

                    //Sayfa Profil ise
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 2){

                }

            }
        });




        viewPagerGiris.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(GirisActivity.viewPagerGiris.getCurrentItem() == 2){
                    presenter.slideUp(ustTab);
                    isUp = !isUp;
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() == 0){
                    presenter.slideDown(ustTab);
                    isUp = !isUp;
                    etxtWhereNow.setText("Where To?");
                }else if(GirisActivity.viewPagerGiris.getCurrentItem() ==1){
                    presenter.slideDown(ustTab);
                    isUp = !isUp;
                    etxtWhereNow.setText("Find Your Favorite");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }



}
