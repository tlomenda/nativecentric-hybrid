package my.tlapps.HelloApp;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewEngine;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends CordovaActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);

        findViewById(R.id.nativeButton).setOnClickListener(this);
        findViewById(R.id.webButton).setOnClickListener(this);

        super.init();

        launchUrl = "file:///android_asset/www/webSrc/index.html";
        loadUrl(launchUrl);
	}

    @Override
    /**
     * Override makeWebView to use the R.id.cordovaMainWebView we define in the activity_main.xml
     * layout.
     */
	protected CordovaWebView makeWebView() {
		SystemWebView webView = (SystemWebView)findViewById(R.id.cordovaMainWebView);
		return new CordovaWebViewImpl(new SystemWebViewEngine(webView));
	}

    @Override
    /**
     * Need to override this so it does not attempt to invoke setContentView more than once.
     */
    protected void createViews() {
        appView.getView().requestFocusFromTouch();
    }

    // Listeners
    public void onClick(View button) {

        if (button.getId() == R.id.nativeButton) {
            Log.d(TAG, "Native Button onClick");

            DuetHybridBridge bridge = (DuetHybridBridge) appView.getPluginManager().getPlugin("DuetHybridBridge");
            playAudio(bridge.lionelLyrics.getNextAudioFile());

            ((TextView) findViewById(R.id.lyricText)).setText(bridge.lionelLyrics.getNextLyric());

            JSONObject eventData = new JSONObject();
            try {
                eventData.put("eventType", "webWaitsToSing");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            bridge.reportEvent(eventData);

        } else if (button.getId() == R.id.webButton) {
            Log.d(TAG, "Web Button onClick");

            JSONObject eventData = new JSONObject();

            DuetHybridBridge bridge = (DuetHybridBridge) appView.getPluginManager().getPlugin("DuetHybridBridge");
            try {
                eventData.put("eventType", "showNextLyricForWeb");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            bridge.reportEvent(eventData);
        }
    }

    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    public void playAudio(String audioFileName) {
        try {
            AssetFileDescriptor afd = getAssets().openFd(audioFileName);
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.setOnPreparedListener(this);
            player.prepareAsync();
            player.start();
        } catch (IOException e) {
            Log.d(TAG, e.toString());
        }
    }
}
