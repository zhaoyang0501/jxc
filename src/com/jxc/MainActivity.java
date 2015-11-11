package com.jxc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView webView = new WebView(this);
	        Log.i("pzy", "fuck"+webView.toString());
	        webView.setHorizontalScrollBarEnabled(false);
	        webView.getSettings().setLoadWithOverviewMode(true);
	        webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
	        
	        WebSettings s =  webView.getSettings(); 
	        s.setBuiltInZoomControls(true);   
	        s.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);   
	        s.setUseWideViewPort(true);   
	        s.setLoadWithOverviewMode(true);   
	        s.setSavePassword(true);  
	        s.setSaveFormData(true);    
	        s.setJavaScriptEnabled(true);   
	        
	        webView.loadUrl("file:///android_asset/index.html"); 
	        setContentView(webView);
	}

}
