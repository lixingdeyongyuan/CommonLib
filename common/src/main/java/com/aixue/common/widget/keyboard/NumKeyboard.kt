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

        const val KEY_GO_BACK = "回退"
        const val KEY_HIDE = "隐藏"
        const val KEY_CLEAR = "清空"
        //        const val KEY_COPY = "ABC"
//        const val KEY_PASTE = "系统键盘"
        const val KEY_COPY = "复制"
        const val KEY_PASTE = "粘贴"
        const val KEY_CONFIRM = "确定"
    }

    private var mPrefixCodeAdapter: MultiTypeAdapter
    private var mNumAdapter: MultiTypeAdapter
    private var mInterOnNumClickListener: OnNumClickListener
    private var mOnKeyInputListener: OnKeyInputListener? = null

    init {
        mInterOnNumClickListener = object : OnNumClickListener {
            override fun onClick(item: KeyBean) {
                if (item.type == 1) {
                    when (item.postion) {
                        3 -> mOnKeyInputListener?.onGoBack()
                        7 -> mOnKeyInputListener?.onHide()
                        11 -> mOnKeyInputListener?.onClear()
                        12 -> mOnKeyInputListener?.onCopy()
                        13 -> mOnKeyInputListener?.onPaste()
                        15 -> mOnKeyInputListener?.onConfirm()
                        else -> mOnKeyInputListener?.onKey(item.keyName)
                    }
                } else {
                    mOnKeyInputListener?.onKey(item.keyName)
                }
            }
        }
        View.inflate(context, R.layout.layout_num_keyboard, this)
        mPrefixCodeAdapter = MultiTypeAdapter()
        val prefixCodeList = getPrefixCodeList()

        mPrefixCodeAdapter.register(KeyBean::class.java, PrefixCodeVb(mInterOnNumClickListener))
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
        val numList = getNumList()
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
                KeyBean::class.java,
                NumVb(rvNum.height - 4 * SP_HEIGHT, mInterOnNumClickListener)
            )
            rvNum.adapter = mNumAdapter
        }

    }

    open fun getPrefixCodeList(): ArrayList<KeyBean> {
        val prefixCodeList = ArrayList<KeyBean>()
        prefixCodeList.add(KeyBean(0, "600"))
        prefixCodeList.add(KeyBean(0, "601"))
        prefixCodeList.add(KeyBean(0, "000"))
        prefixCodeList.add(KeyBean(0, "002"))
        prefixCodeList.add(KeyBean(0, "300"))
        prefixCodeList.forEachIndexed { index, bean ->
            bean.postion = index
        }
        return prefixCodeList
    }

    open fun getNumList(): ArrayList<KeyBean> {
        val numList = ArrayList<KeyBean>()
        numList.add(KeyBean(1, "1"))
        numList.add(KeyBean(1, "2"))
        numList.add(KeyBean(1, "3"))
        numList.add(KeyBean(1, KEY_GO_BACK))
        numList.add(KeyBean(1, "4"))
        numList.add(KeyBean(1, "5"))
        numList.add(KeyBean(1, "6"))
        numList.add(KeyBean(1, KEY_HIDE))
        numList.add(KeyBean(1, "7"))
        numList.add(KeyBean(1, "8"))
        numList.add(KeyBean(1, "9"))
        numList.add(KeyBean(1, KEY_CLEAR))
        numList.add(KeyBean(1, KEY_COPY))
        numList.add(KeyBean(1, KEY_PASTE))
        numList.add(KeyBean(1, "0"))
        numList.add(KeyBean(1, KEY_CONFIRM))
        numList.forEachIndexed { index, bean ->
            bean.postion = index
        }
        return numList
    }

    fun setOnKeyInputListener(onKeyInputListener: OnKeyInputListener) {
        mOnKeyInputListener = onKeyInputListener
    }
}