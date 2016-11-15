package io.github.dearzack.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.dearzack.helloandroid.activity.JsoupActivity;
import io.github.dearzack.helloandroid.adapter.MainAdapter;
import io.github.dearzack.helloandroid.bean.Test;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        for (int i = 0; i < 10; i++) {
            Test test = new Test();
            test.setName("zack" + i);
            test.setPassword("zackPassword" + i);
            APP.testDao.insertOrReplace(test);
        }
    }

    private void initData() {
        data = new ArrayList<>();
        data.add("Jsoup");
    }

    private void gotoNewActivity(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(MainActivity.this, JsoupActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
