package com.aixue.common.widget.keyboard.vb

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.BaseItemViewBinder
import kotlinx.android.synthetic.main.item_num.view.*

class NumVb : BaseItemViewBinder<String, NumVb.ViewHolder>() {
    override fun createVHLayoutId(): Int {
        return R.layout.item_num
    }

    override fun onCreateViewHolder(view: View): ViewHolder {
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: String) {
        holder.bind(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(item: String){
            itemView.tvNum.text = item

        }
    }
}