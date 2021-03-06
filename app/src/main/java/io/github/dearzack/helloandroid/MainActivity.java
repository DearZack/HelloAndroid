package io.github.dearzack.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import io.github.dearzack.helloandroid.activity.BaseActivity;
import io.github.dearzack.helloandroid.activity.CoordinatorActivity;
import io.github.dearzack.helloandroid.activity.ENViewsActivity;
import io.github.dearzack.helloandroid.activity.IconfontActivity;
import io.github.dearzack.helloandroid.activity.JsoupActivity;
import io.github.dearzack.helloandroid.activity.NetEasyPlayerActivity;
import io.github.dearzack.helloandroid.activity.SQLiteOnWebActivity;
import io.github.dearzack.helloandroid.activity.SmartisanNotesActivity;
import io.github.dearzack.helloandroid.activity.TouchActivity;
import io.github.dearzack.helloandroid.activity.TransitionAnimationActivity;
import io.github.dearzack.helloandroid.activity.WebActivity;
import io.github.dearzack.helloandroid.adapter.MainAdapter;
import io.github.dearzack.helloandroid.bean.Person;

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
        loggerTest();
    }

    private void loggerTest() {
        Logger.d("hello logger");
        Logger.d("debug");
        Logger.e("error");
        Logger.w("warning");
        Logger.v("verbose");
        Logger.i("information");
        Logger.wtf("wtf!!!!");
        Gson gson = new Gson();
        Person person= new Person();
        person.setName("hello");
        person.setHead(1);
        Logger.json(gson.toJson(person));
    }

    private void initData() {
        data = new ArrayList<>();
        data.add("Jsoup");
        data.add("SQLiteOnWeb");
        data.add("SmartisanNotes");
        data.add("ENViews");
        data.add("NetEasyMusic");
        data.add("Iconfont");
        data.add("Coordinator");
        data.add("Touch");
        data.add("Transition");
        data.add("Web");
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
            case 5:
                intent = new Intent(MainActivity.this, IconfontActivity.class);
                break;
            case 6:
                intent = new Intent(MainActivity.this, CoordinatorActivity.class);
                break;
            case 7:
                intent = new Intent(MainActivity.this, TouchActivity.class);
                break;
            case 8:
                intent = new Intent(MainActivity.this, TransitionAnimationActivity.class);
                break;
            case 9:
                intent = new Intent(MainActivity.this, WebActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
