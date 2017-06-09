package io.github.dearzack.helloandroid.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Zack on 2017/6/8.
 */

public abstract class ActionBar {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({a, b, c})
    public @interface NavigationMode {}

    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;

    @NavigationMode
    public abstract int getNavigationMode();

    public abstract void setNavigationMode(@NavigationMode int mode);
}
