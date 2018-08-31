package com.oybc.wizardoflegendguide.service;


import com.oybc.wizardoflegendguide.service.entitiy.BookBean;
import com.oybc.wizardoflegendguide.service.entitiy.Skill;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface RetrofitService {


    @GET("guide_for_Wizard_of_Legend_server/GetSkill")
    Observable<List<Skill>> getSkill();


    @GET("guide_for_Wizard_of_Legend_server/SearchSkill")
    Observable<List<Skill>> searchSkill(@Query("id") String id);




}
