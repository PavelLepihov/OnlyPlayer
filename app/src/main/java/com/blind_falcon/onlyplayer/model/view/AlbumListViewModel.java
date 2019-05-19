package com.blind_falcon.onlyplayer.model.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.R;
import com.blind_falcon.onlyplayer.model.Song;
import com.blind_falcon.onlyplayer.ui.holder.BaseViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumListViewModel extends BaseListViewModel {

    private final String albumCover;
    private final String albumTitle;
    private final String artistName;

    public AlbumListViewModel(Song song) {
        albumCover = song.getAlbum().getCover();
        albumTitle = song.getAlbum().getTitle();
        artistName = song.getArtist().getName();
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public static class AlbumListViewHolder extends BaseViewHolder<AlbumListViewModel> {

        @BindView(R.id.iv_menu)
        ImageView ivMenu;
        @BindView(R.id.iv_item_album_placeholder)
        ImageView ivItemAlbumPlaceholder;
        @BindView(R.id.tv_album_title)
        TextView tvAlbumTitle;
        @BindView(R.id.tv_artist_name)
        TextView tvArtistName;

        public AlbumListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            App.getAppComponent().inject(this);
        }

        @Override
        public void bindViewHolder(AlbumListViewModel albumListViewModel) {
            Context context = itemView.getContext();
            Glide.with(context)
                    .load(albumListViewModel.getAlbumCover())
                    .apply(new RequestOptions().fallback(R.drawable.ic_music_note_white))
                    .into(ivItemAlbumPlaceholder);
            Glide.with(context)
                    .load(R.drawable.ic_more_vert_white)
                    .into(ivMenu);
            tvAlbumTitle.setText(albumListViewModel.getAlbumTitle());
            tvArtistName.setText(albumListViewModel.getArtistName());
        }

        @Override
        public void unbindViewHolder() {
            ivItemAlbumPlaceholder.setImageBitmap(null);
            ivMenu.setImageBitmap(null);
            tvArtistName.setText(null);
            tvAlbumTitle.setText(null);
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ALBUM_IN_LIST;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new AlbumListViewHolder(view);
    }
}
