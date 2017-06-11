package io.github.dearzack.helloandroid;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

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
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            //BlockCanary是一个第三方库，是一个非侵入式的性能监控函数库，详情见官网。
        }
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
