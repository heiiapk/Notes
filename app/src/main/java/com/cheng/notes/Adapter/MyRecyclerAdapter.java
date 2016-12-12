package com.cheng.notes.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.notes.R;

import java.util.List;

/**
 * Created by cheng on 2016/12/12.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter <MyRecyclerAdapter.MyViewHolder>{

    private List<String> mData;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyRecyclerAdapter(Context context, List<String> datas) {
        this.context=context;
        mData=datas;
        layoutInflater=layoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_main,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
             tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
