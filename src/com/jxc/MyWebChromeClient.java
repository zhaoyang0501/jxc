package com.jxc;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
//****************************************************************************
public class MyWebChromeClient extends WebChromeClient {
	@Override
	public void onCloseWindow(WebView window) {
		super.onCloseWindow(window);
	}

	@Override
	public boolean onCreateWindow(WebView view, boolean dialog,
			boolean userGesture, Message resultMsg) {
		return super.onCreateWindow(view, dialog, userGesture, resultMsg);
	}

	/**
	 * 覆盖默认的window.alert展示界面，避免title里显示为“：来自file:////”
	 */
	public boolean onJsAlert(WebView view, String url, String message,
			JsResult result) {
		Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
	    result.confirm();
	    return true;
	}

	public boolean onJsBeforeUnload(WebView view, String url,
			String message, JsResult result) {
		return super.onJsBeforeUnload(view, url, message, result);
	}
	@Override
	public void onProgressChanged(WebView view, int newProgress) {
		super.onProgressChanged(view, newProgress);
	}

	@Override
	public void onReceivedIcon(WebView view, Bitmap icon) {
		super.onReceivedIcon(view, icon);
	}

	@Override
	public void onReceivedTitle(WebView view, String title) {
		super.onReceivedTitle(view, title);
	}

	@Override
	public void onRequestFocus(WebView view) {
		super.onRequestFocus(view);
	}
}
