package com.example.bottomsheet.ui.dashboard

import android.content.Context
import android.graphics.Typeface

interface IDashboardPresenter {
    fun initFonts(context: Context)
    fun setFonts(face:Typeface,abhayya:Typeface)
    fun bindData()
    fun initRecycler()
    fun behaviorCallback()

}