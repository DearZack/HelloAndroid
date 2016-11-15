package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;

import io.github.dearzack.helloandroid.APP;
import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.bean.Test;

public class SQLiteOnWebActivity extends BaseActivity {

    //https://github.com/skyhacker2/SQLiteOnWeb-Android

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
    }
}
