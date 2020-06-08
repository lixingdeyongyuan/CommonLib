package com.aixue.commonlib

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aixue.common.widget.keyboard.OnKeyInputListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        haha.setOnClickListener {
            Log.d("rlog","haga")
        }
        nkb.setOnKeyInputListener(object :OnKeyInputListener{
            override fun onGoBack() {
                Log.d("rlog","onGoBack")
            }

            override fun onHide() {
                Log.d("rlog","onHide")
            }

            override fun onClear() {
                Log.d("rlog","onClear")
            }

            override fun onConfirm() {
                Log.d("rlog","onConfirm")
            }

            override fun onKey(key: String) {
                Log.d("rlog","key =$key")
            }
        })
    }
}
