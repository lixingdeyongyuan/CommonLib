package com.aixue.common.widget

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewDelegate

abstract class BaseItemViewBinder<T, VH : RecyclerView.ViewHolder> : ItemViewDelegate<T, VH>() {

    abstract fun createVHLayoutId(): Int

    override fun onCreateViewHolder(context: Context, parent: ViewGroup): VH {
        // 这个类的作用就是为了抽离出这句代码，让逻辑更简单清晰
        val view = View.inflate(context, createVHLayoutId(), null)
        return onCreateViewHolder(view)
    }

    abstract fun onCreateViewHolder(view: View): VH
}