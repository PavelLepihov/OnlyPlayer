package com.blind_falcon.onlyplayer.ui.holder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.blind_falcon.onlyplayer.model.view.BaseListViewModel;

public abstract class BaseViewHolder<Item extends BaseListViewModel> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindViewHolder(Item item);
    public abstract void unbindViewHolder();
}
