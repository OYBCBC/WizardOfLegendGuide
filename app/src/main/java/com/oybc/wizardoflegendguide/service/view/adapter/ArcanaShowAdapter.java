package com.oybc.wizardoflegendguide.service.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oybc.wizardoflegendguide.R;
import com.oybc.wizardoflegendguide.service.entitiy.Arcana;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class ArcanaShowAdapter extends BaseAdapter {

    private static final String TAG = "ArcanaShowAdapter";
    private Context mContext;

    private List<Arcana> arcanas;

    private String baseurl = "http://10.0.2.2:8080/guide_for_Wizard_of_Legend_server";

    public ArcanaShowAdapter(Context context, List<Arcana> arcanas) {
        this.mContext = context;
        this.arcanas = arcanas;
    }

    @Override
    public int getCount() {
        if (arcanas != null)
            return arcanas.size();
        else
            return 0;
    }

    @Override
    public Arcana getItem(int position) {
        return arcanas.get(position);
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
            holder.tv = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);

            //with()方法可以接收Context、Activity或者Fragment类型的参数
            //load方法中不仅可以传入图片地址，还可以传入图片文件File，resource，图片的byte数组等
//            Log.i(TAG, baseurl + getItem(position).getPic());
//            //使用glide加载图片
//            Glide.with(mContext)
//                    .load(baseurl + arcanas.get(position).getPic())
//                    .into(holder.iv);//显示的位置
//            holder.tv.setText(getItem(position).getName());

        } else {
            holder = (MyHolder) convertView.getTag();
        }
        ImageView imageView = holder.iv;
        TextView textView = holder.tv;
        final String imageViewTag = (String) imageView.getTag(R.id.imageloader_uri);
        final String textViewTag = (String) textView.getTag(R.id.textloader_uri);
        final String ivUri = baseurl + ((Arcana)getItem(position)).getPic();
        final String tvUri = ((Arcana)getItem(position)).getName();
        if (!ivUri.equals(imageViewTag)) {
//            imageView.setImageDrawable((R.drawable.ic_launcher_foreground));
        }


        imageView.setTag(R.id.imageloader_uri,ivUri);
        textView.setTag(R.id.textloader_uri,tvUri);
        Glide.with(mContext).load(ivUri).into(imageView);
        textView.setText(tvUri);
        return convertView;
    }

    private class MyHolder {
        ImageView iv;
        TextView tv;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Log.i(TAG,"ArcanaShowAdapter.notifyDataSetChanged()");
    }

    public void setData(List<Arcana> arcanas){
        this.arcanas = arcanas;
    }

}
