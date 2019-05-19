package com.blind_falcon.onlyplayer.model.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.blind_falcon.onlyplayer.R;
import com.blind_falcon.onlyplayer.ui.holder.BaseViewHolder;

public abstract class BaseListViewModel {

    public abstract LayoutTypes getType();

    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return onCreateViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getType().getValue(), parent, false));
    }

    protected abstract BaseViewHolder onCreateViewHolder(View view);

    public enum LayoutTypes {
        SONG_IN_LIST(R.layout.item_song_list),
        ALBUM_IN_LIST(R.layout.item_album_list),
        ARTIST_IN_LIST(R.layout.item_artist_list);

        private final int id;

        LayoutTypes(int resId) {
            this.id = resId;
        }

        @LayoutRes
        public int getValue() {
            return id;
        }
    }

    public boolean isItemDecorator() {
        return false;
    }
}
