package ru.alexpt.android.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal lateinit var mHelloTextView: TextView
    internal lateinit var mNameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHelloTextView = findViewById(R.id.textView)
        mNameEditText = findViewById(R.id.editText)
    }

    fun onClick(view: View) {
        if (mNameEditText.text.length == 0) {       // Проверим поле ввода на пустоту
            mHelloTextView.text = "Hello!"          // Если поле ввода пустое
        } else {                                    // Если в поле имеется информация
            mHelloTextView.text = "Привет, " + mNameEditText.text + "!"
        }
    }

    fun onClickNull(view: View) {
        mNameEditText.text = null                   // Очистим поле ввода EditText
    }
}
