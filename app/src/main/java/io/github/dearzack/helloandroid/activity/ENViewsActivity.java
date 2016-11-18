package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.dearzack.helloandroid.R;
import moe.codeest.enviews.ENDownloadView;

public class ENViewsActivity extends BaseActivity {

    private ENDownloadView downloadView;

    private Button btnStart;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviews);
        downloadView = (ENDownloadView) findViewById(R.id.view_download);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnReset = (Button) findViewById(R.id.btn_reset);

        downloadView.setDownloadConfig(20000, 20, ENDownloadView.DownloadUnit.MB);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadView.start();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadView.reset();
            }
        });
    }
}
