package com.blind_falcon.onlyplayer.di;


import com.blind_falcon.onlyplayer.di.module.ApplicationModule;
import com.blind_falcon.onlyplayer.di.module.NavigationModule;
import com.blind_falcon.onlyplayer.model.view.AlbumListViewModel;
import com.blind_falcon.onlyplayer.model.view.ArtistListViewModel;
import com.blind_falcon.onlyplayer.model.view.SongListViewModel;
import com.blind_falcon.onlyplayer.presentation.list.artist.ArtistListPresenter;
import com.blind_falcon.onlyplayer.presentation.list.song.SongListPresenter;
import com.blind_falcon.onlyplayer.ui.MainActivity;
import com.blind_falcon.onlyplayer.ui.flow.main.MainFlowFragment;
import com.blind_falcon.onlyplayer.ui.flow.main.MainSongListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NavigationModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
    //holders
    void inject(SongListViewModel.SongListViewHolder holder);
    void inject(ArtistListViewModel.ArtistListViewHolder holder);
    void inject(AlbumListViewModel.AlbumListViewHolder holder);
    //fragments
    void inject(MainFlowFragment fragment);
    void inject(MainSongListFragment fragment);
    //presenters
    void inject(SongListPresenter presenter);
    void inject(ArtistListPresenter presenter);

}
