package com.blind_falcon.onlyplayer.ui.flow.main;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.R;
import com.blind_falcon.onlyplayer.adapter.MainFlowViewPagerAdapter;
import com.blind_falcon.onlyplayer.ui.flow.common.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFlowFragment extends BaseFragment {

    private final int layoutRes = R.layout.fragment_main_flow;
    @BindView(R.id.tl_category)
    TabLayout tabLayout;
    @BindView(R.id.vp_category)
    ViewPager viewPager;


    public MainFlowFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        MainFlowViewPagerAdapter adapter = new MainFlowViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MainSongListFragment(), getResources().getString(R.string.song_list_title));
        adapter.addFragment(new MainArtistListFragment(), getResources().getString(R.string.artist_list_title));
        adapter.addFragment(new MainAlbumListFragment(), getResources().getString(R.string.album_list_title));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getContentLayout() {
        return layoutRes;
    }

}
