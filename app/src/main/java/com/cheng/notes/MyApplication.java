package com.cheng.notes;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by cheng on 2016/12/11.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //使用hongyang的封装的okhttp库
        //https://github.com/hongyangAndroid/okhttputils
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(10000L,TimeUnit.MILLISECONDS)
                .readTimeout(10000L,TimeUnit.MILLISECONDS)
                .build();

        OkHttpUtils.initClient(okHttpClient);


    }
}
