package com.aixue.common.widget.commonitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.aixue.common.R

open class CommonItemBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        attrs?.let {
            var typedArray: TypedArray? = null
            try {
                typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.CommonItemBar)
                val dividerHeight =
                    typedArray.getDimension(R.styleable.CommonItemBar_dividerHeight, 2f)
                val dividerColor = typedArray.getColor(
                    R.styleable.CommonItemBar_dividerColor,
                    ContextCompat.getColor(context, android.R.color.holo_green_dark)
                )
                initView(typedArray)
                typedArray.recycle()
                var divider = View(context)
                var lp = LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    Math.round(dividerHeight)
                )
                lp.bottomToBottom = this.bottom
                divider.layoutParams = lp
                divider.setBackgroundColor(dividerColor)
                addView(divider, lp)
            } catch (e: Exception) {
                typedArray?.recycle()
            }
        }
    }

    open fun initView(typedArray: TypedArray?) {

    }
}