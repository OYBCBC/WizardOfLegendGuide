package com.oybc.wizardoflegendguide.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.oybc.wizardoflegendguide.service.entitiy.Arcana;
import com.oybc.wizardoflegendguide.service.manager.DataManager;
import com.oybc.wizardoflegendguide.service.view.ArcanaView;
import com.oybc.wizardoflegendguide.service.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ArcanaPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private ArcanaView mArcanaView;
    private List<Arcana> mArcanas;

    public ArcanaPresenter(Context mContext) {
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
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mArcanaView = (ArcanaView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {
    }

    public void searchSkill(String paramName, String param) {
        HashMap map = new HashMap<String, String>();
        map.put(paramName, param);

        mCompositeSubscription.add(manager.searchArcana(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Arcana>>() {
                    @Override
                    public void onCompleted() {
                        if (mArcanas != null) {
                            mArcanaView.onSuccess(mArcanas);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mArcanaView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Arcana> arcanas) {
                        mArcanas = arcanas;
                    }


                })
        );
    }

    public void getSkill() {
        mCompositeSubscription.add(manager.getArcana()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Arcana>>() {
                    @Override
                    public void onCompleted() {
                        if (mArcanas != null) {
                            mArcanaView.onSuccess(mArcanas);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mArcanaView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Arcana> arcanas) {
                        mArcanas = arcanas;
                    }
                })
        );
    }
}
