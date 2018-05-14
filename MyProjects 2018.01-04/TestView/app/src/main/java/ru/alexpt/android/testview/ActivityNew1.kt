package ru.alexpt.android.testview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityNew1 : AppCompatActivity() {

    internal lateinit var mText: TextView
    internal lateinit var mEl1: EditText
    internal lateinit var mEl2: EditText
    internal lateinit var mDel: Button
    internal lateinit var mAdd: Button
    internal lateinit var mToastAdd: Toast
    internal lateinit var mRs: Button
    internal lateinit var mRl: Button
    internal lateinit var mSin: Button
    internal lateinit var mCos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new1)

        mText = findViewById(R.id.Result)
        mEl1 = findViewById(R.id.num1)
        mEl2 = findViewById(R.id.num2)
        mDel = findViewById(R.id.delete)
        mAdd = findViewById(R.id.add)
        mRs = findViewById(R.id.rs)
        mRl = findViewById(R.id.rl)
        mSin = findViewById(R.id.sin)
        mCos = findViewById(R.id.cos)

        intent = Intent(this, ActivityNew2::class.java)
        mToastAdd = Toast.makeText(this, "Переход выполнен", Toast.LENGTH_SHORT)

        mAdd.setOnClickListener({
            startActivity(intent)
            mToastAdd.show()
        })
    }

    // Реализация калькулятора
    @SuppressLint("SetTextI18n")
    fun onClickSum(view: View){         // Сумма двух чисел
        blackColor(view)
        // Текстовое поле преобразовываем в число и помещаем в переменную типа int
        // значение текстового элемента приводим к строке и далее в число
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resText = num1 + num2
        mText.text ="Сумма двух чисел: $resText"
    }

    fun onClickDiff(view: View){        // Разность двух чисел
        blackColor(view)
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resText = num1 - num2
        mText.text ="Разность двух чисел: $resText"
    }

    fun exponentiation(view: View){        // Возведение в степень
        val num1 = (Integer.parseInt(mEl1.text.toString())).toDouble()
        val num2 = (Integer.parseInt(mEl2.text.toString())).toDouble()

        val resText = Math.pow(num1, num2)
        val str = String.format("%.2f", resText)
        val num = num2.toInt()

        blackColor(view)
        when(num2){
            2.0 -> mText.text = "Квадрат числа: $str"
            3.0 -> mText.text = "Куб числа: $str"
            else -> mText.text = "Число в $num-ой степени: $str"
        }
    }

    fun onMultiply(view: View){         // Функция умножения
        blackColor(view)
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resText = num1.toLong() * num2
        mText.text = "Произведение двух чисел: $resText"
    }

    fun noCorrect(view: View){          // Индикация ввода некорректного значения
        val mToast = Toast.makeText(this, "Color red!", Toast.LENGTH_SHORT)
        mText.setTextColor(Color.RED)
        mToast.show()
        mText.text = "Incorrect value"
    }

    fun blackColor(view: View){         // Функция начального цвета вывода текста
        val mToast = Toast.makeText(this, "Color black!", Toast.LENGTH_SHORT)
        mText.setTextColor(Color.BLACK)
        mDel.setTextColor(Color.BLACK)
        mToast.show()
    }

    fun onDivide(view: View){           // Функция деления
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        if(num2 == 0){
            noCorrect(view)
        } else {
            blackColor(view)
            val resText = num1.toDouble() / num2
            val str = String.format("%.2f", resText)
            mText.text = "Частное двух чисел: $str"
        }
    }

    fun onClickNull(view: View){        // Очистим поле ввода EditText и вывода
        val mToast = Toast.makeText(this, "Поле очищено!", Toast.LENGTH_SHORT)
        mEl1.text = null
        mEl2.text = null
        mText.text = "Поле очищено"
        mText.setTextColor(Color.DKGRAY)
        mDel.setTextColor(Color.GRAY)
        mToast.show()
    }

    fun onRoot(view: View){             // Корень квадратный числа
        blackColor(view)
        val num1 = (Integer.parseInt(mEl1.text.toString())).toDouble()

        val resText = Math.sqrt(num1)
        val str = String.format("%.3f", resText)
        mText.text = "Корень квадратный числа: $str"
    }

    fun onArea(view: View){             // Площадь прямоугольника /квадрата/
        blackColor(view)
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resText = num1 * num2

        when(num1){
            num2 -> mText.text = "Площадь квадрата: $resText кв.ед."
            else -> mText.text = "Площадь прямоугольника: $resText кв.ед."
        }
    }

    fun perimeter(view: View){          // Периметр прямоугольника /квадрата/
        blackColor(view)
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resText = num1 * 2 + num2 * 2

        when(num1){
            num2 -> mText.text = "Периметр квадрата: $resText ед."
            else -> mText.text = "Периметр прямоугольника: $resText ед."
        }
    }

    fun hypotenuse(view: View){         // Длина гипотенузы
        blackColor(view)
        val num1 = (Integer.parseInt(mEl1.text.toString())).toDouble()
        val num2 = (Integer.parseInt(mEl2.text.toString())).toDouble()

        val resText = Math.hypot(num1, num2)
        val str = String.format("%.2f", resText)
        mText.text = "Длина гипотенузы: $str ед."
    }

    fun onFourButtons(view: View){
        val R = (Integer.parseInt(mEl1.text.toString())).toDouble()
        val resText: Double
        val str: String

        when(view){
            mRs -> {blackColor(view)                // Площадь круга
                resText = Math.PI * Math.pow(R, 2.0)
                str = String.format("%.2f", resText)
                mText.text = "Площадь круга при R = $R: \n$str кв.ед."}
            mRl -> {blackColor(view)                // Длина окружности
                resText = 2 * Math.PI * R
                str = String.format("%.2f", resText)
                mText.text = "Длина окружности при R = $R: \n$str ед."}
            mSin -> {if(R > 360){                   // Синус угла
                noCorrect(view)
            } else {
                blackColor(view)
                resText = Math.sin(R)
                str = String.format("%.3f", resText)
                mText.text = "sin $R град.: $str" }}
            mCos -> {if(R > 360){                   // Косинус угла
                noCorrect(view)
            } else {
                blackColor(view)
                resText = Math.cos(R)
                str = String.format("%.3f", resText)
                mText.text = "cos $R град.: $str" }}
        }
    }

    fun onReturn1(view: View){                      // Возврат на главный экран
        val mToast = Toast.makeText(this, "Возврат на главный экран выполнен", Toast.LENGTH_SHORT)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        mToast.show()
    }
}
