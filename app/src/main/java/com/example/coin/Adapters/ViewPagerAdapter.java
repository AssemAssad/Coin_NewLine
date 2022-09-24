package com.example.coin.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.coin.Fragments.alarm_coinz_fragment;
import com.example.coin.Fragments.news_and_reports;
import com.example.coin.Fragments.prices_coinz_fragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new prices_coinz_fragment();
            case 1:
                return new alarm_coinz_fragment();
            case 2:
                return new news_and_reports();
            default:
                return new prices_coinz_fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
