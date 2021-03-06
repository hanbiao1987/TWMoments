package com.han.moments.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.han.moments.R;
import com.han.moments.adpter.viewholder.ImageItemViewHolder;
import com.han.moments.entity.ImagesDTO;
import com.han.moments.imageloader.ImageLoader;

import java.util.List;

/**
 * Created by Han on 2016/11/23.
 */
public class GridViewAdapter extends RecyclerView.Adapter<ImageItemViewHolder> {

    private final LayoutInflater mInflater;
    private List<ImagesDTO> mImageUrllist;
    private int mItemWidth;
    private Context mContext;


    public GridViewAdapter(List<ImagesDTO> images, Context context, int itemwidth) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mImageUrllist = images;
        mItemWidth = itemwidth;
    }


    @Override
    public ImageItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.image_item, parent, false);
        return new ImageItemViewHolder(itemView, mItemWidth);
    }

    @Override
    public void onBindViewHolder(ImageItemViewHolder holder, int position) {
        String url = mImageUrllist.get(position).getUrl();
        holder.mimageitem.setTag(url);
        ImageLoader.getInstance().load(holder.mimageitem, url);
    }


    @Override
    public int getItemCount() {
        return mImageUrllist == null ? 0 : mImageUrllist.size();
    }

}
