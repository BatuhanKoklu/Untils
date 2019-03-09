package com.batuhan.untils.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentListe = new ArrayList<>();
    private List <String> fragmentBaslikListe = new ArrayList<>();

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentListe.get(position);
    }


    @Override
    public int getCount() {
        return fragmentListe.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentBaslikListe.get(position);
    }



    public void fragmentEkle(Fragment fragment , String baslik){
        fragmentListe.add(fragment);
        fragmentBaslikListe.add(baslik);
    }
}
