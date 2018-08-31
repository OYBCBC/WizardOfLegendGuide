package com.oybc.wizardoflegendguide.service.view.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.service.entitiy.Skill;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class SkillShowAdapter extends BaseAdapter {

    private Context mContext;

    private List<Skill> skills;

    public SkillShowAdapter(Context context, List<Skill> skills) {
        this.mContext = context;
        this.skills = skills;
    }

    @Override
    public int getCount() {
        if (skills != null)
            return skills.size();
        else
            return 0;
    }

    @Override
    public Skill getItem(int position) {
        return skills.get(position);
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
            holder.iv = (TextView) convertView.findViewById(R.id.img);
            //设置显示图片
            holder.iv.setText(getItem(position).getSkillPic());
            holder.tv = (TextView)convertView.findViewById(R.id.name);
            //设置标题
            holder.tv.setText(getItem(position).getSkillName());
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
            return convertView;
        }
        return convertView;
    }

    private class MyHolder {
        TextView iv;
        TextView tv;
    }
}
