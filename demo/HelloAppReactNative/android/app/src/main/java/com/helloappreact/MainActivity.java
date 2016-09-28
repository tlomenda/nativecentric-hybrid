package com.helloappreact;

import android.os.Bundle;
import android.view.View;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class MainActivity extends ReactActivity implements DefaultHardwareBackBtnHandler, View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ReactRootView reactView = (ReactRootView) findViewById(R.id.reactMainView);

        reactView.startReactApplication(getReactInstanceManager(), "HelloApp", null);

        findViewById(R.id.nativeButton).setOnClickListener(this);
        findViewById(R.id.webButton).setOnClickListener(this);
    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "HelloApp";
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        getReactInstanceManager().onHostPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getReactInstanceManager().onHostResume(this, this);
    }

    @Override
    public void onBackPressed() {
        if (getReactInstanceManager() != null) {
            getReactInstanceManager().onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View button) {
        HelloPackage helloPackage = ((MainApplication) getApplication()).helloPackage;
        LyricsManager lyricsMgr = helloPackage.lyricsManager;

        if (button.getId() == R.id.nativeButton) {
            lyricsMgr.playNextLionelLyric();
        } else if (button.getId() == R.id.webButton) {
            lyricsMgr.playNextAdeleLyric();
        }
    }
}
