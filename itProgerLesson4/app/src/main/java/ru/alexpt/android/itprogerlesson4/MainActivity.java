package ru.alexpt.android.itprogerlesson4;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Метод для реализации калькулятора с одной кнопкой "+"
    @SuppressLint("SetTextI18n")
    public void onButtonClick (View v) {
        // Поля ввода данных
        EditText el1 = (EditText)findViewById(R.id.num1);
        EditText el2 = (EditText)findViewById(R.id.num2);

        // Текстовое поле результата вычислений
        TextView resText = (TextView)findViewById(R.id.Result);

        // Текстовое поле преобразовываем в число и помещаем в переменную типа int
        int num1 = Integer.parseInt(el1.getText().toString()); // значение текстового элемента приводим к строке и далее в число
        int num2 = Integer.parseInt(el2.getText().toString());

        int resSum = num1 + num2;
        // Помещаем в текстовое поле результата вычисления
        resText.setText(Integer.toString(resSum));  // число преобразовываем в строку для текстового поля
        // Далее в acrivity_maim связываем функцию с кнопкой (в поле onClick выбираем метод onButtonClick)
    }
}
