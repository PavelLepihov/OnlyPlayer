package com.blind_falcon.onlyplayer.presentation.list.artist;

import com.arellomobile.mvp.InjectViewState;
import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.presentation.BaseListView;
import com.blind_falcon.onlyplayer.presentation.BasePresenter;

@InjectViewState
public class ArtistListPresenter extends BasePresenter<BaseListView> {

    public ArtistListPresenter() {
        App.getAppComponent().inject(this);
    }
}
