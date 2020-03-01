package com.example.wcc.mvvmapp.weiget

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import com.example.wcc.mvvmapp.util.StatusBarUtils
import java.lang.IllegalArgumentException

/**
 *@author wnagcc
 *@date 2020/3/1
 *@describe
 **/
class TitleStatusBarView: FrameLayout {

    private var statusBarHeight = 0
    constructor(context: Context) : this(context,null)

    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)

    constructor(context: Context,attrs: AttributeSet?,defStyleAttr:Int):super(context,attrs,defStyleAttr)

    fun init(){
       if (isTranslucentStatus()){
           statusBarHeight = StatusBarUtils.getStatusHeight()
       }
    }

    fun isTranslucentStatus():Boolean{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            if (context is Activity){
                return (context as Activity).window.attributes.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS!=0
            }
        }
        return false
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightSize  = MeasureSpec.getSize(heightMeasureSpec)
        var height = 0
        if (isTranslucentStatus()){
            setPadding(0,statusBarHeight,0,0)
            height = heightSize + statusBarHeight
        }
        var  count = childCount
        if (childCount!=1){
            throw IllegalArgumentException("child view must 1")
        }
        measureChildWithMargins(getChildAt(0),widthMeasureSpec,0,heightMeasureSpec,0)
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),height)
    }
}