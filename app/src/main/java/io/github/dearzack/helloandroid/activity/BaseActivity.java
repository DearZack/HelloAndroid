package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.dearzack.helloandroid.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
