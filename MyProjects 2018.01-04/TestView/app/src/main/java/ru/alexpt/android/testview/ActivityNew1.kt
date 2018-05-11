package ru.alexpt.android.testview

import android.annotation.SuppressLint
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new1)

        mText = findViewById(R.id.Result)
        mEl1 = findViewById(R.id.num1)
        mEl2 = findViewById(R.id.num2)
        mDel = findViewById(R.id.delete)
    }

    // Реализация калькулятора
    @SuppressLint("SetTextI18n")
    fun onClickSum(view: View){         // Сумма двух чисел
        blackColor(view)
        // Поля ввода данных
        val el1 = findViewById(R.id.num1) as EditText
        val el2 = findViewById(R.id.num2) as EditText

        // Текстовое поле результата вычислений
        val resText = findViewById(R.id.Result) as TextView

        // Текстовое поле преобразовываем в число и помещаем в переменную типа int
        val num1 = Integer.parseInt(el1.text.toString()) // значение текстового элемента приводим к строке и далее в число
        val num2 = Integer.parseInt(el2.text.toString())

        val resSum = num1 + num2
        // Помещаем в текстовое поле результата вычисления
        resText.text ="Сумма двух чисел: " + Integer.toString(resSum)  // число преобразовываем в строку для текстового поля
        // Далее в acrivity_maim связываем функцию с кнопкой (в поле onClick выбираем метод onButtonClick)
    }

    fun onClickDiff(view: View){        // Разность двух чисел
        blackColor(view)
        // Текстовое поле преобразовываем в число и помещаем в переменную типа int
        // значение текстового элемента приводим к строке и далее в число
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resDiff = num1 - num2
        // Помещаем в текстовое поле результата вычисления
        // число преобразовываем в строку для текстового поля
        mText.text ="Разность двух чисел: " + Integer.toString(resDiff)
        // Далее в acrivity_maim связываем функцию с кнопкой (в поле onClick выбираем метод onButtonClick)
    }

    fun exponentiation(view: View){        // Возведение в степень
        val num1 = (Integer.parseInt(mEl1.text.toString())).toDouble()
        val num2 = (Integer.parseInt(mEl2.text.toString())).toDouble()

        val resText = (Math.pow(num1, num2)).toInt()
        val num = num2.toInt()

        if(resText < 2147483647){                       // Int <= 2147483647
            blackColor(view)
            when(num2){
                2.0 -> mText.text = "Квадрат числа: " + Integer.toString(resText)
                3.0 -> mText.text = "Куб числа: " + Integer.toString(resText)
                else -> mText.text = "Число в $num-ой степени: " + Integer.toString(resText)
            }
        } else {
            noCorrect(view)
        }
    }

    fun onMultiply(view: View){         // Функция умножения
        blackColor(view)
        // значение текстового элемента приводим к строке и далее в число
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        val resText = num1 * num2

        if(resText < 2147483647 && resText > 0) {
            mText.text = "Произведение двух чисел: " + Integer.toString(resText)
        } else {
            noCorrect(view)
        }
    }

    fun noCorrect(view: View){          // Индикация ввода некорректного значения
        val mToast = Toast.makeText(this, "Color red!", Toast.LENGTH_SHORT)
        mText.setTextColor(Color.RED)
        mToast.show()
        mText.text = "Incorrect value"
    }

    fun blackColor(view: View){         // Функция начального цвета вывода текста
        val mToast = Toast.makeText(this, "Color bkack!", Toast.LENGTH_SHORT)
        mText.setTextColor(Color.BLACK)
        mDel.setTextColor(Color.BLACK)
        mToast.show()
    }

    fun onDivide(view: View){           // Функция деления
        // значение текстового элемента приводим к строке и далее в число
        val num1 = Integer.parseInt(mEl1.text.toString())
        val num2 = Integer.parseInt(mEl2.text.toString())

        if(num2 == 0){
            noCorrect(view)
        } else {
            blackColor(view)
            val resText = num1 / num2
            mText.text = "Целое частное двух чисел: " + Integer.toString(resText)
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
}
