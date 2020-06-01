package com.aixue.common.widget.keyboard

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class CustomRv @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int =0) :
    RecyclerView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        Log.d("CustomRv","CustomRv.onMeasure ${MeasureSpec.getSize(heightSpec)}")
        super.onMeasure(widthSpec, heightSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        Log.d("CustomRv","CustomRv.onLayout ")
        super.onLayout(changed, l, t, r, b)
    }

    override fun onDraw(c: Canvas?) {
        Log.d("CustomRv","CustomRv.onDraw ")
        super.onDraw(c)
    }
}