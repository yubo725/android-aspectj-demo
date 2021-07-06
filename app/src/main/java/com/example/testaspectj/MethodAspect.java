package com.example.testaspectj;

import android.util.Log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodAspect {

    private static final String TAG = "MethodAspect";

    @Pointcut("execution(* com.example.testaspectj.MainActivity.onCreate(..))")
    public void joinPoint() {}

    @Before("joinPoint()")
    public void beforeOnCreate() {
        Log.e(TAG, "this message is printed before onCreate...");
    }

    // 上面两个方法也可以合并写为下面一个方法
//    @Before("execution(* com.example.testaspectj.MainActivity.onCreate(..))")
//    public void beforeOnCreate(JoinPoint joinPoint) {
//        Log.e(TAG, "this message is printed before onCreate...");
//    }

}
