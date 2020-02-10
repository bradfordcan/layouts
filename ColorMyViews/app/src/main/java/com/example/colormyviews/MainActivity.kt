package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(text_box_one, text_box_two, text_box_three, text_box_four, text_box_five)
        for(item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.text_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.text_box_two -> view.setBackgroundColor(Color.GRAY)
            R.id.text_box_three -> view.setBackgroundColor(Color.MAGENTA)
            R.id.text_box_four -> view.setBackgroundColor(Color.LTGRAY)
            R.id.text_box_five -> view.setBackgroundColor(Color.GREEN)
            else ->  {
                view.setBackgroundColor(Color.BLUE)
            }
        }
    }

}
