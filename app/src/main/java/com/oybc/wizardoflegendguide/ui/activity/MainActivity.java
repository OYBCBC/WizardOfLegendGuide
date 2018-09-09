package com.oybc.wizardoflegendguide.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.oybc.wizardoflegendguide.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private Button arcanaButton;
    private Button relicsButton;
    private Button cloakButton;
    private Context mContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews(){
        arcanaButton = findViewById(R.id.arcana_button);
        relicsButton = findViewById(R.id.relics_button);
        cloakButton = findViewById(R.id.cloak_button);
        arcanaButton.setOnClickListener(this);
        relicsButton.setOnClickListener(this);
        cloakButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.arcana_button:
                Intent intent = new Intent(mContext,ArcanaShowActivityTest.class);
                startActivity(intent);
                break;
            case R.id.relics_button:
                break;
            case R.id.cloak_button:
                break;
        }
    }
}
