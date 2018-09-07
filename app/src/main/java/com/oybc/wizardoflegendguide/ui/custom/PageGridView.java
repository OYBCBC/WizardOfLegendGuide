package com.oybc.wizardoflegendguide.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/9/7.
 */

public class PageGridView extends LinearLayout {

    private GridView gridview;
    private LinearLayout footerView;

    public static final String TAG = "ListViewWithPage";
    public PageGridView(Context context) {
        super(context);
        init();
    }

    public PageGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    public PageGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        gridview = new GridView(getContext());
        setOrientation(LinearLayout.VERTICAL);
        addView(gridview);

        gridview.getLayoutParams().width = LayoutParams.MATCH_PARENT;
        gridview.getLayoutParams().height = LinearLayout.LayoutParams.WRAP_CONTENT;

        //设置footer,可以在里面加进度条等内容
        footerView = new LinearLayout(getContext());

        ProgressBar pb = new ProgressBar(getContext());
        TextView tvMessage = new TextView(getContext());
        tvMessage.setText("正在加载数据。。。");
        tvMessage.setTextSize(20);

        footerView.addView(pb);
        footerView.addView(tvMessage);
        footerView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP);

        addView(footerView);

        footerView.getLayoutParams().width = LayoutParams.MATCH_PARENT;
        footerView.getLayoutParams().height = 100;
        footerView.setVisibility(View.GONE);
    }

    //由于调用此方法一般都为单开线程，不能直接更新控件状态，因此需要一个Handler来协助
    public void updateFooter(int statue){
        updateFooterViewHandler.sendEmptyMessage(statue);
    }

    @SuppressLint("HandlerLeak")
    private Handler updateFooterViewHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //这里状态 可以控制为多个，如果想要下拉箭头的话，可以根据状态来修改控件内容，这里我只设置是否显示而已
            footerView.setVisibility(msg.what);
            //当设置View.GONE的时候，数据已经加载完成，因此需要通知数据改变
            if(msg.what==View.GONE){
                ((BaseAdapter)gridview.getAdapter()).notifyDataSetChanged();
            }
        }
    };

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener){
        gridview.setOnScrollListener(onScrollListener);
    }

    public void setNumColumns(int number){
        gridview.setNumColumns(number);
    }

    public void setVerticalSpacing(int spacing){
        gridview.setVerticalSpacing(spacing);
    }

    public void setHorizontalSpacing(int spacing){
        gridview.setHorizontalSpacing(spacing);
    }

    public void setColumnWidth(int width){
        gridview.setColumnWidth(width);
    }

    public void setStretchMode(int stretchMode){
        gridview.setStretchMode(stretchMode);
    }

    public void setAdapter(BaseAdapter adapter){
        gridview.setAdapter(adapter);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener){
        gridview.setOnItemClickListener(itemClickListener);
    }

    public Object getItemAtPosition(int position){
        return gridview.getItemAtPosition(position);
    }


}
