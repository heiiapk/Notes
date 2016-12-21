package com.cheng.notes.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.notes.Adapter.MyRecyclerAdapter;
import com.cheng.notes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/13.
 */

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.rec_view);
        context=getActivity();
        initData();
        return  view;

    }

    private void initData() {
        List<String> mDatas=new ArrayList<>();
        for (int i=0;i<20;i++){
            mDatas.add(i+"");
        }
        LinearLayoutManager manger = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyRecyclerAdapter(context,mDatas));
    }
}
