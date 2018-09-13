package com.oybc.wizardoflegendguide.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.app.Const;
import com.oybc.wizardoflegendguide.service.entitiy.Cloak;
import com.oybc.wizardoflegendguide.service.presenter.CloakPresenter;
import com.oybc.wizardoflegendguide.service.view.CloakView;

import com.oybc.wizardoflegendguide.service.view.adapter.CloakShowAdapter;
import com.oybc.wizardoflegendguide.ui.custom.PageGridView;

import java.util.ArrayList;
import java.util.List;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class CloakShowActivityTest extends AppCompatActivity {

    private static final String TAG = "CloakShowActivity";
    private Context mContext = this;
    private PageGridView gridView;

    private Parcelable state;

    private int page = 0;

    private Spinner spinner;
    private String searchParamName;
    private SearchView searchView;

    private List<Cloak> cloaks = new ArrayList<>();

    private CloakShowAdapter cloakShowAdapter;

    private CloakPresenter mCloakPresenter = new CloakPresenter(mContext);

    private CloakView mCloakView = new CloakView() {

        CloakShowAdapter cloakShowAdapter = new CloakShowAdapter(mContext, cloaks);

        @Override
        public void onSuccess(List<Cloak> cloaks) {
            Log.i(TAG, "cloakView.onSuccess()");
            cloakShowAdapter.setData(cloaks);
            gridView.setAdapter(cloakShowAdapter);
            gridView.restoreScroll();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
            gridView.updateFooter(Const.MSG_ERROR);
        }

    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        initSearch();
        gridViewSetting();
        requestData(0);
    }

    private void changeMode() {
        if (page >= 0) {
            page = -1;
        } else {
            page = 0;
        }

    }

    private void initSearch() {
        spinner = findViewById(R.id.spinner);
        searchView = findViewById(R.id.search_view);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {//选择item的选择点击监听事件
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                searchParamName = spinner.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                switch (searchParamName) {
                    case "名字":
                        searchData("name", string);
                        break;
                    case "描述":
                        searchData("dscrp", string);
                        break;
                }
                changeMode();
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });


    }

    private void searchData(String s1, String s2) {
        mCloakPresenter.onStop();
        mCloakPresenter.onCreate();
        mCloakPresenter.attachView(mCloakView);
        mCloakPresenter.searchCloak(s1, s2);
    }

    private void gridViewSetting() {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, CloakDetailActivity.class);
                Cloak cloak = (Cloak) gridView.getItemAtPosition(position);
                Log.i(TAG, cloak.toString());
                intent.putExtra("cloak", cloak);
                startActivity(intent);
            }
        });
    }

    private void requestData(int page) {
        gridView.updateFooter(View.VISIBLE);
        mCloakPresenter.onCreate();
        mCloakPresenter.attachView(mCloakView);
        mCloakPresenter.getCloak(page);

    }

    private void bindViews() {
        LinearLayout llParent = new LinearLayout(this);
        
        llParent.setOrientation(LinearLayout.VERTICAL);
        llParent.setGravity(Gravity.TOP);
        
        gridView = new PageGridView(this);

        gridView.setNumColumns(3);
        gridView.setVerticalSpacing(10);
        gridView.setHorizontalSpacing(15);
        //这里注意，一定要设置Gravity为Gravity.CENTER,否则不会出现页脚
        gridView.setGravity(Gravity.CENTER);

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && page!=-1) {
                    // 滚动到底,请求下一页数据
                    if (view.getLastVisiblePosition() == (view.getCount() - 1)) {

                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view.getLastVisiblePosition() != (view.getCount() - 1)) {
                    gridView.updateFooter(View.GONE);
                }
            }
        });
        @SuppressLint("InflateParams") LinearLayout l2Parent = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.search_bar, null);
        llParent.addView(l2Parent);
        llParent.addView(gridView);

        setContentView(llParent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCloakPresenter.onStop();
    }

}
