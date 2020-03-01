package com.example.wcc.mvvmapp.util

import android.util.TypedValue
import com.example.wcc.mvvmapp.AppKit
import java.lang.Exception

/**
 *@author wnagcc
 *@date 2020/3/1
 *@describe
 **/
class StatusBarUtils {
    companion object{
        const val STATUS_HEIGHT_NONE = -404
        private var statusHeight = STATUS_HEIGHT_NONE

        fun getStatusHeight():Int{
            try {
                if (statusHeight!=STATUS_HEIGHT_NONE){
                    return statusHeight
                }
                val resId = AppKit.getContext().resources.getIdentifier("status_bar_height","dimen","android")
                var height = AppKit.getContext().resources.getDimensionPixelSize(resId)
                if (height == 0){
                    height = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,25f,AppKit.getContext().resources.displayMetrics))
                }
                statusHeight = height;
            }catch (ignore:Exception){
                statusHeight = 0
            }
            return statusHeight
        }
    }
}