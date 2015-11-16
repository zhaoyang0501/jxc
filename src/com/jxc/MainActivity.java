package com.jxc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("JavascriptInterface")
public class MainActivity extends Activity {
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webView = new WebView(this);
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
	        webView.setWebChromeClient(new WebChromeClient());
	        webView.addJavascriptInterface(this, "app");
	        webView.loadUrl("file:///android_asset/index.html"); 
	        webView.setWebViewClient(new WebViewClient(){
	        	  public boolean shouldOverrideUrlLoading(WebView view, String url) { 
	        	       view.loadUrl(url);
	        	       return true;
	        	  }
	        	});
	        setContentView(webView);
	}
	  
	  @JavascriptInterface
	  public void getjson(final String url,final String callback) {  
	        Toast.makeText(this, "js调用了java函数", Toast.LENGTH_SHORT).show();  
	        new Thread() {  
	            public void run(){  
	            	try {
	            		final String  json= HttpClientUtil.doGet(url);
	            		webView.post(new Runnable() {
	            		    public void run() {
	            		    	webView.loadUrl("javascript: "+callback+"('" + json + "')");
	            		    }
	            		});
	            		 
					} catch (Exception e) {
						e.printStackTrace();
					}
	            }  
	        }.start();
	   }  
}
