package @@packageName@@;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewEngine;

import android.os.Bundle;

public class MainActivity extends CordovaActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);

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
}
