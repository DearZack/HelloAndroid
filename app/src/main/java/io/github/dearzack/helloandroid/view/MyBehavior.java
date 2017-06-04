package io.github.dearzack.helloandroid.view;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.dearzack.helloandroid.R;

/**
 * Created by Zack on 2017/5/29.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        TextView email = (TextView) child.findViewById(R.id.email);
        ImageView imageView = (ImageView) child.findViewById(R.id.portrait);
        imageView.setVisibility(View.GONE);
        email.setTextColor(Color.parseColor("#ff00ff"));
        return true;
    }
}
