package my.tlapps.HelloApp;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.TextView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import my.tlapps.HelloApp.lyrics.AdeleLyrics;
import my.tlapps.HelloApp.lyrics.LionelRichieLyrics;

/**
 * Created by tlomenda on 11/30/15.
 */
public class DuetHybridBridge extends CordovaPlugin implements MediaPlayer.OnPreparedListener {
    private final String TAG = "DuetHybridBridge";
    private final String ACTION_BIND_LISTENER = "ACTION_BIND_LISTENER";

    private final String JS_TO_NATIVE_NEXTLYRIC = "JS_TO_NATIVE_NEXTLYRIC";
    private final String JS_TO_NATIVE_WAITFORLYRIC = "JS_TO_NATIVE_WAITFORLYRIC";
    private final String GET_NEXTLYRIC_FOR_WEB = "GET_NEXTLYRIC_FOR_WEB";

    private CallbackContext listenerCallbackContext;

    public LionelRichieLyrics lionelLyrics = new LionelRichieLyrics();
    public AdeleLyrics adeleLyrics = new AdeleLyrics();

    public DuetHybridBridge() {
        super();
        Log.d(TAG, "Constructing");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "execute :: " + this.toString());
        if (ACTION_BIND_LISTENER.equals(action)){
            return bindListener(args, callbackContext);
        } else if (GET_NEXTLYRIC_FOR_WEB.equals(action)){
            return getNextLyricForWeb(args, callbackContext);
        } else if (JS_TO_NATIVE_NEXTLYRIC.equals(action)) {
            return getNextLyricForNative(args, callbackContext);
        } else if (JS_TO_NATIVE_WAITFORLYRIC.equals(action)) {
            return waitForNextLyricNative(args, callbackContext);
        }

        return false;
    }

    private boolean bindListener(JSONArray args, CallbackContext callbackContext) {
        Log.d(TAG, "bindListener");
        listenerCallbackContext = callbackContext;
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    public void reportEvent(JSONObject eventData){
        Log.d(TAG, "reportEvent");
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, eventData);
        pluginResult.setKeepCallback(true);
        listenerCallbackContext.sendPluginResult(pluginResult);
    }

    private boolean getNextLyricForWeb(JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "getNextLyricForWeb");
        PluginResult pluginResult;

        playAudio(adeleLyrics.getNextAudioFile());

        pluginResult = new PluginResult(PluginResult.Status.OK, adeleLyrics.getNextLyric());

        callbackContext.sendPluginResult(pluginResult);
        return true;
    }
    private boolean waitForNextLyricNative(JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "getNextLyricForWeb");
        PluginResult pluginResult;

        ((TextView) cordova.getActivity().findViewById(R.id.lyricText)).setText("...Listens...");

        pluginResult = new PluginResult(PluginResult.Status.OK);

        callbackContext.sendPluginResult(pluginResult);
        return true;
    }
    private boolean getNextLyricForNative(JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "getNextLyricForWeb");
        PluginResult pluginResult;

        playAudio(lionelLyrics.getNextAudioFile());

        ((TextView) cordova.getActivity().findViewById(R.id.lyricText)).setText(lionelLyrics.getNextLyric());

        pluginResult = new PluginResult(PluginResult.Status.OK);

        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    public void playAudio(String audioFileName) {
        try {
            AssetFileDescriptor afd = cordova.getActivity().getAssets().openFd(audioFileName);
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.setOnPreparedListener(this);
            player.prepareAsync();
            player.start();
        } catch (IOException e) {
            Log.d(TAG, e.toString());
        }
    }

    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

}
