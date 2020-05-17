package com.aixue.common.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.aixue.common.R
import java.lang.Exception

open class CommonItemBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {


    init {
        attrs?.let {
            var typedArray: TypedArray? = null
            try {
                typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.CommonItem)
                val dividerHeight =
                    typedArray.getDimension(R.styleable.CommonItem_dividerHeight, 2f)
                val dividerColor = typedArray.getColor(
                    R.styleable.CommonItem_dividerColor,
                    ContextCompat.getColor(context, R.color.dividerColor)
                )
                initView(typedArray)
                typedArray.recycle()
                var divider = View(context)
                var lp =
                    LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Math.round(dividerHeight))
                lp.addRule(ALIGN_PARENT_BOTTOM)
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