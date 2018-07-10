package com.example.kobe.ProgressBar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.example.kobe.myapplication.R;
import java.util.List;

public class ClassificationSpinner extends PopupWindow {
    private Context context;
    private IFLItemOnClickListener itemOnClickListener;
    private List<String> list;
    private int currentIndex;
    private int color;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ClassificationSpinnerAdapter adapter;
    public ClassificationSpinner(Context context,int currentIndex,List<String>list,int color){
        super(context);
        this.context=context;
        this.currentIndex=currentIndex;
        this.list=list;
        this.color=color;
        init();
    }
    public void notifyDataSetChanged(Context context,int currentIndex,List<String> list) {
        this.context = context;
        this.currentIndex = currentIndex;
        this.list = list;
        init();
    }
    /**
     * 设置界面显示屏幕位置
     */
    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        super.showAsDropDown(anchor, xoff, yoff);
    }
    private void init(){
        View view= LayoutInflater.from(context).inflate(R.layout.spinner_classification,null);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        mRecyclerView=view.findViewById(R.id.list);
        linearLayoutManager=new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter=new ClassificationSpinnerAdapter(context,currentIndex,list,color);
        mRecyclerView.setAdapter(adapter);
        adapter.setItemOnClickListener(new IFLItemOnClickListener() {
            @Override
            public void onClickListener(View view, int position) {
                dismiss();
                if(itemOnClickListener!=null)
                    itemOnClickListener.onClickListener(view,position);
            }
        });

    }

}



