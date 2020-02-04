package com.example.bottomsheet.ui.dashboard

import android.content.Context
import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.Adapter
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DashboardPresenter(val context: Context, val dashboardFragment: DashboardFragment) :
    IDashboardPresenter {
    override fun initFonts(context: Context) {
        val face = Typeface.createFromAsset(
            context!!.assets,
            "fonts/Gilroy-Black.ttf"
        )
        val abhayya = Typeface.createFromAsset(
            context!!.assets,
            "fonts/AbhayaLibre-Regular.ttf"
        )
        setFonts(face, abhayya)
    }

    override fun setFonts(face: Typeface, abhayya: Typeface) {
        dashboardFragment.selfDefenseTV.setTypeface(abhayya)
        dashboardFragment.grammarTV.setTypeface(abhayya)
        dashboardFragment.selfDefenseBtn.setTypeface(face)
        dashboardFragment.grammarBtn.setTypeface(face)
        dashboardFragment.textView.setTypeface(face)
    }

    override fun bindData() {
        dashboardFragment.textView.text = "Курсы"
    }

    override fun initRecycler() {
        val lm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = Adapter(context!!)
        dashboardFragment.recycler.layoutManager = lm
        dashboardFragment.recycler.adapter = adapter
    }

    override fun behaviorCallback() {

        val behaviour = BottomSheetBehavior.from(dashboardFragment.bottomSheet)
        behaviour.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
                if (p1 > 0) {
                    dashboardFragment.recycler.alpha = 1 - p1
                }
                dashboardFragment.sheetArrow.rotation = p1 * 180
            }

            override fun onStateChanged(p0: View, p1: Int) {
            }

        })
    }
}