package com.blind_falcon.onlyplayer;

import androidx.fragment.app.Fragment;

import com.blind_falcon.onlyplayer.ui.flow.main.MainAlbumListFragment;
import com.blind_falcon.onlyplayer.ui.flow.main.MainArtistListFragment;
import com.blind_falcon.onlyplayer.ui.flow.main.MainFlowFragment;
import com.blind_falcon.onlyplayer.ui.flow.main.MainSongListFragment;
import com.blind_falcon.onlyplayer.ui.flow.settings.SettingsFlowFragment;
import com.blind_falcon.onlyplayer.ui.flow.settings.SettingsFragment;
import com.blind_falcon.onlyplayer.ui.flow.song.PlaybackSongFragment;
import com.blind_falcon.onlyplayer.ui.flow.song.SongDetailsFragment;
import com.blind_falcon.onlyplayer.ui.flow.song.SongFlowFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static final class MainFlowScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new MainFlowFragment();
        }
    }

    public static final class MainSongListScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new MainSongListFragment();
        }
    }

    public static final class MainAlbumListScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new MainAlbumListFragment();
        }
    }

    public static final class MainArtistListScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new MainArtistListFragment();
        }
    }

    public static final class SongFlowScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SongFlowFragment();
        }
    }

    public static final class PlaybackSongScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new PlaybackSongFragment();
        }
    }

    public static final class SongDetailsScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SongDetailsFragment();
        }
    }

    public static final class SettingsFlowScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SettingsFlowFragment();
        }
    }

    public static final class SettingsScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SettingsFragment();
        }
    }
}
