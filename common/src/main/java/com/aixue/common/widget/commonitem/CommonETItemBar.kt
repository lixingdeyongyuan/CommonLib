package com.aixue.common.widget.commonitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
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
            var leftText = it.getText(R.styleable.CommonItem_leftText)
            var rightText = it.getText(R.styleable.CommonItem_rightText)
            var rightHintText = it.getText(R.styleable.CommonItem_rightHintText)
            View.inflate(context, R.layout.layout_common_et_item, this)
            tvLeft.text = leftText
            etRight.setText(rightText)
            etRight.setHint(rightHintText)
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