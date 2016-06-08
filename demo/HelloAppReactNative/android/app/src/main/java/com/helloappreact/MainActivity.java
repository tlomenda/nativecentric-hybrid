package com.helloappreact;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler, View.OnClickListener {

    private ReactInstanceManager mReactInstanceManager;
    private HelloPackage helloPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ReactRootView reactView = (ReactRootView) findViewById(R.id.reactMainView);

        helloPackage = new HelloPackage();
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(helloPackage)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        reactView.startReactApplication(mReactInstanceManager, "HelloApp", null);

        findViewById(R.id.nativeButton).setOnClickListener(this);
        findViewById(R.id.webButton).setOnClickListener(this);
    }

    @Override
    /**
     * Overrides for DefaultHardwareBackBtnHandler interface
     */
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    /** Activity Callbacks down to the ReactInstanceManager */
    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    /** Back Button Events to React Native */
    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    /** Button Event Listeners **/
    // Listeners
    public void onClick(View button) {
        LyricsManager lyricsMgr = helloPackage.lyricsManager;

        if (button.getId() == R.id.nativeButton) {
            // Lionel Sings
            lyricsMgr.playNextLionelLyric();
        } else if (button.getId() == R.id.webButton) {
            // Adele Sings
            helloPackage.lyricsManager.playNextAdeleLyric();
        }
    }
}
