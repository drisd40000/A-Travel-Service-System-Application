package com.example.updatedproject.AdapterFolder;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.updatedproject.Fragments.HistoryFragment;
import com.example.updatedproject.Fragments.LocationFragment;
import com.example.updatedproject.Fragments.ScanFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private int totalTabs;

    public TabPagerAdapter(Context context, FragmentManager fm, int totaltabs)
    {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
        this.totalTabs = totaltabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                ScanFragment scanFragment = new ScanFragment();
                return scanFragment;
            case 1:
                LocationFragment locationFragment = new LocationFragment();
                return locationFragment;
            case 2:
                HistoryFragment historyFragment =new HistoryFragment();
                return historyFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
