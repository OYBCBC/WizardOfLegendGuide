package com.oybc.wizardoflegendguide.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.app.Const;
import com.oybc.wizardoflegendguide.service.entitiy.Cloak;

/**
 * Created by Administrator on 2018/8/30.
 */

public class CloakDetailActivity extends AppCompatActivity {

    private static final String TAG = "CloakDetailActivity";
    private Cloak cloak;

    private Context mContext = this;
    private ImageView mPic;
    private TextView mName;
    private TextView mDscrp;
    private TextView mMaxHealth;
    private TextView mRunSpeed;
    private TextView mCriticalChance;
    private TextView mCriticalDamage;
    private TextView mDamge;
    private TextView mEnvadeChance;
    private TextView mArmor;
    private TextView mCd;
    private TextView mDefense;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloak_detail);
        bindViews();
        setViewResources();
    }

    private void setViewResources() {
        cloak = (Cloak) getIntent().getSerializableExtra("cloak");
        Log.i(TAG, cloak.toString());
        if (cloak != null) {
            Glide.with(mContext).load(Const.BASE_IMG_URL + cloak.getPic()).into(mPic);
            mName.setText(cloak.getName());
            mDscrp.setText(cloak.getDscrp());
            mMaxHealth.setText(cloak.getMaxHealth());
            mRunSpeed.setText(cloak.getRunSpeed());
            mCriticalChance.setText(cloak.getCriticalChance());
            mCriticalDamage.setText(cloak.getCriticalDamage());
            mDamge.setText(cloak.getDamage());
            mEnvadeChance.setText(cloak.getEnvadeChance());
            mArmor.setText(cloak.getArmor());
            mCd.setText(cloak.getCd());
            mDefense.setText(cloak.getDefense());
        } else {
            Toast.makeText(mContext, "null point", Toast.LENGTH_LONG).show();
        }

    }

    private void bindViews() {
        mName = findViewById(R.id.name);
        mPic = findViewById(R.id.pic);
        mDscrp = findViewById(R.id.dscrp);
        mMaxHealth = findViewById(R.id.max_health);
        mRunSpeed = findViewById(R.id.run_speed);
        mCriticalChance = findViewById(R.id.critical_chance);
        mCriticalDamage = findViewById(R.id.critical_damage);
        mDamge = findViewById(R.id.damge);
        mEnvadeChance = findViewById(R.id.envade_chance);
        mArmor = findViewById(R.id.armor);
        mCd = findViewById(R.id.cd);
        mDefense = findViewById(R.id.defense);
    }
}
