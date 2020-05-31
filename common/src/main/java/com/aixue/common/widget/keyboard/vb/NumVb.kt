package com.aixue.common.widget.keyboard.vb

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.BaseItemViewBinder
import kotlinx.android.synthetic.main.item_num.view.*

class NumVb(var recyclerView: RecyclerView) : BaseItemViewBinder<String, NumVb.ViewHolder>() {

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.d("rlog","NumVb.onViewAttachedToWindow ${(holder.itemView.parent as View).layoutParams.height/5}")
//        holder.itemView.layoutParams.height= (holder.itemView.parent as View).layoutParams.height/5
    }
    override fun createVHLayoutId(): Int {
        return R.layout.item_num
    }

    override fun onCreateViewHolder(view: View): ViewHolder {
//        Log.d("rlog","NumVb.onCreateViewHolder ${(view.parent as View).layoutParams.height/5}")
//        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,recyclerView.layoutParams.height/5)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: String) {
//        holder.itemView.layoutParams.height =recyclerView.layoutParams.height/5)
        Log.d("rlog","NumVb.onBindViewHolder ${(recyclerView as View).layoutParams.height/5}")

        holder.bind(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(item: String) {
            itemView.tvNum.text = item

        }
    }
}