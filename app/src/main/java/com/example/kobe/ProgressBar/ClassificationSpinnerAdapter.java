package com.example.kobe.ProgressBar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kobe.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassificationSpinnerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BookRoomState> list;
    private int currentIndex;
    private IFLItemOnClickListener itemOnClickListener;

    private int color;//item 选中字体的颜色

    /**
     * context       上下文
     * currentIndex  当前选中item
     * list          列表显示文本内容
     */
    public ClassificationSpinnerAdapter(Context context, int currentIndex, List<BookRoomState> list, int color) {
        this.context = context;
        this.currentIndex = currentIndex;
        this.list = list;
        this.color = color;
    }

    public void setItemOnClickListener(IFLItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list != null && list.size() > 0 && position <= list.size() - 1) {
                    itemOnClickListener.onClickListener(v, position);
                    //防止快速点击或者网络请求速度低引起的状态切换不及时
                    viewHolder.textView.setTextColor(color);
                    currentIndex = position;
                    notifyDataSetChanged();
                }
            }
        });
        //如果数据只有一条或者最后一条隐藏下划线
        if (list != null && list.size() > 0 && position == list.size() - 1) {
            viewHolder.line.setVisibility(View.GONE);
        } else {
            viewHolder.line.setVisibility(View.VISIBLE);
        }
        //当前选中标识
        if (currentIndex == position) {
            viewHolder.textView.setTextColor(color);
        } else {
            viewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.color_FF333333));
        }
        //设置分类内容
        if (list != null && list.size() > 0 && position <= list.size() - 1) {
            viewHolder.textView.setText(list.get(position).getState());
            viewHolder.imageView.setImageResource(list.get(position).getIcon());

        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtView)
        TextView textView;
        @BindView(R.id.imgView)
        ImageView imageView;
        @BindView(R.id.line)
        View line;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
