package com.aixue.common.widget.keyboard.vb

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.BaseItemViewBinder
import com.aixue.common.widget.keyboard.OnKeyInputListener
import kotlinx.android.synthetic.main.item_prefix_code.view.*

class PrefixCodeVb(var onKeyInputListener: OnKeyInputListener) : BaseItemViewBinder<String, PrefixCodeVb.ViewHolder>() {
    override fun createVHLayoutId(): Int {
        return R.layout.item_prefix_code
    }

    override fun onCreateViewHolder(view: View): ViewHolder {
        return ViewHolder(view,onKeyInputListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: String) {
        holder.bind(item)
    }

    class ViewHolder(view: View,var onKeyInputListener: OnKeyInputListener) : RecyclerView.ViewHolder(view) {

        fun bind(item: String) {
            itemView.tvPrefixCode.text = item
            itemView.setOnClickListener {
                onKeyInputListener.onKey(item)
            }
        }
    }
}