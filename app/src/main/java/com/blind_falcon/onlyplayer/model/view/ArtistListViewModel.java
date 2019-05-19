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

public class ArtistListViewModel extends BaseListViewModel {

    private final String artistCover;
    private final String artistName;
    //private final int numberOfTracks;


    public ArtistListViewModel(Song song) {
        artistCover = song.getArtist().getImage();
        artistName = song.getArtist().getName();
    }

    public String getArtistCover() {
        return artistCover;
    }

    public String getArtistName() {
        return artistName;
    }

    public static class ArtistListViewHolder extends BaseViewHolder<ArtistListViewModel> {

        @BindView(R.id.iv_menu)
        ImageView ivMenu;
        @BindView(R.id.iv_item_artist_placeholder)
        ImageView ivItemArtistPlaceholder;
        @BindView(R.id.tv_artist_name)
        TextView tvArtistName;

        public ArtistListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            App.getAppComponent().inject(this);
        }

        @Override
        public void bindViewHolder(ArtistListViewModel artistListViewModel) {
            Context context = itemView.getContext();
            Glide.with(context)
                    .load(artistListViewModel.getArtistCover())
                    .apply(new RequestOptions().fallback(R.drawable.ic_music_note_white))
                    .into(ivItemArtistPlaceholder);
            Glide.with(context)
                    .load(R.drawable.ic_more_vert_white)
                    .into(ivMenu);
            tvArtistName.setText(artistListViewModel.getArtistName());
        }

        @Override
        public void unbindViewHolder() {
            ivItemArtistPlaceholder.setImageBitmap(null);
            ivMenu.setImageBitmap(null);
            tvArtistName.setText(null);
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.ARTIST_IN_LIST;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new ArtistListViewHolder(view);
    }
}
