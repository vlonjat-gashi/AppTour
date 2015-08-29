package com.vlonjatg.android.apptourlibrary;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Vlonjat Gashi (vlonjatg)
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments;

    public PagerAdapter(FragmentManager fm, @NonNull List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @NonNull
    public List<Fragment> getFragments() {
        return fragments;
    }
}
