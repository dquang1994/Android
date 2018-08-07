//
// Created by quangnguyen on 23/07/2018.
//
#include <jni.h>

#ifndef MYNATIVEAPPLICATION_NATIVE_H
#define MYNATIVEAPPLICATION_NATIVE_H

#endif //MYNATIVEAPPLICATION_NATIVE_H

JNIEXPORT jint JNICALL Java_com_example_quangnguyen_mynativeapplication_Wrapper_getMessages(JNIEnv *, jobject);
JNIEXPORT jintArray JNICALL Java_com_example_quangnguyen_mynativeapplication_Wrapper_createIntArray(JNIEnv *, jobject, jint);
JNIEXPORT jbyteArray JNICALL Java_com_example_quangnguyen_mynativeapplication_Wrapper_createByteArray(JNIEnv *, jobject, jint);