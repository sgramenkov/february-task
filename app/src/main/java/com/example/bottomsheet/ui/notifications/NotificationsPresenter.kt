package com.example.bottomsheet.ui.notifications

import android.content.Context
import android.graphics.Typeface
import android.widget.CompoundButton

class NotificationsPresenter(
    val context: Context,
    val notificationsFragment: NotificationsFragment
) : INotificationsPresenter {
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
        notificationsFragment.rateTV.setTypeface(face)
        notificationsFragment.msgTV.setTypeface(face)
        notificationsFragment.moreInfoTV.setTypeface(face)
        notificationsFragment.nameTV.setTypeface(abhayya)
        notificationsFragment.emailTV.setTypeface(abhayya)
        notificationsFragment.ageCountTV.setTypeface(abhayya)
        notificationsFragment.ageTV.setTypeface(abhayya)
        notificationsFragment.textView.setTypeface(face)
    }

    override fun bindData() {
        notificationsFragment.msgTV.text = "Написать\nсообщение"
        notificationsFragment.rateTV.text = "Оценить\nприложение"
        notificationsFragment.moreInfoTV.text = "Подробнее о\nприложении"
        notificationsFragment.nameTV.text = "Рикардо"
        notificationsFragment.emailTV.text = "ricardomilos@flex.ru"
        notificationsFragment.ageCountTV.text = "37"
        notificationsFragment.ageTV.text = "лет"
        notificationsFragment.textView.text = "Настройки"
    }

    override fun setListeners() {
        notificationsFragment.manCheck.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    notificationsFragment.womanCheck.isChecked = false
                }
            }
        })
        notificationsFragment.womanCheck.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    notificationsFragment.manCheck.isChecked = false
                }
            }
        })
    }
}