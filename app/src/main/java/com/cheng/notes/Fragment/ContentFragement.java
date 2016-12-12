package com.cheng.notes.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.notes.R;

/**
 * Created by cheng on 2016/12/12.
 */

public class ContentFragement extends Fragment {


    public static ContentFragement getInstance(String str){
        ContentFragement fragement=new ContentFragement();
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
        TextView textView= (TextView) view.findViewById(R.id.tv);
        textView.setText("i love you !");
        return view;
    }
}
