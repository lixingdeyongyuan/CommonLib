package com.aixue.common.widget.commonitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.aixue.common.R

/**
 * NOTE 直接new的话，是不会调onFinishInflate方法的，也就不会添加分割线到view上
 */
open class CommonItemBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private var mDividerHeight = 2f
    private var mDividerColor = 0

    init {
        attrs?.let {
            var typedArray: TypedArray? = null
            try {
                typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.CommonItemBar)
                mDividerHeight =
                    typedArray.getDimension(R.styleable.CommonItemBar_dividerHeight, 2f)
                mDividerColor = typedArray.getColor(
                    R.styleable.CommonItemBar_dividerColor,
                    ContextCompat.getColor(context, R.color.dividerColor)
                )
                initView(typedArray)
                typedArray.recycle()
            } catch (e: Exception) {
                typedArray?.recycle()
            }
        }
    }

    /**
     * 不放在
     * @see init
     * 这个的原因，是因为init方法中没有计算完所有子view的高度就添加了
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        var divider = View(context)
        var lp = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            Math.round(mDividerHeight)
        )
        lp.bottomToBottom = this.bottom
        divider.layoutParams = lp
        divider.setBackgroundColor(mDividerColor)
        addView(divider, lp)
    }

    open fun initView(typedArray: TypedArray?) {

    }
}