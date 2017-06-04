package io.github.dearzack.helloandroid.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;

import io.github.dearzack.helloandroid.R;

public class IconfontActivity extends AppCompatActivity {

    //1  http://iconfont.cn/下载字体文件放置assets目录
    //2  使用typeface

    private TextView textView;
    private PathView pathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iconfont);
        textView = (TextView) findViewById(R.id.iconfont);
        pathView = (PathView) findViewById(R.id.pathView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        textView.setTypeface(typeface);
        pathView.getPathAnimator()
                .delay(100)
                .duration(500)
//                .listenerStart(new AnimationListenerStart())
//                .listenerEnd(new AnimationListenerEnd())
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();
    }
}
