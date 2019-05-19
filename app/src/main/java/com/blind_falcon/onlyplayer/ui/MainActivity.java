package com.blind_falcon.onlyplayer.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.blind_falcon.onlyplayer.App;
import com.blind_falcon.onlyplayer.R;
import com.blind_falcon.onlyplayer.Screens;
import com.github.florent37.runtimepermission.rx.RxPermissions;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Router router;



    private Navigator navigator = new SupportAppNavigator(this, getSupportFragmentManager(),
            R.id.main_container) {
        @Override
        protected void setupFragmentTransaction(Command command,
                                                Fragment currentFragment,
                                                Fragment nextFragment,
                                                FragmentTransaction fragmentTransaction) {
            super.setupFragmentTransaction(command, currentFragment, nextFragment, fragmentTransaction);
            fragmentTransaction.setReorderingAllowed(true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        requestStoragePermission(savedInstanceState);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @SuppressLint("CheckResult")
    private void requestStoragePermission(Bundle savedInstanceState) {
        final RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(result -> {
                            if (result.isAccepted() && savedInstanceState == null) {
                                router.newRootScreen(new Screens.MainFlowScreen());
                            }
                        },
                        throwable -> {
                            showPermissionDeniedDialog(this);
                            Timber.d(throwable);
                        });
    }

    private void showPermissionDeniedDialog(Context context) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.dialog_button_positive, (dialogInterface, i) -> requestStoragePermission(null))
                .setNegativeButton(R.string.dialog_button_negative, (dialogInterface, i) -> finish())
                .create();
        alertDialog.show();
    }
}
