package com.example.testaspectj;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodAspect {

    // 点击事件触发的时间间隔为600毫秒，即600毫秒内只允许一次点击
    private static final long CLICK_INTERVAL = 600L;
    // 上次点击的时间
    private static long lastClickTime = 0L;

    private static final String TAG = "MethodAspect";

    // 在MainActivity的onCreate之前插入代码
    @Pointcut("execution(* com.example.testaspectj.MainActivity.onCreate(..))")
    public void joinPoint() {
    }

    // 在MainActivity的onCreate之前插入代码，@Before中的值必须跟上面的方法对应
    @Before("joinPoint()")
    public void beforeOnCreate() {
        Log.e(TAG, "this message is printed before onCreate...");
    }

    // 上面两个方法也可以合并写为下面一个方法
//    @Before("execution(* com.example.testaspectj.MainActivity.onCreate(..))")
//    public void beforeOnCreate(JoinPoint joinPoint) {
//        Log.e(TAG, "this message is printed before onCreate...");
//    }

    // 是否允许点击事件
    private boolean isClickEnabled() {
        long curTime = System.currentTimeMillis();
        if (curTime - lastClickTime > CLICK_INTERVAL) {
            lastClickTime = curTime;
            return true;
        }
        return false;
    }

    // 该方法会匹配android.view包及所有子包下的OnClickListener接口中的onClick方法，且方法参数为android.view.View
    // 注意使用的@Around而不是@Before，且方法参数为ProceedingJoinPoint
//    @Around("execution(* android.view..OnClickListener.onClick(android.view.View))")
//    public void clickableDetect(ProceedingJoinPoint joinPoint) {
//        if (isClickEnabled()) {
//            try {
//                joinPoint.proceed();
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        }
//    }

    @Around("execution(@ClickOnce * *(..))")
    public void clickOnce(ProceedingJoinPoint joinPoint) {
        if (isClickEnabled()) {
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}
