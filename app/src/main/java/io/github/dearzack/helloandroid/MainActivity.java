package io.github.dearzack.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.dearzack.helloandroid.activity.BaseActivity;
import io.github.dearzack.helloandroid.activity.ENViewsActivity;
import io.github.dearzack.helloandroid.activity.JsoupActivity;
import io.github.dearzack.helloandroid.activity.NetEasyPlayerActivity;
import io.github.dearzack.helloandroid.activity.SQLiteOnWebActivity;
import io.github.dearzack.helloandroid.activity.SmartisanNotesActivity;
import io.github.dearzack.helloandroid.adapter.MainAdapter;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BarUtils.setTransparentStatusBar(this);
//        BarUtils.setColor(this, 0xff0000);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.main_list);
        MainAdapter mainAdapter = new MainAdapter(this, data, new MainAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                gotoNewActivity(position);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(mainAdapter);
    }

    private void initData() {
        data = new ArrayList<>();
        data.add("Jsoup");
        data.add("SQLiteOnWeb");
        data.add("SmartisanNotes");
        data.add("ENViews");
        data.add("NetEasyMusic");
    }

    private void gotoNewActivity(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(MainActivity.this, JsoupActivity.class);
                break;
            case 1:
                intent = new Intent(MainActivity.this, SQLiteOnWebActivity.class);
                break;
            case 2:
                intent = new Intent(MainActivity.this, SmartisanNotesActivity.class);
                break;
            case 3:
                intent = new Intent(MainActivity.this, ENViewsActivity.class);
                break;
            case 4:
                intent = new Intent(MainActivity.this, NetEasyPlayerActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
