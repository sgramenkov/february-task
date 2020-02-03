package com.example.bottomsheet.ui.home

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomsheet.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val progressBar: ProgressBar = root.findViewById(R.id.progress_horizontal)
        val secondProgressTV: TextView = root.findViewById(R.id.second_progress_values_tv)
        val secondProgressBar: ProgressBar = root.findViewById(R.id.second_progress_horizontal)
        val face = Typeface.createFromAsset(
            activity!!.assets,
            "fonts/Gilroy-Black.ttf"
        )
        val progressTV: TextView = root.findViewById(R.id.progress_values_tv)

        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                for (i in 0..progressBar.max) {
                    delay(50)
                    progressTV.typeface = face
                    progressTV.text = i.toString() + "%"
                    progressBar.progress = i
                    secondProgressTV.typeface = face
                    secondProgressTV.text = i.toString() + "%"
                    secondProgressBar.progress = i

                }
            }


        }



        textView.typeface = face
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}