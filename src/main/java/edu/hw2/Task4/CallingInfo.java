package edu.hw2.Task4;

import java.util.Arrays;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String faultyPath = stackTrace[1].toString();
        String path = "";
        for (int i = 0; i < faultyPath.length(); i++) {
            if (faultyPath.charAt(i) == '(')
                break;
            path += faultyPath.charAt(i);
        }
        String[] arrayOfPath = path.split("\\.");
        String myMethodName = arrayOfPath[arrayOfPath.length - 1];
        String myClassName = arrayOfPath[arrayOfPath.length - 2];
        return new CallingInfo(myClassName, myMethodName);
    }

}
