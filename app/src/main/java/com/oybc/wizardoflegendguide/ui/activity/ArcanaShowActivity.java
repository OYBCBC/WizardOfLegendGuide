package com.oybc.wizardoflegendguide.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.service.entitiy.Arcana;
import com.oybc.wizardoflegendguide.service.presenter.ArcanaPresenter;
import com.oybc.wizardoflegendguide.service.view.ArcanaView;
import com.oybc.wizardoflegendguide.service.view.adapter.ArcanaShowAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */

public class ArcanaShowActivity extends AppCompatActivity {

    private static final String TAG = "ArcanaShowActivity";
    private Context mContext = this;
    private GridView gridView;

    private EditText paramName;
    private EditText param;
    private Button request;

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
            arcanaShowAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_show);
        bindViews();
        initSearch();
        requestData();

    }
    private void initSearch() {
        paramName = findViewById(R.id.paramName);
        param = findViewById(R.id.param);
        request = (Button)findViewById(R.id.request);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchData(paramName.getText().toString(),
                        param.getText().toString());
            }
        });
    }
    private void searchData(String s1, String s2) {
        mArcanaPresenter.onStop();
        mArcanaPresenter.onCreate();
        mArcanaPresenter.attachView(mArcanaView);
        mArcanaPresenter.searchSkill(s1, s2);
    }

    private void requestData() {
        mArcanaPresenter.onCreate();
        mArcanaPresenter.attachView(mArcanaView);
        mArcanaPresenter.getSkill();
    }

    private void bindViews() {
        gridView = findViewById(R.id.grid);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mArcanaPresenter.onStop();
    }
}
