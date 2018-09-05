package com.oybc.wizardoflegendguide.service.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.service.entitiy.Relics;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class RelicsShowAdapter extends BaseAdapter {

    private static final String TAG = "RelicsShowAdapter";
    private Context mContext;

    private List<Relics> relicss;

    private String baseurl = "http://10.0.2.2:8080/guide_for_Wizard_of_Legend_server";

    public RelicsShowAdapter(Context context, List<Relics> arcanas) {
        this.mContext = context;
        this.relicss = arcanas;
    }

    @Override
    public int getCount() {
        if (relicss != null)
            return relicss.size();
        else
            return 0;
    }

    @Override
    public Relics getItem(int position) {
        return relicss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyHolder holder;
        if (convertView == null) {
            holder = new MyHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);
            holder.iv = (ImageView) convertView.findViewById(R.id.img);
            //设置显示图片
            //holder.iv.setText(getItem(position).getSkillPic());

            //with()方法可以接收Context、Activity或者Fragment类型的参数
            //load方法中不仅可以传入图片地址，还可以传入图片文件File，resource，图片的byte数组等
            Log.i(TAG, baseurl + getItem(position).getPic());
            //使用glide加载图片
            Glide.with(mContext)
                    .load(baseurl + relicss.get(position).getPic())
                    .into(holder.iv);//显示的位置

            holder.tv = (TextView) convertView.findViewById(R.id.name);
            //设置标题
            holder.tv.setText(getItem(position).getName());
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
            return convertView;
        }
        return convertView;
    }

    private class MyHolder {
        ImageView iv;
        TextView tv;
    }
}
