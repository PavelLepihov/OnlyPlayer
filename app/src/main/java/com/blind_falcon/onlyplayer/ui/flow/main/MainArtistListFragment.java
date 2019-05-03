package com.blind_falcon.onlyplayer.ui.flow.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blind_falcon.onlyplayer.R;


public class MainArtistListFragment extends Fragment {

    public MainArtistListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_artists_list, container, false);
    }

}
