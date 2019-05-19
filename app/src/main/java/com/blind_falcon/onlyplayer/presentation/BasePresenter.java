package com.blind_falcon.onlyplayer.presentation;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    private CompositeDisposable compositeDisposable;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }
}
