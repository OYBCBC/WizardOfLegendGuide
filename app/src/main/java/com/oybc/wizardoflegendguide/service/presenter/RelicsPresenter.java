package com.oybc.wizardoflegendguide.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.oybc.wizardoflegendguide.service.entitiy.Relics;
import com.oybc.wizardoflegendguide.service.manager.DataManager;
import com.oybc.wizardoflegendguide.service.view.ArcanaView;
import com.oybc.wizardoflegendguide.service.view.RelicsView;
import com.oybc.wizardoflegendguide.service.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RelicsPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private RelicsView mRelicsView;
    private List<Relics> mRelics = new ArrayList<>();

    public RelicsPresenter(Context mContext) {
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
        mRelicsView = (RelicsView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {
    }

    public void searchRelics(String paramName, String param) {
        HashMap map = new HashMap<String, String>();
        map.put(paramName, param);

        mCompositeSubscription.add(manager.searchRelics(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Relics>>() {
                    @Override
                    public void onCompleted() {
                        if (mRelics != null) {
                            mRelicsView.onSuccess(mRelics);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mRelicsView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Relics> relicss) {
                        mRelics = relicss;
                    }
                })
        );
    }

    public void getRelics(int page) {
        mCompositeSubscription.add(manager.getRelics(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Relics>>() {
                    @Override
                    public void onCompleted() {
                        if (mRelics != null) {
                            mRelicsView.onSuccess(mRelics);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mRelicsView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Relics> relicss) {
                        for (Relics relics : relicss) {
                            mRelics.add(relics);
                        }

                    }
                })
        );
    }
}
