package com.example.krisliu.myrongcloud;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
*
*   @data 创建时间: 2018/1/23
*
*   @author 创建人: kris_liutao@163.com
*
*   @description  功能描述: 会话页面 可自定义
*
*/
public class ConversationActivity extends FragmentActivity {

    private static final String TAG = ConversationActivity.class.getSimpleName();
    private TextView mName;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        mName = (TextView) findViewById(R.id.name);
        mName.setText("王大锤");
    }
}
