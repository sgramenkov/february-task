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

class NotificationsFragment : Fragment(),INotifications {

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

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)


        initViews(root)

        val notificationsPresenter:INotificationsPresenter=NotificationsPresenter(context!!,this)

        notificationsPresenter.initFonts(context!!)

        notificationsPresenter.bindData()

        notificationsPresenter.setListeners()

        manCheck.isChecked = true




        return root
    }


    override fun initViews(root: View) {
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
}