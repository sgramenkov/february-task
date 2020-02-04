package com.example.bottomsheet.ui.home

import android.content.Context
import android.graphics.Typeface
import android.view.View

interface IHome {
    fun initViews(root:View)
    fun initFonts(context: Context,homePresenter: IHomePresenter)
}