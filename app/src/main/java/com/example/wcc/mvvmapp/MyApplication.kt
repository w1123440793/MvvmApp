package com.example.wcc.mvvmapp

import android.app.Application

/**
 *@author wnagcc
 *@date 2020/3/1
 *@describe
 **/
class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        AppKit.setContext(this)
    }
}