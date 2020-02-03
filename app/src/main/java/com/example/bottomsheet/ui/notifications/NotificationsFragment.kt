package com.example.bottomsheet.ui.notifications

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomsheet.R

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    lateinit var ageCountTV: TextView
    lateinit var ageTV: TextView
    lateinit var rateTV: TextView
    lateinit var msgTV: TextView
    lateinit var moreInfoTV: TextView
    lateinit var nameTV: TextView
    lateinit var emailTV: TextView
    lateinit var textView: TextView
    lateinit var manCheck: ToggleButton
    lateinit var womanCheck: ToggleButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)


        initViews(root)
        manCheck.isChecked = true
        val fonts = initFonts()

        setFonts(fonts.first, fonts.second)

        setListeners()

        textData()


        return root
    }

    fun setListeners() {
        manCheck.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    womanCheck.isChecked = false
                }
            }
        })
        womanCheck.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    manCheck.isChecked = false
                }
            }
        })
    }

    fun initViews(root: View) {
        manCheck = root.findViewById(R.id.man_check)
        womanCheck = root.findViewById(R.id.woman_check)
        rateTV = root.findViewById(R.id.rate_tv)
        msgTV = root.findViewById(R.id.msg_tv)
        moreInfoTV = root.findViewById(R.id.more_info_tv)
        textView = root.findViewById(R.id.text_notifications)
        nameTV = root.findViewById(R.id.name_tv)
        emailTV = root.findViewById(R.id.email_tv)
        ageCountTV = root.findViewById(R.id.age_count_tv)
        ageTV = root.findViewById(R.id.age_tv)
    }

    fun initFonts(): Pair<Typeface, Typeface> {
        val face = Typeface.createFromAsset(
            activity!!.assets,
            "fonts/Gilroy-Black.ttf"
        )
        val abhayya = Typeface.createFromAsset(
            activity!!.assets,
            "fonts/AbhayaLibre-Regular.ttf"
        )
        return Pair(face, abhayya)
    }

    fun setFonts(face: Typeface, abhayya: Typeface) {
        rateTV.setTypeface(face)
        msgTV.setTypeface(face)
        moreInfoTV.setTypeface(face)
        nameTV.setTypeface(abhayya)
        emailTV.setTypeface(abhayya)
        ageCountTV.setTypeface(abhayya)
        ageTV.setTypeface(abhayya)
        textView.setTypeface(face)

    }

    fun textData() {
        msgTV.text = "Написать\nсообщение"
        rateTV.text = "Оценить\nприложение"
        moreInfoTV.text = "Подробнее о\nприложении"
        nameTV.text = "Рикардо"
        emailTV.text = "ricardomilos@flex.ru"
        ageCountTV.text = "37"
        ageTV.text = "лет"
        notificationsViewModel.text.observe(this, Observer {
            textView.text = it
        })
    }
}