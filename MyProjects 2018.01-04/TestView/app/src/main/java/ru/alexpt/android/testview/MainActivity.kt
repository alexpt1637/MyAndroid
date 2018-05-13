package ru.alexpt.android.testview

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.checked



class MainActivity : AppCompatActivity() {

    internal lateinit var mText: TextView
    internal lateinit var mButton: Button
    internal lateinit var mButton1: Button
    internal lateinit var mButton2: Button
    internal lateinit var mRbtn1: Button
    internal lateinit var mRbtn2: Button
    internal lateinit var mCheck1: CheckBox
    internal lateinit var mCheck2: CheckBox
    internal lateinit var mButton4: Button
    internal lateinit var mToast: Toast
    internal lateinit var mToastAdd: Toast
    internal lateinit var mBtn1: Button
    internal lateinit var mBtn2: Button
    internal lateinit var mIntent1: Intent
    internal lateinit var mIntent2: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mText = findViewById(R.id.textView1)
        mText.text = getString(R.string.newText)
        mButton = findViewById(R.id.button)
        mButton1 = findViewById(R.id.button1)
        mButton2 = findViewById(R.id.button2)
        mRbtn1 = findViewById(R.id.r1)
        mRbtn2 = findViewById(R.id.r2)
        mCheck1 = findViewById(R.id.check1)
        mCheck2 = findViewById(R.id.check2)
        mButton4 = findViewById(R.id.button4)
        mBtn1 = findViewById(R.id.btn1)
        mBtn2 = findViewById(R.id.btn2)

        mIntent1 = Intent(this, ActivityNew1::class.java)
        mIntent2 = Intent(this, ActivityNew2::class.java)
        mToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        mToastAdd = Toast.makeText(this, "Переход выполнен", Toast.LENGTH_SHORT)

        mButton4.setOnClickListener({
            mText.setTextColor(Color.WHITE)
            mToast.show()
        })
    }

    fun onIntent(view: View){
        when(view){
            mBtn1 -> startActivity(mIntent1)
            mBtn2 -> startActivity(mIntent2)
        }
        mToastAdd.show()
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
        mButton1.setOnClickListener {mText.setTextColor(Color.YELLOW); mButton.setTextColor(Color.WHITE)}
        mButton2.setOnClickListener {mText.setTextColor(Color.BLUE); mButton.setTextColor(Color.CYAN)}
    }

    fun onClickRbtn(view: View){
        mRbtn1.setOnClickListener {mText.text = getString(R.string.str_value1)}
        mRbtn2.setOnClickListener {mText.text = getString(R.string.str_value2)}
    }

    fun onCheck(view: View){
        mCheck1.setOnClickListener {mButton1.setTextColor(Color.BLUE); mButton2.setTextColor(Color.YELLOW)}
        mToast.show()
    }

    // В качестве параметра в обработчик нажатия onCheckboxClicked передается нажатый флажок
    // С помощью метода isChecked() можно узнать, выделен ли флажок - в этом случае метод возвращает true
    fun onCheckboxClicked(view: View){
        // Получаем флажок
        val language: CheckBox = view as CheckBox
        // Получаем, отмечен ли данный флажок
        val checked= language.isChecked()

        // Выполнить соответствующие действия
        when (view) {
            mCheck1 -> {if(checked){
                startActivity(mIntent1)}}
            mCheck2 -> {if(checked){
                startActivity(mIntent2)}}
        }
        mToastAdd.show()
    }
}
