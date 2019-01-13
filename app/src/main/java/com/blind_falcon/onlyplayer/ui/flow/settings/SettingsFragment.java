package com.blind_falcon.onlyplayer.ui.flow.settings;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import com.blind_falcon.onlyplayer.R;


public class SettingsFragment extends PreferenceFragment {


    public SettingsFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }
}
