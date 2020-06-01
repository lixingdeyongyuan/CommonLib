package com.aixue.common.widget.keyboard

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
import com.aixue.common.widget.decoration.ColorDividerItemDecoration
import com.aixue.common.widget.decoration.RecyclerItemDecoration
import com.aixue.common.widget.keyboard.vb.NumVb
import com.aixue.common.widget.keyboard.vb.PrefixCodeVb
import com.drakeet.multitype.MultiTypeAdapter
import kotlinx.android.synthetic.main.layout_num_keyboard.view.*

class NumKeyboard @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {


    private lateinit var mPrefixCodeAdapter: MultiTypeAdapter
    private lateinit var mNumAdapter: MultiTypeAdapter

    init {
        View.inflate(context, R.layout.layout_num_keyboard, this)
        mPrefixCodeAdapter = MultiTypeAdapter()
        val prefixCodeList = ArrayList<String>()
        prefixCodeList.add("600")
        prefixCodeList.add("601")
        prefixCodeList.add("000")
        prefixCodeList.add("002")
        prefixCodeList.add("300")

        mPrefixCodeAdapter.register(String::class.java, PrefixCodeVb())
        rvPrefixCode.addItemDecoration(RecyclerItemDecoration(context,LinearLayoutManager.VERTICAL,5,Color.parseColor("#ff000000")))
//        rvPrefixCode.addItemDecoration(ColorDividerItemDecoration())
        rvPrefixCode.layoutManager = LinearLayoutManager(context)
        rvPrefixCode.adapter = mPrefixCodeAdapter
        mPrefixCodeAdapter.items = prefixCodeList


        mNumAdapter = MultiTypeAdapter()
        val numList = ArrayList<String>()
        numList.add("1")
        numList.add("2")
        numList.add("3")
        numList.add("回退")
        numList.add("4")
        numList.add("5")
        numList.add("6")
        numList.add("隐藏")
        numList.add("7")
        numList.add("8")
        numList.add("9")
        numList.add("清空")
        numList.add("ABC")
        numList.add("系统键盘")
        numList.add("0")
        numList.add("确定")
        mNumAdapter.items = numList

        rvNum.layoutManager = GridLayoutManager(context, 4)
        rvNum.post{
            mNumAdapter.register(String::class.java, NumVb(rvNum.height))
            rvNum.adapter = mNumAdapter
        }

    }
}