package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.bean.WebObject;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webView);
        button = (Button) findViewById(R.id.button);
        webView.loadUrl("file:///android_asset/test.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebObject(this), "javaObject");
        WebChromeClient webChromeClient = new WebChromeClient();
        webChromeClient.onJsAlert(webView, "", "你好啊", null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
