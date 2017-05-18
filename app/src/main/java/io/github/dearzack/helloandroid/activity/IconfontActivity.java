package io.github.dearzack.helloandroid.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.dearzack.helloandroid.R;

public class IconfontActivity extends AppCompatActivity {

    //1  http://iconfont.cn/下载字体文件放置assets目录
    //2  使用typeface

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iconfont);
        textView = (TextView) findViewById(R.id.iconfont);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        textView.setTypeface(typeface);
    }
}
