package com.aixue.common.widget.commonitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.aixue.common.R
import kotlinx.android.synthetic.main.layout_common_et_item.view.*
import kotlinx.android.synthetic.main.layout_common_et_item.view.tvLeft

class CommonETItemBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    CommonItemBar(context, attrs, defStyleAttr) {


    override fun initView(typedArray: TypedArray?) {
        super.initView(typedArray)
        typedArray?.let {
            var leftText = it.getText(R.styleable.CommonItemBar_leftText)
            var leftTextSize =
                typedArray.getDimensionPixelSize(R.styleable.CommonItemBar_leftTextSize, 15)
            var rightText = it.getText(R.styleable.CommonItemBar_rightText)
            var rightHintText = it.getText(R.styleable.CommonItemBar_rightHintText)
            var rightTextSize =
                typedArray.getDimensionPixelSize(R.styleable.CommonItemBar_rightTextSize, 15)
            View.inflate(context, R.layout.layout_common_et_item, this)
            tvLeft.text = leftText
            tvLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, leftTextSize.toFloat())
            etRight.setText(rightText)
            etRight.setHint(rightHintText)
            etRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, rightTextSize.toFloat())
        }
    }


    fun setLeftText(text: String) {
        tvLeft.text = text
    }

    fun setRightText(text: String) {
        etRight.setText(text)
    }

    fun getRightText(): CharSequence {
        //NOTE 这个text不可能为空。因为源码就表达了不为空
        return etRight.text
    }

}