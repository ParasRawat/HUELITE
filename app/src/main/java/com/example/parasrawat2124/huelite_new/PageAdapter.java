package com.example.parasrawat2124.huelite_new;


import android.app.ActionBar;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> titlelist=new ArrayList<>();

   public PageAdapter(FragmentManager fragmentManager){
       super(fragmentManager);

   }
   public void AddFragment(Fragment fragment,String title){
       fragmentList.add(fragment);
       titlelist.add(title);

   }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();

    }
}
