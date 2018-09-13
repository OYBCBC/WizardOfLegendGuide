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
import com.oybc.wizardoflegendguide.app.Const;
import com.oybc.wizardoflegendguide.service.entitiy.Cloak;
import com.oybc.wizardoflegendguide.service.entitiy.Cloak;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class CloakShowAdapter extends BaseAdapter {

    private static final String TAG = "CloakShowAdapter";
    private Context mContext;

    private List<Cloak> cloaks;

    public CloakShowAdapter(Context context, List<Cloak> cloaks
    ) {
        this.mContext = context;
        this.cloaks = cloaks;
    }

    @Override
    public int getCount() {
        if (cloaks != null)
            return cloaks.size();
        else
            return 0;
    }

    @Override
    public Cloak getItem(int position) {
        return cloaks.get(position);
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
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        ImageView imageView = holder.iv;
        TextView textView = holder.tv;
        final String imageViewTag = (String) imageView.getTag(R.id.imageloader_uri);
        final String textViewTag = (String) textView.getTag(R.id.textloader_uri);
        final String ivUri = Const.BASE_IMG_URL + ((Cloak)getItem(position)).getPic();
        final String tvUri = ((Cloak)getItem(position)).getName();
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
        Log.i(TAG,"CloakShowAdapter.notifyDataSetChanged()");
    }

    public void setData(List<Cloak> cloaks){
        this.cloaks = cloaks;
    }

}
