package com.aixue.common.widget.keyboard.vb

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.BaseItemViewBinder
import com.aixue.common.widget.keyboard.KeyBean
import com.aixue.common.widget.keyboard.OnNumClickListener
import kotlinx.android.synthetic.main.item_prefix_code.view.*

class PrefixCodeVb(var mOnNumClickListener: OnNumClickListener) : BaseItemViewBinder<KeyBean, PrefixCodeVb.ViewHolder>() {
    override fun createVHLayoutId(): Int {
        return R.layout.item_prefix_code
    }

    override fun onCreateViewHolder(view: View): ViewHolder {
        return ViewHolder(view,mOnNumClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: KeyBean) {
        holder.bind(item)
    }

    class ViewHolder(view: View,var mOnNumClickListener: OnNumClickListener) : RecyclerView.ViewHolder(view) {

        fun bind(item: KeyBean) {
            itemView.tvPrefixCode.text = item.keyName
            itemView.setOnClickListener {
                mOnNumClickListener.onClick(item)
            }
        }
    }
}