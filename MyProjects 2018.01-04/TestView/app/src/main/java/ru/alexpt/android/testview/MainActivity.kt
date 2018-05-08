package ru.alexpt.android.testview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var mText: TextView
    internal lateinit var mButton: Button
    internal lateinit var mButton1: Button
    internal lateinit var mButton2: Button
    internal lateinit var mRbtn1: Button
    internal lateinit var mRbtn2: Button
    internal lateinit var mCheck: Button
    internal lateinit var mButton4: Button

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
        mCheck = findViewById(R.id.checkbox)
        mButton4 = findViewById(R.id.button4)

        mButton4.setOnClickListener(View.OnClickListener {
            // Пока ничего не делает, но скоро будет!
            toastMe(view = textView1)
        })
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
        mCheck.setOnClickListener {mButton1.setTextColor(Color.BLUE); mButton2.setTextColor(Color.YELLOW)}
        toastMe(view)
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }
}
