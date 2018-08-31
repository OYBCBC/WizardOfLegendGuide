package com.oybc.wizardoflegendguide.service.manager;

import android.content.Context;

import com.oybc.wizardoflegendguide.service.RetrofitHelper;
import com.oybc.wizardoflegendguide.service.RetrofitService;
import com.oybc.wizardoflegendguide.service.entitiy.Skill;

import java.util.List;

import rx.Observable;

public class DataManager {

    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<List<Skill>> getSkill(){
        return mRetrofitService.getSkill();
    }

    public Observable<List<Skill>> searchSkill(String id){
        return mRetrofitService.searchSkill(id);
    }
}
