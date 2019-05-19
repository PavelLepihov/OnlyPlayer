package com.blind_falcon.onlyplayer.ui.flow.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.presentation.list.song.SongListPresenter;
import com.blind_falcon.onlyplayer.ui.flow.common.BaseListFragment;

public class MainSongListFragment extends BaseListFragment {

    @InjectPresenter
    SongListPresenter songListPresenter;

    public MainSongListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void loadData() {
        songListPresenter.loadMusic(getContext());
    }
}
