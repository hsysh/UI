package com.example.hw.uiautomator.test;

import android.app.Instrumentation;
import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 功能:萌煮辅食测试
 *
 * @author: Hoo
 * Time: 11/8 17:04
 * Email：907486688@qq.com
 */
@RunWith(AndroidJUnit4.class)
public class mzfs {
    private UiDevice device;
    public Context context;
    public int width;
    public int height;
    public Instrumentation instrumentation;
    public String pkgsys = "com.nanu.cook";

    @Before
    public void setUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
        context = instrumentation.getContext();
    }

    @Test
    public void mzfs() {
       // TestData.gwidget.get("text-bonus-amount")
        width = device.getDisplayWidth();
        height = device.getDisplayHeight();
        TestUtil testUtil = new TestUtil(device, context, instrumentation, pkgsys);
        testUtil.startTest();
        testUtil.printLog("完成APP启动");
        testUtil.allowAuthority();
        //滑动屏幕进入APP内部
        int i = 0;
        while (!testUtil.hasObjectByID("com.nanu.cook:id/rightBtn")) {
            device.swipe(width * 7 / 8, height / 2, width / 8, height / 2, 20);
            testUtil.printLog("滑动欢迎页");
            device.click(width/2,height/2);
            SystemClock.sleep(2000);
            i++;
            if (i > 5) {
                break;
            }
        }
        if (testUtil.hasObjectByID("com.nanu.cook:id/rightBtn")) {
            testUtil.performClickByResID("com.nanu.cook:id/rightBtn");
            SystemClock.sleep(3000);
        }
        if (testUtil.hasObjectByText("首页")) {
            testUtil.performClickByText("首页");
            SystemClock.sleep(2000);
        }
        if (testUtil.hasObjectByText("分类")) {
            testUtil.performClickByText("分类");
            SystemClock.sleep(2000);
        }
        if (testUtil.hasObjectByText("消息")) {
            testUtil.performClickByText("消息");
            SystemClock.sleep(2000);
        }
        if (testUtil.hasObjectByText("我的")) {
            testUtil.performClickByText("我的");
            SystemClock.sleep(2000);
        }
        if (testUtil.hasObjectByText("首页")) {
            testUtil.performClickByText("首页");
            SystemClock.sleep(2000);
        }
        if (testUtil.hasObjectByText("早餐")) {
            testUtil.performClickByText("早餐");
        }
    }
}
