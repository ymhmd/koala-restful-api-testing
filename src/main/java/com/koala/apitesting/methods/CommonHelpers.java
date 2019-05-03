package com.koala.apitesting.methods;

import java.sql.Timestamp;

public class CommonHelpers {

    public static Object getTimestampMS() {
        return (new Timestamp(System.currentTimeMillis()).getTime());
    }

    public static String getExecutionId() {
        return "execution@" + getTimestampMS();
    }
}
