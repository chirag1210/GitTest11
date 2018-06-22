package com.chirag.mygittest;

import android.util.Log;

/**
 * Created by Chirag on 06/19/2018.
 */

public class MyLogger {

    static StringBuilder sb0 = new StringBuilder(); // reusable string object

    public static void logWithLink(String TAG, Object param) {
        StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
        sb0.setLength(0);
        String c = stack.getFileName().substring(0, stack.getFileName().length() - 5);
        // removes the ".java"
        sb0.append(c).append(":");
        sb0.append(stack.getMethodName()).append('(');
        if (param != null) {
            sb0.append(param);
        }
        sb0.append(") ");
        sb0.append("(").append(stack.getFileName()).append(':').append(stack.getLineNumber()).append(')');
        Log.d(TAG, sb0.toString());
    }
}
