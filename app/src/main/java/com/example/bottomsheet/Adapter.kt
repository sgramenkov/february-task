package com.example.bottomsheet

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class Adapter(val context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.item_tv)
        val completeTaskTV:TextView=itemView.findViewById(R.id.complete_task_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv.setTypeface(
            Typeface.createFromAsset(
                context.assets,
                "fonts/Gilroy-Black.ttf"
            )
        )
        holder.completeTaskTV.setTypeface(Typeface.createFromAsset(
            context.assets,
            "fonts/Gilroy-Black.ttf"
        ))
        holder.completeTaskTV.text= Random.nextInt(5).toString() + " из 5"
        holder.tv.text = "Курсы\nфлекса"
    }
}