package com.blind_falcon.onlyplayer.presentation;

import com.arellomobile.mvp.MvpView;
import com.blind_falcon.onlyplayer.model.view.BaseListViewModel;

import java.util.List;

public interface BaseListView extends MvpView {
    void setItems(List<BaseListViewModel> items);
    void addItems(List<BaseListViewModel> items);
    void loadData();
}
