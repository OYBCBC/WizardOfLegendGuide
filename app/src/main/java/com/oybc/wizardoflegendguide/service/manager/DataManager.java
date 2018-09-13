package com.oybc.wizardoflegendguide.service.manager;

import android.content.Context;

import com.oybc.wizardoflegendguide.service.RetrofitHelper;
import com.oybc.wizardoflegendguide.service.RetrofitService;
import com.oybc.wizardoflegendguide.service.entitiy.Arcana;
import com.oybc.wizardoflegendguide.service.entitiy.Cloak;
import com.oybc.wizardoflegendguide.service.entitiy.Relics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

public class DataManager {

    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<List<Arcana>> getArcana(int page) {
        return mRetrofitService.getArcana(page);
    }

    public Observable<List<Arcana>> searchArcana(HashMap map) {
        return mRetrofitService.searchArcana(map);
    }

    public Observable<List<Relics>> getRelics(int n) {
        return mRetrofitService.getRelics(n);
    }

    public Observable<List<Relics>> searchRelics(HashMap map) {
        return mRetrofitService.searchRelics(map);
    }

    public Observable<List<Cloak>> getCloak(int n) {
        return mRetrofitService.getCloak(n);
    }

    public Observable<List<Cloak>> searchCloak(HashMap map) {
        return mRetrofitService.searchCloak(map);
    }
}
