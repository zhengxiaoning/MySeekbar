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
 private List<String>mList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_seekbar);
        mySeekbar=findViewById(R.id.mySeekbar);
        initData();
        mySeekbar.setProgress(0);
        mySeekbar.setThumbClick(new MySeekbar.ThumbClickListener() {
            @Override
            public void onThumbClick() {
                initView();
            }
        });
    }

    private void initData() {
       for(int i=0;i<4;i++){
           mList.add("已读"+i);
       }
    }

    private void initView() {
        classificationSpinner=new ClassificationSpinner(this,currentIndex,mList, R.color.color_blue_movie);
        classificationSpinner.setWidth(400);
        classificationSpinner.showAsDropDown(mySeekbar,mySeekbar.getThumb().getBounds().left,0);
        Log.d("hh", "initView: "+mySeekbar.getThumb().getBounds().left);
    }
}
