package com.example.quangnguyen.mynativeapplication;

public class Wrapper {
    static {
        System.loadLibrary("native");
    }

    public native String getMessages();
    public native int [] createIntArray(int size);
    public native byte [] createByteArray(int size);
}
