package com.example.ithome

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val itList = ArrayList<HomePage>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//去掉标题

        fullScreen(this)
        window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        initItDemo()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = ItAdapter(itList)

        recyclerView.adapter = adapter



    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private fun fullScreen(activity: Activity) {
        run {

            //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            val window = activity.window
            val decorView = window.decorView
            //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.systemUiVisibility = option
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun initItDemo(){
        repeat(2){
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
            itList.add(HomePage(R.drawable.phone,"华为 Mate 40 Pro 缺货被疯抢，销售商称华为已投 200 亿美元做芯片","180评价"))
        }
    }
}