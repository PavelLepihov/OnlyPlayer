package com.blind_falcon.onlyplayer.adapter;

import android.util.ArrayMap;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blind_falcon.onlyplayer.model.view.BaseListViewModel;
import com.blind_falcon.onlyplayer.ui.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BaseListAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseListViewModel>> {

    private List<BaseListViewModel> list = new ArrayList<>();

    private ArrayMap<Integer, BaseListViewModel> mTypeInstances = new ArrayMap<>();

    @Override
    public BaseViewHolder<BaseListViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mTypeInstances.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseListViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseListViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    public void registerTypeInstance(BaseListViewModel item) {
        if (!mTypeInstances.containsKey(item.getType())) {
            mTypeInstances.put(item.getType().getValue(), item);
        }
    }

    public void setItems(List<BaseListViewModel> items) {
        clearList();
        addItems(items);
    }

    public void addItems(List<? extends BaseListViewModel> newItems) {

        for (BaseListViewModel newItem : newItems) {
            registerTypeInstance(newItem);
        }
        list.addAll(newItems);
        notifyDataSetChanged();
    }

    public void clearList() {
        list.clear();
    }


    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public BaseListViewModel getItem(int position) {
        return list.get(position);
    }

    public int getRealItemCount() {
        int count = 0;
        for (int i = 0; i < getItemCount(); i++) {
            if (!getItem(i).isItemDecorator()) {
                count += 1;
            }
        }
        return count;
    }

    public void insertItem(BaseListViewModel newItem) {
        registerTypeInstance(newItem);

        list.add(newItem);
        notifyItemInserted(getItemCount() - 1);
    }
}
