package com.oybc.wizardoflegendguide.service;


import com.oybc.wizardoflegendguide.service.entitiy.Arcana;
import com.oybc.wizardoflegendguide.service.entitiy.Cloak;
import com.oybc.wizardoflegendguide.service.entitiy.Relics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


public interface RetrofitService {



    @GET("guide_for_Wizard_of_Legend_server/GetArcana")
    Observable<List<Arcana>> getArcana(@Query("page") int page);


    @GET("guide_for_Wizard_of_Legend_server/SearchArcana")
    Observable<List<Arcana>> searchArcana(@QueryMap() HashMap<String,String> map);


    @GET("guide_for_Wizard_of_Legend_server/GetRelics")
    Observable<List<Relics>> getRelics(@Query("page") int page);

    @GET("guide_for_Wizard_of_Legend_server/SearchRelics")
    Observable<List<Relics>> searchRelics(@QueryMap() HashMap<String,String> map);

    @GET("guide_for_Wizard_of_Legend_server/GetCloak")
    Observable<List<Cloak>> getCloak(@Query("page") int page);

    @GET("guide_for_Wizard_of_Legend_server/SearchCloak")
    Observable<List<Cloak>> searchCloak(@QueryMap() HashMap<String,String> map);
}
