package com.blind_falcon.onlyplayer.model.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.R;
import com.blind_falcon.onlyplayer.model.Song;
import com.blind_falcon.onlyplayer.ui.holder.BaseViewHolder;
import com.blind_falcon.onlyplayer.utils.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongListViewModel extends BaseListViewModel {

    private final String albumCover;
    private final String songTitle;
    private final String artist;
    private final long playTime;

    public SongListViewModel(Song song) {
        this.songTitle = song.getTitle();
        this.albumCover = song.getAlbum().getCover();
        this.artist = song.getArtist().getName();
        this.playTime = song.getPlayTime();
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public long getPlayTime() {
        return playTime;
    }

    public static class SongListViewHolder extends BaseViewHolder<SongListViewModel> {

        @BindView(R.id.iv_menu)
        ImageView ivMenu;
        @BindView(R.id.tv_song_time)
        TextView tvSongTime;
        @BindView(R.id.iv_item_song_placeholder)
        ImageView ivItemSongPlaceholder;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_song_artist)
        TextView tvSongArtist;


        public SongListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            App.getAppComponent().inject(this);
        }

        @Override
        public void bindViewHolder(SongListViewModel songListViewModel) {
            Context context = itemView.getContext();
            Glide.with(context)
                    .load(songListViewModel.getAlbumCover())
                    .apply(new RequestOptions().fallback(R.drawable.ic_music_note_white))
                    .into(ivItemSongPlaceholder);
            Glide.with(context)
                    .load(R.drawable.ic_more_vert_white)
                    .into(ivMenu);
            tvTitle.setText(songListViewModel.getSongTitle());
            tvSongArtist.setText(songListViewModel.getArtist());
            tvSongTime.setText(StringUtils.convertTimeStampToPlaytimeString(songListViewModel.getPlayTime()));
        }

        @Override
        public void unbindViewHolder() {
            ivMenu.setImageBitmap(null);
            ivItemSongPlaceholder.setImageBitmap(null);
            tvSongArtist.setText(null);
            tvSongTime.setText(null);
            tvTitle.setText(null);
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.SONG_IN_LIST;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new SongListViewHolder(view);
    }
}
