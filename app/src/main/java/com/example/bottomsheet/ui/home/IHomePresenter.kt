package com.example.bottomsheet.ui.home

import android.content.Context
import android.graphics.Typeface
import android.widget.ProgressBar

interface IHomePresenter {
    fun initFonts(context: Context)
    fun setFonts(face: Typeface)
    fun bindData()
    fun progressThread(progressBar: ProgressBar)
}