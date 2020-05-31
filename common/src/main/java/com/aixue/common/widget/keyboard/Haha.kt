package com.aixue.common.widget.keyboard

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Haha @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RecyclerView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        Log.d("rlog", "Haha.onMeasure ${View.MeasureSpec.getSize(heightSpec)},childCount=${adapter?.itemCount}")
        adapter?.let {
            for (i in 0..it.itemCount) {
            findViewHolderForAdapterPosition(i)?.let {

                Log.d("rlog", "Haha.onMeasure2 i=${i}")
                it.itemView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, View.MeasureSpec.getSize(heightSpec) / 5)
            }
        }
        }

        super.onMeasure(widthSpec, heightSpec)
    }

    override fun measureChild(
        child: View?,
        parentWidthMeasureSpec: Int,
        parentHeightMeasureSpec: Int
    ) {
        Log.d("rlog", "Haha.measureChild ${View.MeasureSpec.getSize(parentHeightMeasureSpec)}")
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }
}