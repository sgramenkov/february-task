package com.example.bottomsheet.ui.dashboard

import android.content.Context
import android.view.ContextMenu
import android.view.View

interface IDashboard {
    fun initViews(root: View)
    fun initFonts(context: Context,dashboardPresenter: IDashboardPresenter)
}