package ru.alexpt.android.itprogerlesson5;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn, btn2, btn_alert, act_change;
    private RatingBar rating;
    private TextView text_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        pass = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn_alert = (Button) findViewById(R.id.alert);
        act_change = (Button) findViewById(R.id.act_change);

        // В всплывающей подсказке выводим введенное пользователем значение и меняем цвет фона и текста первой кнопки
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btn.setText("The End");
                        btn.setBackgroundColor(Color.GRAY);
                        Toast.makeText(
                                MainActivity.this, pass.getText(),
                                Toast.LENGTH_SHORT
                        ).show();
                        // выводим вторую всплывающую подсказку
                        Toast.makeText(
                                MainActivity.this, R.string.end_text,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
        // Меняем цвет текста и цвет фона первой кнопки при нажатии на вторую, а также выводим другую всплывающую подсказку
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btn2.setText("ok");
                        btn.setBackgroundColor(Color.BLUE);
                        btn.setTextColor(Color.WHITE);
                        Toast.makeText(
                                MainActivity.this, R.string.btn2_text,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        btn_alert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Создаем строитель всплывающих окон методом Builder
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        // Создаем всплывающее окно методом setMessage и после сообщения через точку добавляем свойства
                        a_builder.setMessage("Вы хотите закрыть приложение?")
                                .setCancelable(false)
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish(); // при нажатии "Да" функция полностью закрывает приложение
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel(); // нажатием "Нет" закрываем диалоговое окно
                                    }
                                });
                        // Создаем непосредственно само всплывающее окно
                        AlertDialog alert = a_builder.create(); // .create() - метод создания всплывающих окон
                        alert.setTitle("Закрытие приложения");  // сообщение
                        alert.show(); // функция показа всплывающего окна
                    }
                }
        );

        // Работаем с рейтингом (RatingBar) - добавим его в activity
        // выше добавляем новую переменную RatingBar и TextView
        rating = (RatingBar)findViewById(R.id.ratingBar);
        text_show = (TextView)findViewById(R.id.textView);

        // к rating добавляем функцию, которая будет срабатывать при изменении рейтинга
        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener(){
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text_show.setText("Значение: " + String.valueOf(rating));
                    }
                }
        );

        // Переходим на вторую страницу
        act_change.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // создаем объект класса Intent с параметром новой страницы
                        Intent intent = new Intent("ru.alexpt.android.itprogerlesson5.SecondActivity");
                        startActivity(intent);
                    }
                }
        );
    }
}
