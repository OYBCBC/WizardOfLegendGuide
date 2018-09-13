package com.oybc.wizardoflegendguide.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.oybc.wizardoflegendguide.app.Const;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PageGridView extends LinearLayout {

    private GridView gridview;
    private LinearLayout footerView;

    private ProgressBar pb;
    private TextView tvMessage;

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

        footerView = new LinearLayout(getContext());

        pb = new ProgressBar(getContext());
        tvMessage = new TextView(getContext());
        tvMessage.setTextSize(20);

        footerView.addView(pb);
        footerView.addView(tvMessage);
        footerView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

        addView(footerView);

        footerView.getLayoutParams().width = LayoutParams.MATCH_PARENT;
        footerView.getLayoutParams().height = 100;
        footerView.setVisibility(View.GONE);
    }

    private Parcelable state;

    public void updateFooter(int statue) {
        state = gridview.onSaveInstanceState();
        updateFooterViewHandler.sendEmptyMessage(statue);
    }

    public void restoreScroll(){
        gridview.onRestoreInstanceState(state);
    }

    @SuppressLint("HandlerLeak")
    private Handler updateFooterViewHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            footerView.setVisibility(msg.what);

            switch (msg.what){
                case Const.MSG_GONE:
                    ((BaseAdapter) gridview.getAdapter()).notifyDataSetChanged();
                    break;
                case Const.MSG_ERROR:
                    tvMessage.setText("加载失败");
                    pb.setVisibility(GONE);
                    break;
            }

        }
    };

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        gridview.setOnScrollListener(onScrollListener);
    }

    public void setNumColumns(int number) {
        gridview.setNumColumns(number);
    }

    public void setVerticalSpacing(int spacing) {
        gridview.setVerticalSpacing(spacing);
    }

    public void setHorizontalSpacing(int spacing) {
        gridview.setHorizontalSpacing(spacing);
    }

    public void setColumnWidth(int width) {
        gridview.setColumnWidth(width);
    }

    public void setStretchMode(int stretchMode) {
        gridview.setStretchMode(stretchMode);
    }

    public void setAdapter(BaseAdapter adapter) {
        gridview.setAdapter(adapter);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        gridview.setOnItemClickListener(itemClickListener);
    }

    public Object getItemAtPosition(int position) {
        return gridview.getItemAtPosition(position);
    }

    public int getSelectedItemPosition() {
        return gridview.getSelectedItemPosition();
    }

    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    public int getFirstVisiblePosition() {
        return gridview.getFirstVisiblePosition();
    }

    public int getLastVisiblePosition() {
        return gridview.getLastVisiblePosition();
    }

    public void setSelection(int position) {
        gridview.setSelection(position);
    }
}
