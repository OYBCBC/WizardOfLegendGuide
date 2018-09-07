package com.oybc.wizardoflegendguide.service.manager;

import android.content.Context;

import com.oybc.wizardoflegendguide.service.RetrofitHelper;
import com.oybc.wizardoflegendguide.service.RetrofitService;
import com.oybc.wizardoflegendguide.service.entitiy.Arcana;
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

    public Observable<List<Arcana>> getArcana() {
        return mRetrofitService.getArcana();
    }

    public Observable<List<Arcana>> searchArcana(HashMap map) {
        return mRetrofitService.searchArcana(map);
    }

    public Observable<List<Relics>> getRelics() {
        return mRetrofitService.getRelics();
    }

    public Observable<List<Arcana>> searchRelics(HashMap map) {
        return mRetrofitService.searchRelics(map);
    }
}
