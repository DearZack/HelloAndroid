package io.github.dearzack.helloandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.view.MyRelativeLayout;
import io.github.dearzack.helloandroid.view.MyTextView;

public class TouchActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    private static final String TAG = "TouchActivity";
    private MyRelativeLayout myRelativeLayout;
    private MyTextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        myRelativeLayout = (MyRelativeLayout) findViewById(R.id.root);
        myTextView = (MyTextView) findViewById(R.id.sub_view);
        myTextView.setOnClickListener(this);
        myTextView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent ACTION_DOWN");
//                return true;//如果在这里return true，后续move、up事件view也接受不到
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "dispatchTouchEvent ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouchEvent ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sub_view:
                Log.e(TAG, "MyTextView onClick");
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent ev) {
        switch (v.getId()) {
            case R.id.sub_view:
                switch (ev.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "MyTextView onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "MyTextView onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "MyTextView onTouch ACTION_UP");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.e(TAG, "MyTextView onTouch ACTION_CANCEL");
                        break;
                }
                break;
        }
        return false;
    }
}
