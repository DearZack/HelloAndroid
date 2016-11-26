package io.github.dearzack.helloandroid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.utils.ImageUtils;

import io.github.dearzack.helloandroid.R;

/**
 * Created by Zack on 2016/11/26.
 */

public class MediaPlayView extends View {

    private Context mContext;

    private Bitmap needle;  //指针
    private Bitmap disc;  //底部圆盘
    private Bitmap cover;  //封面

    private int needleX, needleY;//指针放置的位子
    private int discX, discY;//圆盘放置的位置
    private int coverX, coverY;//圆盘放置的位置

    public MediaPlayView(Context context) {
        this(context, null);
    }

    public MediaPlayView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MediaPlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        Log.e("zhouxiong", "init");
        needle = ImageUtils.getBitmap(mContext.getResources(), R.drawable.needle);
        disc = ImageUtils.getBitmap(mContext.getResources(), R.drawable.disc);
        cover = ImageUtils.getBitmap(mContext.getResources(), R.drawable.placeholder_disk_play_song);
        needle = ImageUtils.scale(needle, needle.getWidth() / 3, needle.getHeight() / 3);
        disc = ImageUtils.scale(disc, disc.getWidth() / 3, disc.getHeight() / 3);
        cover = ImageUtils.scale(cover, cover.getWidth() / 3, cover.getHeight() / 3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("zhouxiong", "onDraw");
        super.onDraw(canvas);
        canvas.drawBitmap(disc, discX, discY, null);
        canvas.drawBitmap(cover, coverX, coverY, null);
        canvas.drawBitmap(needle, needleX, needleY, null);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.e("zhouxiong", "onAttachedToWindow");
        super.onAttachedToWindow();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.e("zhouxiong", "onSizeChanged");
        int needleOffSetY = 50, discOffSetY = 320;
        super.onSizeChanged(w, h, oldw, oldh);
        needleX = getWidth() / 2/* - needle.getWidth() / 2*/ - needleOffSetY;
        needleY = -needleOffSetY;//// TODO: 2016/11/26 暂定
        discX = getWidth() / 2 - disc.getWidth() / 2;
        discY = getHeight() / 2 - disc.getHeight() / 2 - discOffSetY;
        coverX = getWidth() / 2 - cover.getWidth() / 2;
        coverY = getHeight() / 2 - cover.getHeight() / 2 - discOffSetY;
    }
}
