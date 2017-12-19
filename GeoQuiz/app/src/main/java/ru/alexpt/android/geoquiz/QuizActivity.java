package ru.alexpt.android.geoquiz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    // Создаем переменные для кнопок True и False
    private Button mTrueButton;
    private Button mFalseButton;
    // Добавляем переменные для TextView и новой кнопки
    private Button mNextButton;
    private TextView mQuestionTextView;

    // Создаем массив объектов Question и переменную для индекса массива int mCurrentIndex
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;  // Начальное значение переменной для индекса массива
    // Программа несколько раз вызывает конструктор Question и создает массив объектов Question (для простоты)

    private void updateQuestion() {
        // Инкапсулируем это действие в методе updateQuestion() так как ниже оно повторяется два раза
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    // Проверяем правильность ответа пользователя методом checkAnswer()
    // Метод получает логическую переменную, которая указывает какую кнопку нажал пользователь: True или False
    // Ответ пользователя проверяется по ответу текущего объекта Question
    // После определения правильности ответа метод создает уведомление для вывода сответствующего сообщения
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTtue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    // Включаем в слушателя кнопки True и False вызов метода checkAnswer(boolean)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Далее получаем ссылки на TextView и задаем тексту виджета вопрос с текущим индексом
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        // Инкапсулируем это действие в методе updateQuestion() так как оно повторяется два раза
        /*int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);*/

        // До реализации кнопки Next на экране должен отображаться первый вопрос

        // Убираем (комментируем) лишнее:
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        // Получаем ссылки на виджеты
        mTrueButton = (Button) findViewById(R.id.true_button);
        // Назначаем слушателей
        // Слушатель реализован в виде анонимного внутреннего класса
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Для продолжения возвращаемся к файлу strings.xml и добавляем строковые ресурсы уведомлений
                // Выше в теле метода уведомление создается вызовом метода класса Toast

                // Включаем в слушателя кнопки True и False вызов метода checkAnswer(boolean)
                /*Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();*/
                checkAnswer(true);
                }
        });

        // Получаем ссылки на виджеты для следующей кнопки
        mFalseButton = (Button) findViewById(R.id.false_button);
        // Реализуем слушателя для следующей кнопки
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Включаем в слушателя кнопки True и False вызов метода checkAnswer(boolean) - прорамма готова!
                /*Toast.makeText(QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();*/
                checkAnswer(false);
            }
        });

        // Создаем class Question, в нем создаем два вида данных: текст вопроса и правильный ответ (да/нет)

        // После задания тексту виджета вопроса с текущим индексом подключаем новую кнопку 'Next'
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Значение переменной для индекса массива увеличивается на единицу
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                // Инкапсулируем это действие в методе updateQuestion() так как оно повторяется два раза
                /*int question = mQuestionBank[mCurrentIndex].getTextResId();
                mQuestionTextView.setText(question);*/
                updateQuestion();
            }
        });

        updateQuestion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
