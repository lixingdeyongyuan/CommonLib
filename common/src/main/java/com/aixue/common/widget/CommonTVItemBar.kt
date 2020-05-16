package com.aixue.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.aixue.common.R
import kotlinx.android.synthetic.main.layout_common_tv_item.view.*

class CommonTVItemBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {

    init {
        attrs?.let {
            var typeArray = context!!.obtainStyledAttributes(it,
                R.styleable.CommonItem
            )
            var leftText = typeArray.getText(R.styleable.CommonItem_leftText)
            var rightText = typeArray.getText(R.styleable.CommonItem_rightText)
            View.inflate(context!!, R.layout.layout_common_tv_item, this)
            tvLeft.text = leftText
            tvRight.text = rightText
        }
    }

    fun setLeftText(text: String) {
        tvLeft.text = text
    }

    fun setRightText(text: String) {
        tvRight.text = text
    }

    fun getRightText(): CharSequence {
        //NOTE 这个text不可能为空。因为源码就表达了不为空
        return tvRight.text
    }

}