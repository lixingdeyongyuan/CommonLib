package com.aixue.common.widget.keyboard.vb

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.BaseItemViewBinder
import com.aixue.common.widget.keyboard.OnKeyInputListener
import kotlinx.android.synthetic.main.item_num.view.*

class NumVb(var mHeight: Int, var onKeyInputListener: OnKeyInputListener) :
    BaseItemViewBinder<String, NumVb.ViewHolder>() {
    override fun createVHLayoutId(): Int {
        return R.layout.item_num
    }

    override fun onCreateViewHolder(view: View): ViewHolder {
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mHeight / 4)
        return ViewHolder(view, onKeyInputListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, item: String) {
        holder.bind(item)
    }


    class ViewHolder(view: View, var onKeyInputListener: OnKeyInputListener) :
        RecyclerView.ViewHolder(view) {

        fun bind(item: String) {
            itemView.tvNum.text = item
            itemView.setOnClickListener {
                onKeyInputListener.onKey(item)
            }
        }
    }
}