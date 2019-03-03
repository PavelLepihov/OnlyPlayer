package com.blind_falcon;

import android.app.Application;

import com.blind_falcon.onlyplayer.BuildConfig;
import com.blind_falcon.onlyplayer.di.AppComponent;
import com.blind_falcon.onlyplayer.di.DaggerAppComponent;

import timber.log.Timber;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        initComponent();
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initComponent() {
        appComponent = DaggerAppComponent.builder().build();
    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
