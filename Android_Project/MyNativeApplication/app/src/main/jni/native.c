//
// Created by quangnguyen on 23/07/2018.
//

#include "native.h"
#include <stdio.h>
#include <stdlib.h>

JNIEXPORT jint JNICALL Java_com_example_quangnguyen_mynativeapplication_Wrapper_getMessages(JNIEnv *env,
jobject obj){
    return (*env)->NewStringUTF(env, "Nguyen Vo Dang Quang");
}

JNIEXPORT jintArray JNICALL Java_com_example_quangnguyen_mynativeapplication_Wrapper_createIntArray(
        JNIEnv *env, jobject obj, jint size){

    // create array that will be passed back to Java
    jintArray array = (jintArray)(*env)->NewIntArray(env, size);
    if(array == NULL) {
        return NULL;
    }

    // allocate and fill C based array
    int *int_ptr = malloc(size*sizeof(int));
    if(int_ptr == NULL) {
        return NULL;
    }

    for(int i=0;i<size;i++){
        *(int_ptr + i) = 4;
    }

    (*env)->SetIntArrayRegion(env,array,0,size,(int *) int_ptr);

    // free memory allocated inside C
    free(int_ptr);

    return array;
}

JNIEXPORT jbyteArray JNICALL Java_com_example_quangnguyen_mynativeapplication_Wrapper_createByteArray(
        JNIEnv *env, jobject obj, jint size){

    // create array that will be passed back to Java
    jbyteArray array = (jbyteArray)(*env)->NewByteArray(env, size);
    if(array == NULL) {
        return NULL;
    }

    // allocate and fill C based array
    char *uchar_ptr = malloc(size*sizeof(char));
    if(uchar_ptr == NULL) {
        return NULL;
    }

    for(int i=0;i<size;i++){
        *(uchar_ptr + i) = i;
    }

    (*env)->SetByteArrayRegion(env,array,0,size,(char *) uchar_ptr);

    // free memory allocated inside C
    free(uchar_ptr);

    return array;
}