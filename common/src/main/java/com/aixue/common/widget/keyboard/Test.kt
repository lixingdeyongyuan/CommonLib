package com.aixue.common.widget.keyboard

import android.content.Context
import android.icu.util.Measure
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Test(context: Context?, spanCount: Int) : GridLayoutManager(context, spanCount) {

    override fun onMeasure(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        widthSpec: Int,
        heightSpec: Int
    ) {

        Log.d("rlog", "Test.onMeasure ${View.MeasureSpec.getSize(heightSpec)}")

//        for (i in 0..15) {
//
//            getChildAt(i)?.let {
//                Log.d("rlog", "Test.onMeasure2 i=${i}")
//                it.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,View.MeasureSpec.getSize(heightSpec) / 5)
//            }
//        }

        super.onMeasure(recycler, state, widthSpec, heightSpec)

    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)


    }
}