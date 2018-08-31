package com.oybc.wizardoflegendguide.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.oybc.wizardoflegendguide.service.entitiy.Skill;
import com.oybc.wizardoflegendguide.service.manager.DataManager;
import com.oybc.wizardoflegendguide.service.view.SkillView;
import com.oybc.wizardoflegendguide.service.view.View;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class SkillPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private SkillView mSkillView;
    private List<Skill> mSkills;
    public SkillPresenter(Context mContext){
        this.mContext = mContext;
    }
    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mSkillView = (SkillView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {
    }

    public void searchSkill(String id){
        mCompositeSubscription.add(manager.searchSkill(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Skill>>() {
                    @Override
                    public void onCompleted() {
                        if (mSkills != null){
                            mSkillView.onSuccess(mSkills);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mSkillView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Skill> skills) {
                        mSkills = skills;
                    }



                })
        );
    }

    public void getSkill(){
        mCompositeSubscription.add(manager.getSkill()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Skill>>() {
                    @Override
                    public void onCompleted() {
                        if (mSkills != null){
                            mSkillView.onSuccess(mSkills);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mSkillView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Skill> skills) {
                        mSkills = skills;
                    }
                })
        );
    }
}
