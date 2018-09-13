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
import com.oybc.wizardoflegendguide.service.entitiy.Relics;

/**
 * Created by Administrator on 2018/8/30.
 */

public class RelicsDetailActivity extends AppCompatActivity {

    private static final String TAG = "RelicsDetailActivity";
    private Relics relics;

    private Context mContext = this;
    private ImageView mPic;
    private TextView mDscrp;
    private TextView mKind;
    private TextView mName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relics_detail);
        bindViews();
        setViewResources();
    }

    private void setViewResources() {
        relics = (Relics)getIntent().getSerializableExtra("relics");
        Log.i(TAG, relics.toString());
        if (relics != null) {
            Glide.with(mContext).load(Const.BASE_IMG_URL + relics.getPic()).into(mPic);
            mName.setText("" + relics.getName());
            mDscrp.setText("" + relics.getDscrp());
            mKind.setText(""+relics.getKind());
        } else {
            Toast.makeText(mContext, "null point", Toast.LENGTH_LONG).show();
        }

    }

    private void bindViews() {
        mName = findViewById(R.id.name);
        mPic = findViewById(R.id.pic);
        mDscrp = findViewById(R.id.dscrp);
        mKind = findViewById(R.id.kind);
    }
}
