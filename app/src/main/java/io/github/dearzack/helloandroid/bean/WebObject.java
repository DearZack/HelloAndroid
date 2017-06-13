package io.github.dearzack.helloandroid.bean;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Zack on 2017/6/13.
 */

public class WebObject {
    private static final String TAG = "WebObject";
    private Context context;

    public WebObject(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void printLog(String message) {
        Log.e(TAG, message);
    }

    @JavascriptInterface
    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
