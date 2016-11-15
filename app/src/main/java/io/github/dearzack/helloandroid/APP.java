package io.github.dearzack.helloandroid;

import android.app.Application;
import android.content.Context;

import io.github.dearzack.helloandroid.greendao.TestDao;
import io.github.dearzack.helloandroid.util.GreenDaoManager;
import io.github.skyhacker2.sqliteonweb.SQLiteOnWeb;

/**
 * Created by Zack on 2016/11/12.
 */

public class APP extends Application {
    private static Context context;
    public static TestDao testDao;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initDB();
    }

    public static Context getContext() {
        return context;
    }

    private void initDB() {
        GreenDaoManager cdm = GreenDaoManager.getInstance();
        testDao = cdm.getSession().getTestDao();
        SQLiteOnWeb.init(this).start();
    }
}
