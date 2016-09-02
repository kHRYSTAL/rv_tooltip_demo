package me.khrystal.tooltip_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/9/2
 * update time:
 * email: 723526676@qq.com
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder>{

    private List<String> mDataList;
    private Context mContext;

    public SimpleAdapter(Context context, List<String> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bind(mDataList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
