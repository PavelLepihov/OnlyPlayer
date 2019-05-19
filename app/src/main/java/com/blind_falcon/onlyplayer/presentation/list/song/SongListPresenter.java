package com.blind_falcon.onlyplayer.presentation.list.song;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.arellomobile.mvp.InjectViewState;
import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.model.Album;
import com.blind_falcon.onlyplayer.model.Artist;
import com.blind_falcon.onlyplayer.model.Song;
import com.blind_falcon.onlyplayer.model.view.BaseListViewModel;
import com.blind_falcon.onlyplayer.model.view.SongListViewModel;
import com.blind_falcon.onlyplayer.presentation.BaseListView;
import com.blind_falcon.onlyplayer.presentation.BasePresenter;
import com.blind_falcon.onlyplayer.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SongListPresenter extends BasePresenter<BaseListView> {

    private boolean isLoading;

    public SongListPresenter() {
        App.getAppComponent().inject(this);
    }

    public void loadMusic(Context context) {
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        if (isLoading) return;
        isLoading = true;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Disposable subscribe = Single.just(contentResolver.query(songUri, null, selection, null, null))
                .map(this::parseCursor)
                .map(this::parseSongs)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(songs -> getViewState().addItems(songs));
        addDisposable(subscribe);
    }

    private ArrayList<Song> parseCursor(Cursor cursor) {
        if (cursor == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Song> songList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String year = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.YEAR));
            String playTime = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            String fileSize = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
            String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            songList.add(new Song.Builder(title)
                    .setAlbum(new Album(album, null, year))
                    .setArtist(new Artist(artist, null))
                    .setFilesize(StringUtils.convertByteFileSizeToString(fileSize))
                    .setPlayTime(Long.parseLong(playTime))
                    .setFilePath(filePath)
                    .build());
        }
        cursor.close();
        return songList;
    }

    private List<BaseListViewModel> parseSongs(ArrayList<Song> songsList) {
        List<BaseListViewModel> modelList = new ArrayList<>();
        for (Song song : songsList) {
            modelList.add(new SongListViewModel(song));
        }
        return modelList;
    }

}
