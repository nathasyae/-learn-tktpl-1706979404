//
// Created by Thasya on 07/12/2020.
//

#include <jni.h>

extern "C"
JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_nathasyaeliora_myapplication_calculateTotalPrice(
        JNIEnv* pEnv,
        jobject pThis,
        jint qt) {
    jlong b = 55000;
    return qt * b;
}