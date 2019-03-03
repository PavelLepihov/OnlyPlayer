package com.blind_falcon.onlyplayer.di;


import com.blind_falcon.onlyplayer.di.module.ApplicationModule;
import com.blind_falcon.onlyplayer.di.module.NavigationModule;
import com.blind_falcon.onlyplayer.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NavigationModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
}
