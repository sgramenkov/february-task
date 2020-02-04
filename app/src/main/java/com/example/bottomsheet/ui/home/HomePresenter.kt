package com.example.bottomsheet.ui.home

import android.content.Context
import android.graphics.Typeface
import android.widget.ProgressBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomePresenter(val iHome: IHome,val homeFragment: HomeFragment) : IHomePresenter {
    override fun initFonts(context: Context) {
        val face = Typeface.createFromAsset(
            context.assets,
            "fonts/Gilroy-Black.ttf"
        )
        setFonts(face)
    }

    override fun setFonts(face: Typeface) {
        homeFragment.textView.setTypeface(face)
        homeFragment.secondProgressTV.setTypeface(face)
        homeFragment.progressTV.setTypeface(face)
    }

    override fun bindData() {
        homeFragment.textView.text = "Главная"
    }

    override fun progressThread(progressBar: ProgressBar) {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                for (i in 0..progressBar.max) {
                    delay(50)
                    homeFragment.progressTV.text = i.toString() + "%"
                    progressBar.progress = i
                    homeFragment.secondProgressTV.text = i.toString() + "%"
                    homeFragment.secondProgressBar.progress = i

                }
            }


        }
    }
}