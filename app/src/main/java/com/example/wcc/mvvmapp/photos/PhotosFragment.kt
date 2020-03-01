package com.example.wcc.mvvmapp.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wcc.mvvmapp.R

/**
 *@author wnagcc
 *@date 2020/3/1
 *@describe
 **/
class PhotosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo,container,false)
    }
}