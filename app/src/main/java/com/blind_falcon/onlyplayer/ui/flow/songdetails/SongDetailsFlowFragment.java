package com.blind_falcon.onlyplayer.ui.flow.songdetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blind_falcon.onlyplayer.R;

public class SongDetailsFlowFragment extends Fragment {


    public SongDetailsFlowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song_details_flow, container, false);
    }

}
