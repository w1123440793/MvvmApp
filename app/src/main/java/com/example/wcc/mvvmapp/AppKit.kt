package com.example.wcc.mvvmapp

import android.content.Context

/**
 *@author wnagcc
 *@date 2020/3/1
 *@describe
 **/
class AppKit{
    companion object{
        private lateinit var mContext: Context;

        fun setContext(context: Context){
            mContext = context
        }

        fun getContext():Context{
            return mContext
        }
    }
}