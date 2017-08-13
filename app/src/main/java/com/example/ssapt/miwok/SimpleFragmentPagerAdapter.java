package com.example.ssapt.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by ssapt on 8/2/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new NumberFragment();

            case 1 : return new ColorFragment();

            case 2 : return new FamilyMemberFragment();

            default: return new PhrasesFragment();

        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.colors);
        } else if (position == 2) {
            return mContext.getString(R.string.family_members);
        } else {
            return mContext.getString(R.string.phrases);
        }
    }
}
