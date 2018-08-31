package com.oybc.wizardoflegendguide.service.view;

import com.oybc.wizardoflegendguide.service.entitiy.Skill;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class SkillView implements View {

    public void onSuccess(Skill skill) {
    }

    public void onSuccess(List<Skill> skills) {
    }

    public void onError(String result) {
    }
}
