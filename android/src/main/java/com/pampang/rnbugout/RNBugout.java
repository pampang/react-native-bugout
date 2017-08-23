package com.pampang.rnbugout;

import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import com.facebook.react.bridge.ReactMethod;
import com.testin.agent.Bugout;
import com.testin.agent.BugoutConfig;


/**
* Created by PAMPANG on 2016/11/24.
*/

public class RNBugout extends ReactContextBaseJavaModule {

    // 构造方法
    public RNBugout(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    // 覆写getName方法，它返回一个字符串名字，在JS中我们就使用这个名字调用这个模块
    @Override
    public String getName() {
        return "RNBugout";
    }

    public static void init(Context applicationContext, String appKey, String channel) {
        BugoutConfig config = new BugoutConfig
                .Builder(applicationContext)
                .withAppKey(appKey)     // 您的应用的项目ID,如果已经在 Manifest 中配置则此处可略
                .withAppChannel(channel)     // 发布应用的渠道,如果已经在 Manifest 中配置则此处可略
//                .withUserInfo(userinfo)    // 用户信息-崩溃分析根据用户记录崩溃信息
                .withDebugModel(true)    // 输出更多SDK的debug信息
                .withErrorActivity(true)    // 发生崩溃时采集Activity信息
                .withCollectNDKCrash(true) //  收集NDK崩溃信息
                .withOpenCrash(true)    // 收集崩溃信息开关
                .withOpenEx(true)     // 是否收集异常信息
                .withReportOnlyWifi(false)    // 仅在 WiFi 下上报崩溃信息
                .withReportOnBack(true)    // 当APP在后台运行时,是否采集信息
                .withQAMaster(true)    // 是否收集摇一摇反馈
                .withCloseOption(false)   // 是否在摇一摇菜单展示‘关闭摇一摇选项’
//                .withLogcat(true)  // 是否系统操作信息
                .build();
        Bugout.init(config);
    }

    @ReactMethod
    public void initBugout(String appKey, String channel) {
        init(getReactApplicationContext(), appKey, channel);
    }

    @ReactMethod
    public void setShakeStatus(Boolean status) {
        Bugout.setShakeStatus(getReactApplicationContext(), status);
    }

    @ReactMethod
    public void getShakeStatus() {
        // promise 返回数据
    }
}