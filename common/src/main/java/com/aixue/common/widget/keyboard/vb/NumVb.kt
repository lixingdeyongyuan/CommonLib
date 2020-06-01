package com.aixue.common.widget.keyboard.vb

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.drakeet.multitype.ItemViewDelegate
import kotlinx.android.synthetic.main.item_num.view.*

class NumVb(var mHeight: Int) : ItemViewDelegate<String, NumVb.ViewHolder>() {
    override fun onCreateViewHolder(context: Context, parent: ViewGroup): ViewHolder {
        val view = View.inflate(context, R.layout.item_num, null)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mHeight / 4)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: String) {
        holder.bind(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(item: String) {
            itemView.tvNum.text = item

        }
    }
}