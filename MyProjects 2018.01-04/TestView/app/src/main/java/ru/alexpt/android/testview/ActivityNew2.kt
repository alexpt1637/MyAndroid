package ru.alexpt.android.testview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast


class ActivityNew2 : AppCompatActivity() {

    var resultField: TextView? = null       // текстовое поле для вывода результата
    var numberField: EditText? = null       // поле для ввода числа
    var operationField: TextView? = null    // текстовое поле для вывода знака операции
    var operand: Double? = null             // операнд операции
    var lastOperation = "="                 // последняя операция

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new2)

        // получаем все поля по id из activity_new2.xml
        resultField = findViewById(R.id.resultField)
        numberField = findViewById(R.id.numberField)
        operationField = findViewById(R.id.operationField)
    }

    // сохранение состояния
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("OPERATION", lastOperation)
        if (operand != null)
            outState.putDouble("OPERAND", operand!!)
        super.onSaveInstanceState(outState)
    }

    // получение ранее сохраненного состояния
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lastOperation = savedInstanceState.getString("OPERATION")
        operand = savedInstanceState.getDouble("OPERAND")
        resultField!!.setText(operand.toString())
        operationField!!.setText(lastOperation)
    }

    // обработка нажатия на числовую кнопку
    fun onNumberClick(view: View) {

        val button = view as Button
        numberField!!.append(button.getText())

        if (lastOperation.equals("=") && operand != null) {
            operand = null
        }
    }

    // обработка нажатия на кнопку операции
    fun onOperationClick(view: View) {

        val button = view as Button
        val op = button.text.toString()
        var number = numberField!!.getText().toString()
        // если введенно что-нибудь
        if (number.length > 0) {
            number = number.replace(',', '.')
            try {
                performOperation(java.lang.Double.valueOf(number), op)
            } catch (ex: NumberFormatException) {
                numberField!!.setText("")
            }
        }
        lastOperation = op
        operationField!!.setText(lastOperation)
    }

    private fun performOperation(number: Double?, operation: String) {

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if (operand == null) {
            operand = number
        } else {
            if (lastOperation.equals("=")) {
                lastOperation = operation
            }
            when (lastOperation) {
                "=" -> operand = number
                "/" -> if (number == null) {
                    operand = 0.0
                } else {
                    operand!! / number
                }
                "*" -> operand!! * number!!
                "+" -> operand!! + number!!
                "-" -> operand!! - number!!
            }
        }
        resultField!!.setText(operand.toString().replace('.', ','))
        numberField!!.setText("")
    }

    fun del(view: View){
        val mToast = Toast.makeText(this, "Поле очищено!", Toast.LENGTH_SHORT)
        numberField!!.text = null
        operationField!!.text = null
        resultField!!.text = null
        mToast.show()
    }
}
