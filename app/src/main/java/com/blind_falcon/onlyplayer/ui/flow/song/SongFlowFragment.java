package com.blind_falcon.onlyplayer.ui.flow.song;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blind_falcon.onlyplayer.R;

public class SongFlowFragment extends Fragment {


    public SongFlowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song_flow, container, false);
    }

}
