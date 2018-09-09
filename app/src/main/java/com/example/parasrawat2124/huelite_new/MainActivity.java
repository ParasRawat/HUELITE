package com.example.parasrawat2124.huelite_new;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private PageAdapter pageAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.container);

        pageAdapter=new PageAdapter(getSupportFragmentManager());
        SetUpViewPager(viewPager);
        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void SetUpViewPager(ViewPager viewPager){
        PageAdapter adapter=new PageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new DeviceTab(),"Device") ;
        adapter.AddFragment(new ColorsTab(),"Color");
        adapter.AddFragment(new ScenesTab(),"Scenes");
        adapter.AddFragment(new ConfigureTab(),"Configure");
        viewPager.setAdapter(adapter);
    }
    }




