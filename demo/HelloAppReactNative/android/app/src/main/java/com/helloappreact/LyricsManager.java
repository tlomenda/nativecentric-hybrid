package com.helloappreact;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.helloappreact.lyrics.AdeleLyrics;
import com.helloappreact.lyrics.LionelRichieLyrics;

import java.io.IOException;

/**
 * Created by tlomenda on 4/19/16.
 */
public class LyricsManager extends ReactContextBaseJavaModule implements MediaPlayer.OnPreparedListener {

    public LionelRichieLyrics lionelLyrics = new LionelRichieLyrics();
    public AdeleLyrics adeleLyrics = new AdeleLyrics();

    public LyricsManager(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "LyricsManager";
    }

    @ReactMethod
    public void playNextLionelLyric() {
        final MainActivity currentActivity = (MainActivity) this.getCurrentActivity();

        playAudio(lionelLyrics.getNextAudioFile());

        sendNextLyricEvent("...Listening...");

        Handler mainHandler = new Handler(this.getCurrentActivity().getApplicationContext().getMainLooper());
        mainHandler.post(new Runnable() {

            @Override
            public void run() {
                ((TextView) currentActivity.findViewById(R.id.lyricText)).setText(lionelLyrics.getNextLyric());
            }
        });
    }

    @ReactMethod
    public void playNextAdeleLyric() {
        final MainActivity currentActivity = (MainActivity) this.getCurrentActivity();

        playAudio(adeleLyrics.getNextAudioFile());

        sendNextLyricEvent(adeleLyrics.getNextLyric());

        Handler mainHandler = new Handler(this.getCurrentActivity().getApplicationContext().getMainLooper());
        mainHandler.post(new Runnable() {

            @Override
            public void run() {
                ((TextView) currentActivity.findViewById(R.id.lyricText)).setText("...Listening...");
            }
        });
    }

    /** Native Helpers **/
    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    public void playAudio(String audioFileName) {
        try {
            AssetFileDescriptor afd = this.getCurrentActivity().getAssets().openFd(audioFileName);
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.setOnPreparedListener(this);
            player.prepareAsync();
            player.start();
        } catch (IOException e) {
            Log.d("LyricsManager", e.toString());
        }
    }

    void sendNextLyricEvent(String lyric) {
        ReactContext reactContext = getReactApplicationContext();
        WritableMap params = new WritableNativeMap();

        params.putString("lyric", lyric);
        reactContext
                .getJSModule(RCTNativeAppEventEmitter.class)
                .emit("hello.NextLyric", params);
    }

}
