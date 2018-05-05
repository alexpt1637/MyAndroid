package ru.alexpt.android.geoquiz;

/**
 * Created by ACERa on 19.12.2017.
 */

// Класс Question содержит два вида данных: текст вопроса и правильный ответ (да/нет)
public class Question {

    private int mTextResId;     // поле хранит идентификатор строкового ресурса(типа int) с текстом вопроса
    private boolean mAnswerTtue;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTtue = answerTrue;
    }

    // Для переменных необходимо определить get- и set- методы
    // Настроим Android Studio на распознавание префикса m в полях классов для правильной генерации имени метода
    // File > Settings > Editor > Code Style > Java > Code Generation
    // В таблице Naming: Name prefix: Field -> m, Static field -> s, ---> OK
    // Правой кнопкой мыши выбираем команду Generate > Getter And Setter

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTtue() {
        return mAnswerTtue;
    }

    public void setAnswerTtue(boolean answerTtue) {
        mAnswerTtue = answerTtue;
    }

    // Класс Question готов, далее для работы с ним вносим изменения в QuizActivity
    // Класс QuizActivity должен создать массив объектов Question
    // Диаграмма объектов GeoQuiz:
    // Модель (TrueFalse) <-- Контроллер (QuizActivity) --> Представление/макет (TextView, Button)
    // Объекты модели и представления не взаимодействуют напрямую, только через контроллер (разделение уровней)

    // Вносим изменения в файл макета представлений --> activity(content)_quiz.xml (Добавляем новую кнопку), для чего:
    // Удаляем атрибут android:text из TextView, назначаем ему атрибут android:id, добавляем новый Button как потомка корневого элемента LinearLayout

}
