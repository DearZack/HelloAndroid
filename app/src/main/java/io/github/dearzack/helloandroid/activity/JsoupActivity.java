package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import io.github.dearzack.helloandroid.R;

public class JsoupActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsoup);
        textView = (TextView) findViewById(R.id.title);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect("http://www.oschina.net/").get();
                    final String title = doc.title();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(title);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
