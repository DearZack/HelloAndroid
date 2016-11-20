package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.blankj.utilcode.utils.BarUtils;

import io.github.dearzack.helloandroid.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        BarUtils.hideStatusBar(this); //隐藏状态栏，必须在setContentView之前调用
        setContentView(R.layout.activity_base);
        BarUtils.setTransparentStatusBar(this);
        BarUtils.setColor(this, 0xff0000);
        ViewGroup contentView = ((ViewGroup) this.findViewById(android.R.id.content));
        contentView.setPadding(0, BarUtils.getStatusBarHeight(this), 0, 0);
//        decorView.setPadding(0, getStatusBarHeight(activity), 0, 0);
    }
}
