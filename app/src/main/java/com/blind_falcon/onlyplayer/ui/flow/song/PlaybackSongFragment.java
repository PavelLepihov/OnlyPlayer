package com.blind_falcon.onlyplayer.ui.flow.song;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blind_falcon.onlyplayer.R;


public class PlaybackSongFragment extends Fragment {


    public PlaybackSongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playback_song, container, false);
    }

}