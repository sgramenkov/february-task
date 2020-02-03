package com.example.bottomsheet.ui.dashboard

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.Adapter
import com.example.bottomsheet.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        val recycler = root.findViewById<RecyclerView>(R.id.recycler)
        val selfDefenseBtn: Button = root.findViewById(R.id.self_defense_btn)
        val grammarBtn: Button = root.findViewById(R.id.grammar_btn)
        val lm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = Adapter(context!!)
        recycler.layoutManager = lm
        recycler.adapter = adapter
        val face = Typeface.createFromAsset(
            activity!!.assets,
            "fonts/Gilroy-Black.ttf"
        )
        val abhayya = Typeface.createFromAsset(
            activity!!.assets,
            "fonts/AbhayaLibre-Regular.ttf"
        )
        val selfDefenseTV: TextView = root.findViewById(R.id.self_defense_courses_tv)
        val grammarTV: TextView = root.findViewById(R.id.grammar_courses_tv)
        selfDefenseTV.setTypeface(abhayya)
        grammarTV.setTypeface(abhayya)
        selfDefenseBtn.setTypeface(face)
        grammarBtn.setTypeface(face)
        textView.setTypeface(face)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        val bottomSheet: View = root.findViewById(R.id.bottom)
        val behaviour = BottomSheetBehavior.from(bottomSheet)
        behaviour.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
                if (p1 > 0) {
                    recycler.alpha=1-p1
                }
            }

            override fun onStateChanged(p0: View, p1: Int) {
            }

        })
        return root
    }
}