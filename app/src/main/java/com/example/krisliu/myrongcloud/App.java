package com.example.krisliu.myrongcloud;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
*
*   @data 创建时间: 2018/1/23
*
*   @author 创建人: kris_liutao@163.com
*
*   @description  功能描述: 初始化融云
*
*/

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化融云
        RongIM.init(this);

    }
}
