package com.oybc.wizardoflegendguide.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.LinearLayout;
import android.widget.Toast;

import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.service.entitiy.Arcana;
import com.oybc.wizardoflegendguide.service.presenter.ArcanaPresenter;
import com.oybc.wizardoflegendguide.service.view.ArcanaView;
import com.oybc.wizardoflegendguide.service.view.adapter.ArcanaShowAdapter;
import com.oybc.wizardoflegendguide.ui.custom.PageGridView;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */

public class ArcanaShowActivityTest extends AppCompatActivity {

    private static final String TAG = "ArcanaShowActivity";
    private Context mContext = this;
    private PageGridView gridView;

    private int page = 0;
    private int visibleLastIndex = 0;   //最后的可视项索引
    private int visibleItemCount;       // 当前窗口可见项总数

    private EditText paramName;
    private EditText param;
    private Button request;

    private Button pageTo;

    private List<Arcana> arcanas;

    private ArcanaShowAdapter arcanaShowAdapter = new ArcanaShowAdapter(mContext, arcanas);

    private ArcanaPresenter mArcanaPresenter = new ArcanaPresenter(mContext);

    private ArcanaView mArcanaView = new ArcanaView() {
        @Override
        public void onSuccess(List<Arcana> arcanas) {
//            Toast.makeText(mContext, arcanas +"",Toast.LENGTH_LONG).show();
            gridView.setAdapter(new ArcanaShowAdapter(mContext, arcanas));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, ArcanaDetailActivity.class);
                    Arcana arcana = (Arcana) gridView.getItemAtPosition(position);
//                    Log.i(TAG,"onItemClick: " + arcana);
                    intent.putExtra("arcana", arcana);
                    startActivity(intent);
                }
            });
//            arcanaShowAdapter.notifyDataSetChanged();
            gridView.updateFooter(View.GONE);
        }

        @Override
        public void onError(String result) {
            Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        requestData(0);

    }

    private void searchData(String s1, String s2) {
        mArcanaPresenter.onStop();
        mArcanaPresenter.onCreate();
        mArcanaPresenter.attachView(mArcanaView);
        mArcanaPresenter.searchSkill(s1, s2);
    }

    private void requestData(int page) {
        mArcanaPresenter.onCreate();
        mArcanaPresenter.attachView(mArcanaView);
        mArcanaPresenter.getSkill(page);
    }

    private void bindViews() {
//        gridView = findViewById(R.id.grid);

        LinearLayout llParent = new LinearLayout(this);
        llParent.setOrientation(LinearLayout.VERTICAL);
        llParent.setGravity(Gravity.TOP);

        gridView = new PageGridView(this);
        llParent.addView(gridView);

        gridView.setNumColumns(3);
        gridView.setVerticalSpacing(10);
        gridView.setHorizontalSpacing(15);
        //这里注意，一定要设置Gravity为Gravity.CENTER,否则不会出现页脚
        gridView.setGravity(Gravity.CENTER);
        
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 滚动到底,请求下一页数据
                    if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                        page ++;
                        requestData(page);
                        gridView.updateFooter(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(view.getLastVisiblePosition() != (view.getCount() - 1)){
                    gridView.updateFooter(View.GONE);
                }
            }
        });

        setContentView(llParent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mArcanaPresenter.onStop();
    }
}
