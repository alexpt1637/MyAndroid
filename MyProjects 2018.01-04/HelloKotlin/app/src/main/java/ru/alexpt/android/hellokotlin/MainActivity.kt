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
        if (mNameEditText.text.length == 0) {
            mHelloTextView.text = "Hello!"
        } else {
            mHelloTextView.text = "Привет, " + mNameEditText.text + "!"
        }
    }
}
