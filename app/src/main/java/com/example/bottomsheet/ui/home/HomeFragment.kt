package com.example.bottomsheet.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bottomsheet.R


class HomeFragment : Fragment(), IHome {

    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar
    lateinit var secondProgressBar: ProgressBar
    lateinit var secondProgressTV: TextView
    lateinit var progressTV: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        initViews(root)

        val homePresenter: IHomePresenter = HomePresenter(this, this)


        initFonts(context!!, homePresenter)


        homePresenter.bindData()

        homePresenter.progressThread(progressBar)

        return root
    }

    override fun initViews(root: View) {
        textView = root.findViewById(R.id.text_home)
        progressBar = root.findViewById(R.id.progress_horizontal)
        secondProgressTV = root.findViewById(R.id.second_progress_values_tv)
        secondProgressBar = root.findViewById(R.id.second_progress_horizontal)
        progressTV = root.findViewById(R.id.progress_values_tv)

    }

    override fun initFonts(context: Context, homePresenter: IHomePresenter) {
        homePresenter.initFonts(context!!)
    }

}