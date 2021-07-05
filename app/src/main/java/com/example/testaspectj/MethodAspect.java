package com.example.testaspectj;

import android.util.Log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodAspect {

    private static final String TAG = "MethodAspect";

    @Pointcut("execution(* com.example.testaspectj.MainActivity.onCreate(..))")
    public void jointPoint() {}

    @Before("jointPoint()")
    public void beforeOnCreate() {
        Log.e(TAG, "this message is printed before onCreate...");
    }

}
