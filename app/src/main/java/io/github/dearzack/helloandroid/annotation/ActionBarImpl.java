package io.github.dearzack.helloandroid.annotation;

/**
 * Created by Zack on 2017/6/8.
 */

public class ActionBarImpl extends ActionBar {
    @Override
    public int getNavigationMode() {
        return ActionBar.a;
    }

    @Override
    public void setNavigationMode(@NavigationMode int mode) {

    }

    private void test() {
        setNavigationMode(ActionBar.b);
    }
}
