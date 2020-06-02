package com.aixue.common.widget.keyboard

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aixue.common.R
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

    companion object {
        const val SP_HEIGHT = 2

        const val KEY_BACK = "回退"
        const val KEY_HIDE = "隐藏"
        const val KEY_CLEAR = "清空"
        const val KEY_SYS_KEYBOARD = "系统键盘"
        const val KEY_CONFIRM = "确定"
    }

    private lateinit var mPrefixCodeAdapter: MultiTypeAdapter
    private lateinit var mNumAdapter: MultiTypeAdapter
    private lateinit var mInterOnKeyInputListener: OnKeyInputListener
    private var mOnKeyInputListener: OnKeyInputListener? = null

    init {
        mInterOnKeyInputListener = object : OnKeyInputListener {
            override fun onKey(key: String) {
                mOnKeyInputListener?.let {
                    it.onKey(key)
                }
            }
        }
        View.inflate(context, R.layout.layout_num_keyboard, this)
        mPrefixCodeAdapter = MultiTypeAdapter()
        val prefixCodeList = ArrayList<String>()
        prefixCodeList.add("600")
        prefixCodeList.add("601")
        prefixCodeList.add("000")
        prefixCodeList.add("002")
        prefixCodeList.add("300")

        mPrefixCodeAdapter.register(String::class.java, PrefixCodeVb(mInterOnKeyInputListener))
        rvPrefixCode.addItemDecoration(
            object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.top = SP_HEIGHT
                }
            }
        )
        rvPrefixCode.layoutManager = LinearLayoutManager(context)
        rvPrefixCode.adapter = mPrefixCodeAdapter
        mPrefixCodeAdapter.items = prefixCodeList


        mNumAdapter = MultiTypeAdapter()
        val numList = ArrayList<String>()
        numList.add("1")
        numList.add("2")
        numList.add("3")
        numList.add(KEY_BACK)
        numList.add("4")
        numList.add("5")
        numList.add("6")
        numList.add(KEY_HIDE)
        numList.add("7")
        numList.add("8")
        numList.add("9")
        numList.add(KEY_CLEAR)
        numList.add("ABC")
        numList.add(KEY_SYS_KEYBOARD)
        numList.add("0")
        numList.add(KEY_CONFIRM)
        mNumAdapter.items = numList

        rvNum.layoutManager = GridLayoutManager(context, 4)
        rvNum.post {
            rvNum.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    val position = parent.getChildAdapterPosition(view)
                    if (position % 4 == 0) {
                        outRect.left = SP_HEIGHT
                        outRect.right = SP_HEIGHT
                    } else if (position % 4 == 1 || position % 4 == 2) {
                        outRect.right = SP_HEIGHT
                    }
                    outRect.top = SP_HEIGHT
                }
            })
            mNumAdapter.register(
                String::class.java,
                NumVb(rvNum.height - 4 * SP_HEIGHT, mInterOnKeyInputListener)
            )
            rvNum.adapter = mNumAdapter
        }

    }

    fun setOnKeyInputListener(onKeyInputListener: OnKeyInputListener){
        mOnKeyInputListener = onKeyInputListener
    }
}