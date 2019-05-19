package com.blind_falcon.onlyplayer.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.blind_falcon.onlyplayer.ui.flow.common.BaseListFragment;

import java.util.ArrayList;

public class MainFlowViewPagerAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<BaseListFragment> tabList = new ArrayList<>();
    private final ArrayList<String> tabTitles = new ArrayList<>();

    public MainFlowViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    public void addFragment(BaseListFragment listFragment, String title) {
        tabList.add(listFragment);
        tabTitles.add(title);
    }
}
