package com.oybc.wizardoflegendguide.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.app.Const;
import com.oybc.wizardoflegendguide.service.entitiy.Arcana;

/**
 * Created by Administrator on 2018/8/30.
 */

public class ArcanaDetailActivity extends AppCompatActivity {

    private Context mContext = this;
    private Arcana arcana;

    private ImageView mPic;
    private TextView mName;
    private TextView mType;
    private TextView mNature;
    private TextView mDscrp;
    private TextView mBasic_dmg;
    private TextView mEnhanced_dmg;
    private TextView mCd;
    private TextView mFend_off;
    private TextView mDuration;
    private TextView mOffset;
    private TextView mNote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_detail);
        bindViews();
        setViewResources();

    }

    private void setViewResources() {
        arcana = (Arcana) getIntent().getSerializableExtra("arcana");
        if (arcana != null) {
            Glide.with(mContext).load(Const.BASE_IMG_URL + arcana.getPic()).into(mPic);
            mName.setText("" + arcana.getName());
            mType.setText("" + arcana.getType());
            mNature.setText("" + arcana.getNature());
            mDscrp.setText("" + arcana.getDscrp());
            mBasic_dmg.setText("" + arcana.getDmg());
            mEnhanced_dmg.setText("" + arcana.getEhDmg());
            mCd.setText("" + arcana.getCd());
            mFend_off.setText("" + arcana.getFendoff());
            mDuration.setText("" + arcana.getDuration());
            mOffset.setText("" + arcana.getOffset());
            mNote.setText("" + arcana.getNote());
        } else {
            Toast.makeText(mContext, "null point", Toast.LENGTH_LONG).show();
        }

    }

    private void bindViews() {
        mPic = findViewById(R.id.pic);
        mName = findViewById(R.id.name);
        mType = findViewById(R.id.type);
        mNature = findViewById(R.id.nature);
        mDscrp = findViewById(R.id.dscrp);
        mBasic_dmg = findViewById(R.id.basic_dmg);
        mEnhanced_dmg = findViewById(R.id.enhanced_dmg);
        mCd = findViewById(R.id.cd);
        mFend_off = findViewById(R.id.fend_off);
        mDuration = findViewById(R.id.duration);
        mOffset = findViewById(R.id.offset);
        mNote = findViewById(R.id.note);
    }


    @Override
    protected void onStop() {
        super.onStop();
        arcana = null;
    }
}
