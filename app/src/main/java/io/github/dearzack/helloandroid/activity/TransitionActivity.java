package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.util.EasyTransition;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        EasyTransition.enter(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EasyTransition.exit(this);
    }
}
