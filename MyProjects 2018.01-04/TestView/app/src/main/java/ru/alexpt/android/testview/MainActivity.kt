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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mText = findViewById(R.id.textView1)
        mText.text = getString(R.string.newText)
        mButton = findViewById(R.id.button)
    }

    fun onClickButton(view: View){
        mText.text = "Мы всё поменяли кнопкой!"
        mText.setTextColor(Color.BLACK)
    }

    fun onClickText1(view: View){
        mText.text = "Мы всё поменяли!"
        mText.setTextColor(Color.RED)
    }
}
