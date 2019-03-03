package com.blind_falcon.onlyplayer.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.blind_falcon.App;
import com.blind_falcon.onlyplayer.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
    }
}
