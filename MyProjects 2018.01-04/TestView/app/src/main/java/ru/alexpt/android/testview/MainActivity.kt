package ru.alexpt.android.testview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal lateinit var mText: TextView
    internal lateinit var mButton: Button
    internal lateinit var mButton1: Button
    internal lateinit var mButton2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mText = findViewById(R.id.textView1)
        mText.text = getString(R.string.newText)
        mButton = findViewById(R.id.button)
        mButton1 = findViewById(R.id.button1)
        mButton2 = findViewById(R.id.button2)
    }

    fun onClickButton(view: View){
        mText.text = getString(R.string.str_txt_onclick_button)
        mText.setTextColor(Color.BLACK)
        mButton.setTextColor(Color.MAGENTA)
    }

    fun onClickText1(view: View){
        mText.text = getString(R.string.str_txt_onclick_textview)
        mText.setTextColor(Color.RED)
    }

    fun onClickColor(view: View){
        mButton1.setOnClickListener { mText.setTextColor(Color.YELLOW); mButton.setTextColor(Color.WHITE) }
        mButton2.setOnClickListener { mText.setTextColor(Color.BLUE); mButton.setTextColor(Color.CYAN) }
    }
}
