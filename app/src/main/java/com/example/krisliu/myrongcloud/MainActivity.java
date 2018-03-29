package com.example.krisliu.myrongcloud;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;
/**
*
*   @data 创建时间: 2018/1/23
*
*   @author 创建人: kris_liutao@163.com
*
*   @description  功能描述:
*
*/
public class MainActivity extends Activity implements View.OnClickListener, RongIM.UserInfoProvider{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //kris  这个token为融云调试token   真正项目中一般会在登录接口中给你返回token 替换即可
        String token = "/J0eHW43mJdYDJg+0gKKZPRTe2GHWU4uO8Hvo+MUDHW6IduhjEa5yInXxsWDUOk5GH9WTfGOBnqoqulyj8HViQ==";

        RongIM.connect(token, new RongIMClient.ConnectCallback() {

            @Override
            public void onSuccess(String userId) {
                Log.e("MainActivity", "——onSuccess—-" + userId);

                Toast.makeText(MainActivity.this,"用户id"+userId,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("MainActivity", "——onError—-" + errorCode);
            }

            @Override
            public void onTokenIncorrect() {
                //Connect Token 失效的状态处理，需要重新获取 Token
            }
        });


        /**
         * 启动单聊
         * context - 应用上下文。
         * targetUserId - 要与之聊天的用户 Id。
         * title - 聊天的标题，如果传入空值，则默认显示与之聊天的用户名称。
         */
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(MainActivity.this, "1234", "");
        }


        /**

         * 启动群组聊天界面。
         *
         * @param context       应用上下文。
         * @param targetGroupId 要聊天的群组 Id。
         * @param title         聊天的标题。开发者需要在聊天界面通过intent.getData().getQueryParameter("title")获取该值, 再手动设置为聊天界面的标题。
         */

//        if ( RongIM.getInstance()!=null) {
//            //发起群聊天
//            RongIM.getInstance().startGroupChat(mActivity, groupID, groupName);
//        }else{
//            Tip.tipshort(mActivity,"群聊内容为空");
//        }

    }

    @Override
    public void onClick(View view) {

    }

    @Override//获取用户头像，姓名等信息
    public UserInfo getUserInfo(String s) {
        return null;
    }


//    @Override
//    public UserInfo getUserInfo(String s) {
//        for (Friend i : userIdList) {
//            if (i.getUserId().equals(s)) {
//                Log.e(TAG, i.getPortraitUri());
//                return new UserInfo(i.getUserId(), i.getName(), Uri.parse(i.getPortraitUri()));
//            }
//        }
//
//
//        Log.e("MainActivity", "UserId is : " + s);
//        return null;
//    }
}
