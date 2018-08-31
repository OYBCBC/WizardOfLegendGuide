package com.oybc.wizardoflegendguide.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.service.entitiy.Skill;
import com.oybc.wizardoflegendguide.service.presenter.SkillPresenter;
import com.oybc.wizardoflegendguide.service.view.SkillView;
import com.oybc.wizardoflegendguide.service.view.adapter.SkillShowAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */

public class SkillShowActivity extends AppCompatActivity {

    private Context mContext = this;
    private GridView gridView;
    private List<Skill> skills;

    private SkillShowAdapter skillShowAdapter = new SkillShowAdapter(mContext,skills);

    private SkillPresenter mSkillPresenter = new SkillPresenter(mContext);

    private SkillView mSkillView = new SkillView() {
        @Override
        public void onSuccess(List<Skill> skills) {
            Toast.makeText(mContext,skills+"",Toast.LENGTH_LONG).show();
            gridView.setAdapter(new SkillShowAdapter(mContext,skills));
            skillShowAdapter.notifyDataSetChanged();
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
        requestData();

    }

    private void requestData() {
        mSkillPresenter.onCreate();
        mSkillPresenter.attachView(mSkillView);
        mSkillPresenter.getSkill();
    }

    private void bindViews() {
        gridView = findViewById(R.id.grid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSkillPresenter.onStop();
    }
}
