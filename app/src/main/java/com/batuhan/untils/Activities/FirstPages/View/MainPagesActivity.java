package com.batuhan.untils.Activities.FirstPages.View;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.batuhan.untils.Activities.Login.Activity.LoginActivity;
import com.batuhan.untils.Adapters.MyAdapter;
import com.batuhan.untils.R;
import com.batuhan.untils.Activities.Register.View.RegisterActivity;
import com.batuhan.untils.Activities.Welcome.View.MainActivity;
import com.onesignal.OneSignal;

public class MainPagesActivity extends AppCompatActivity {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pages);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


        SharedPreferences sp = getSharedPreferences("DbUserInformation",MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putInt("userId",1);
        editor.commit();

        //OneSignal.setExternalUserId("1");

        //OneSignal.sendTag("userId","1"); benim telefonum
        //OneSignal.sendTag("userId","2"); //Nexus 4 API



        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        //Tablara Fragment Ekleme
        adapter.fragmentEkle(new LoginActivity(),"Login");
        adapter.fragmentEkle(new MainActivity(),"Main");
        adapter.fragmentEkle(new RegisterActivity(),"Register");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tab = tabLayout.getTabAt(1); //Başlangıç sayfası seçmek için
        tab.select();


    }
}
