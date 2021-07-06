package com.example.testaspectj;

public class ClickUtil {

    private static long lastClickTime = 0L;

    // 是否是快速点击
    public static boolean isFastClick() {
        long curTime = System.currentTimeMillis();
        if (curTime - lastClickTime >= 500L) {
            lastClickTime = curTime;
            return true;
        }
        return false;
    }

}
