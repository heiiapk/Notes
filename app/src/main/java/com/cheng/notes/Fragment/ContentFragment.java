package com.cheng.notes.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.notes.Adapter.MyRecyclerAdapter;
import com.cheng.notes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/12.
 */

public class ContentFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private List<String> mDatas;
    public static ContentFragment getInstance(String str){
        ContentFragment fragement=new ContentFragment();
        Bundle bundle=new Bundle();
        bundle.putString("key",str);
        fragement.setArguments(bundle);
        return  fragement;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragemnt_content,container,false);
        context=getActivity();
        TextView textView= (TextView) view.findViewById(R.id.tv);
        recyclerView= (RecyclerView) view.findViewById(R.id.rec_view);
        //textView.setText("i love you !!!!!!!!!!!!!");
        textView.setText(getArguments().getString("key"));

        initView();
        return view;
    }

    private void initView() {
        mDatas=new ArrayList<>();
        for (int i=0;i<40;i++)
        {
            mDatas.add("item"+i);
        }
        LinearLayoutManager manger = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyRecyclerAdapter(context,mDatas));
    }
}
