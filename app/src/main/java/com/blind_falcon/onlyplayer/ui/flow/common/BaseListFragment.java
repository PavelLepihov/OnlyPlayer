package com.blind_falcon.onlyplayer.ui.flow.common;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blind_falcon.onlyplayer.R;
import com.blind_falcon.onlyplayer.adapter.BaseListAdapter;
import com.blind_falcon.onlyplayer.model.view.BaseListViewModel;
import com.blind_falcon.onlyplayer.presentation.BaseListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseListFragment extends BaseFragment implements BaseListView {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    protected BaseListAdapter listAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpRecyclerView(view);
        setUpAdapter(rvList);
        loadData();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_main_list;
    }

    private void setUpAdapter(RecyclerView rvList) {
        listAdapter = new BaseListAdapter();
        rvList.setAdapter(listAdapter);
    }

    private void setUpRecyclerView(View rootView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(linearLayoutManager);

        //((SimpleItemAnimator) rvList.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    public void setItems(List<BaseListViewModel> items) {
        listAdapter.setItems(items);
    }

    @Override
    public void addItems(List<BaseListViewModel> items) {
        listAdapter.addItems(items);
    }
}
