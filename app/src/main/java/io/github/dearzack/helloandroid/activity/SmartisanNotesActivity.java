package io.github.dearzack.helloandroid.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.util.SmartisanNotes;

public class SmartisanNotesActivity extends BaseActivity {

    //原始项目地址 https://github.com/shaohui10086/SmartisanNotes

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartisan_notes);
        imageView = (ImageView) findViewById(R.id.smartisan_note_view);
        Bitmap bitmap = SmartisanNotes.with(this).draw("知乎是一家创立于2011 年 1 月 26 "
                + "日的中国大陆社会化问答网站，产品形态模仿了美国类似网站Quora。“知乎”在古汉语中意为“知道吗”。2012 年 2 "
                + "月底，知乎使用“发现更大的世界”作为其宣传口号。 ").asBitmap();
        imageView.setImageBitmap(bitmap);
    }
}
