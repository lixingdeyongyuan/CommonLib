package com.aixue.common.widget.keyboard.vb

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.BaseItemViewBinder
import com.aixue.common.widget.keyboard.KeyBean
import com.aixue.common.widget.keyboard.OnNumClickListener
import kotlinx.android.synthetic.main.item_num.view.*

class NumVb(var mHeight: Int, var mOnNumClickListener: OnNumClickListener) :
    BaseItemViewBinder<KeyBean, NumVb.ViewHolder>() {
    override fun createVHLayoutId(): Int {
        return R.layout.item_num
    }

    override fun onCreateViewHolder(view: View): ViewHolder {
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mHeight / 4)
        return ViewHolder(view, mOnNumClickListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, item: KeyBean) {
        holder.bind(item)
    }


    class ViewHolder(view: View, var mOnNumClickListener: OnNumClickListener) :
        RecyclerView.ViewHolder(view) {

        fun bind(item: KeyBean) {
            itemView.tvNum.text = item.keyName
            itemView.setOnClickListener {
                mOnNumClickListener.onClick(item)
            }
        }
    }
}