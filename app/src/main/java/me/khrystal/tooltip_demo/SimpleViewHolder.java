package me.khrystal.tooltip_demo;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/9/2
 * update time:
 * email: 723526676@qq.com
 */
public class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String[] COLORS = {"#ff0000", "#00ff00", "#0000ff"};
    private Button btn1;
    private Button btn2;
    private String mText;
    private View mParent;

    public SimpleViewHolder(View itemView, View parent) {
        super(itemView);
        mParent = parent;
        btn1 = (Button) itemView.findViewById(R.id.item_btn1);
        btn2 = (Button) itemView.findViewById(R.id.item_btn2);
    }

    public void bind(String text) {
        itemView.setBackgroundColor(Color.parseColor(COLORS[getAdapterPosition() % COLORS.length]));
        mText = text;
        btn1.setText("text:" + text + ":btn1");
        btn2.setText("text:" + text + ":btn2");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new SimpleTooltip.Builder(v.getContext())
                .anchorView(v)
                .text("this is " + mText)
                .gravity(isTop() ? Gravity.TOP : Gravity.BOTTOM)
                .animated(true)
                .transparentOverlay(true)
                .build()
                .show();
    }

    public boolean isTop() {
        boolean onTop = true;
        int rootHeight = mParent.getMeasuredHeight();
        // display on bottom
        Log.d("SimpleViewHolder", "rootHeight:" + rootHeight
                + ",item.getTop()" + itemView.getTop());
        if (rootHeight / 2 > itemView.getTop()) {
            onTop = false;
        }
        return onTop;
    }
}
