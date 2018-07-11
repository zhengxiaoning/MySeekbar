package com.example.kobe.ProgressBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kobe.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class MySeekbarActivity extends AppCompatActivity {
    private MySeekbar mySeekbar;
    private ClassificationSpinner classificationSpinner;
    private int currentIndex; //spinner当前选中的位置
    private List<BookRoomState> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_seekbar);
        mySeekbar = findViewById(R.id.mySeekbar);
        initData();
        mySeekbar.setProgress(50);
        mySeekbar.setThumbClick(new MySeekbar.ThumbClickListener() {
            @Override
            public void onThumbClick() {
                initView();
            }
        });
    }

    private void initData() {
        BookRoomState unRead = new BookRoomState();
        unRead.setState("未读");
        unRead.setIcon(R.mipmap.book_icon_unread);
        mList.add(unRead);
        BookRoomState unfinished = new BookRoomState();
        unfinished.setState("未完成");
        unfinished.setIcon(R.mipmap.book_icon_unfinish);
        mList.add(unfinished);
        BookRoomState doneNotWell = new BookRoomState();
        doneNotWell.setState("完成未达标");
        doneNotWell.setIcon(R.mipmap.book_icon_unstandard);
        mList.add(doneNotWell);
        BookRoomState doneWell = new BookRoomState();
        doneWell.setState("达标");
        doneWell.setIcon(R.mipmap.book_icon_standard);
        mList.add(doneWell);

    }

    private void initView() {
        classificationSpinner = new ClassificationSpinner(this, currentIndex, mList, R.color.color_blue_movie);
        classificationSpinner.setWidth(mySeekbar.getWidth());
        classificationSpinner.showAsDropDown(mySeekbar, -classificationSpinner.getWidth() + mySeekbar.getThumb().getBounds().left + mySeekbar.getPaddingLeft() - mySeekbar.getThumbOffset() + 104, 0);
        Log.d("hh", "initView: " + mySeekbar.getThumb().getBounds().left + "   " + mySeekbar.getPaddingLeft() + " " + mySeekbar.getThumbOffset());
    }
}
