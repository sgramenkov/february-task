package com.example.bottomsheet.ui.notifications

import android.content.Context
import android.graphics.Typeface

interface INotificationsPresenter {
    fun initFonts(context: Context)
    fun setFonts(face: Typeface, abhayya: Typeface)
    fun bindData()
    fun setListeners()
}