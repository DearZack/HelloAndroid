package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.dearzack.helloandroid.APP;
import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.bean.Test;
import io.github.dearzack.helloandroid.view.HintPopupWindow;

public class SQLiteOnWebActivity extends BaseActivity {

    //https://github.com/skyhacker2/SQLiteOnWeb-Android

    //https://github.com/Zhaoss/HintPopupWindow

    private HintPopupWindow hintPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_on_web);
        for (int i = 0; i < 30; i++) {
            Test test = new Test();
            test.setId((long)i);
            test.setName("Test" + i);
            test.setPassword("Password" + i);
            APP.testDao.insertOrReplace(test);
        }
        hintPopupWindow();
    }

    private void hintPopupWindow() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出选项弹窗
                hintPopupWindow.showPopupWindow(v);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出选项弹窗
                hintPopupWindow.showPopupWindow(v);
            }
        });

        //下面的操作是初始化弹出数据
        ArrayList<String> strList = new ArrayList<>();
        strList.add("选项item1");
        strList.add("选项item2");
        strList.add("选项item3");

        ArrayList<View.OnClickListener> clickList = new ArrayList<>();
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SQLiteOnWebActivity.this, "点击事件触发", Toast.LENGTH_SHORT).show();
            }
        };
        clickList.add(clickListener);
        clickList.add(clickListener);
        clickList.add(clickListener);
        clickList.add(clickListener);

        //具体初始化逻辑看下面的图
        hintPopupWindow = new HintPopupWindow(this, strList, clickList);
    }
}
