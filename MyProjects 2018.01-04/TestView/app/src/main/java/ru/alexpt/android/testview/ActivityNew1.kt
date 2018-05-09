package ru.alexpt.android.testview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivityNew1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new1)

        val mEdtextIn: EditText = findViewById(R.id.edtext_in)
        var mTextOn: TextView = findViewById(R.id.textView)
        val mEncode: Button = findViewById(R.id.button_encode)
        val mDecrypt: Button = findViewById(R.id.button_decrypt)

        mEncode.setOnClickListener({
            mTextOn.setTextColor(Color.RED)
        })
    }
}
