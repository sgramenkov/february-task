package com.example.bottomsheet.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.Adapter
import com.example.bottomsheet.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DashboardFragment : Fragment(), IDashboard {
    lateinit var sheetArrow: ImageView
    lateinit var recycler: RecyclerView
    lateinit var textView: TextView
    lateinit var selfDefenseBtn: Button
    lateinit var grammarBtn: Button
    lateinit var selfDefenseTV: TextView
    lateinit var grammarTV: TextView
    lateinit var bottomSheet:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        initViews(root)

        val dashboardPresenter:IDashboardPresenter=DashboardPresenter(context!!,this)

        initFonts(context!!,dashboardPresenter)

        dashboardPresenter.bindData()

        dashboardPresenter.initRecycler()

        dashboardPresenter.behaviorCallback()

        return root
    }

    override fun initViews(root: View) {
        bottomSheet = root.findViewById(R.id.bottom)
        selfDefenseTV = root.findViewById(R.id.self_defense_courses_tv)
        grammarTV = root.findViewById(R.id.grammar_courses_tv)
        sheetArrow = root.findViewById(R.id.sheet_arrow)
        textView = root.findViewById(R.id.text_dashboard)
        recycler = root.findViewById(R.id.recycler)
        selfDefenseBtn = root.findViewById(R.id.self_defense_btn)
        grammarBtn = root.findViewById(R.id.grammar_btn)
    }

    override fun initFonts(context: Context,dashboardPresenter: IDashboardPresenter) {
        dashboardPresenter.initFonts(context)
    }


}