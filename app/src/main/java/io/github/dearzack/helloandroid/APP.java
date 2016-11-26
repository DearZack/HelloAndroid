package io.github.dearzack.helloandroid;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.amitshekhar.DebugDB;

import io.github.dearzack.helloandroid.greendao.TestDao;
import io.github.dearzack.helloandroid.util.GreenDaoManager;

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
//        SQLiteOnWeb.init(this).start();
    }
}
