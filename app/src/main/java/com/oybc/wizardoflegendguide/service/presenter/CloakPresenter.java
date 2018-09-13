package com.oybc.wizardoflegendguide.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.oybc.wizardoflegendguide.service.entitiy.Cloak;
import com.oybc.wizardoflegendguide.service.manager.DataManager;
import com.oybc.wizardoflegendguide.service.view.CloakView;
import com.oybc.wizardoflegendguide.service.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class CloakPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private CloakView mCloakView;
    private List<Cloak> mCloak = new ArrayList<>();

    public CloakPresenter(Context mContext) {
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
        mCloakView = (CloakView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {
    }

    public void searchCloak(String paramName, String param) {
        HashMap map = new HashMap<String, String>();
        map.put(paramName, param);

        mCompositeSubscription.add(manager.searchCloak(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Cloak>>() {
                    @Override
                    public void onCompleted() {
                        if (mCloak != null) {
                            mCloakView.onSuccess(mCloak);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mCloakView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Cloak> relicss) {
                        mCloak = relicss;
                    }
                })
        );
    }

    public void getCloak(int page) {
        mCompositeSubscription.add(manager.getCloak(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Cloak>>() {
                    @Override
                    public void onCompleted() {
                        if (mCloak != null) {
                            mCloakView.onSuccess(mCloak);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mCloakView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(List<Cloak> relicss) {
                        for (Cloak relics : relicss) {
                            mCloak.add(relics);
                        }

                    }
                })
        );
    }
}
